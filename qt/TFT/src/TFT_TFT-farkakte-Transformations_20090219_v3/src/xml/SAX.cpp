/******************************************************************************/
/* SAX.hpp           	                                                 	  */
/******************************************************************************/

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "xml/SAX.hpp"

/******************************************************************************/
/* Klassendefinition														  */
/******************************************************************************/

/**
*	@brief Konstruktor
*
*	erzeugt einen neuen SAX-Parser und liest automatisch die Datei
*	mit dem uebergebenen Pfad/-Dateinamen ein
*
*	@param filename Dateiname, der XML-Datei, die eingelesen werden soll
*/
SAX::SAX(QString &filename) 
{
	QFile file(filename);
	QXmlInputSource inputSource(&file);
	QXmlSimpleReader reader;
	reader.setContentHandler(this);             /* Als Handler 'this'-Handler */
	reader.setErrorHandler(this);
	reader.parse(inputSource);         /* Datei mit Namen 'filename' einlesen */
}

/**
*	@brief erkennt jedes oeffnende Tag und verarbeitet dieses entsprechend	
*
*	@param namespaceURI the namespace URI
*	@param localName the local name (without prefix)
*	@param qName qualified (tag-)name
*	@param attributes the attributes attached to the element
*	
*	@return immer 'true'
*/
bool SAX::startElement(const QString &namespaceURI, const QString &localName, 
	const QString &qName,  const QXmlAttributes &attributes) 
{
	(void) namespaceURI;           /* Warnung unbenutzer Parameter verhindern */
	(void) localName;
	(void) attributes;

	if(qName == "polygon")                                  /* TAG == POLYGON */
	{
		this->input = new Polygon();         /* neues Polygon-Objekt erzeugen */
	}
	else if(qName == "x") 
	{
		lastTag = X;     /* speichern, dass zuletzt ein <x>-Tag gelesen wurde */
	}
	else if(qName == "y") 
	{
		lastTag = Y;     /* speichern, dass zuletzt ein <x>-Tag gelesen wurde */
	}
	return true;
}

/**
*	@brief erkennt jedes schließende Tag und verarbeitet dieses entsprechend	
*
*	@param namespaceURI the namespace URI
*	@param localName the local name (without prefix)
*	@param qName qualified (tag-)name
*	
*	@return immer 'true'
*/
bool SAX::endElement(const QString &namespaceURI, const QString &localName, 
	const QString &qName)
{
	(void) namespaceURI;           /* Warnung unbenutzer Parameter verhindern */
	(void) localName;

	if(qName == "vertex")               /* Beschreibung eines Punkts zu Ende? */ 
	{
		Vertex v(this->tmpX, this->tmpY);           /* Punkt-Objekt erstellen */
		this->input->addPoint(v);             /* Punkt zu Polygon hinzufuegen */
	}
	return true;
}

/**
*	@brief erkennt jede Folge von Buchstaben und verarbeitet diese
*	entsprechend		
*
*	@param ch eingelesene Folge von Buchstaben (String)
*
*	@return immer 'true'
*/
bool SAX::characters(const QString &ch)
{
	bool ok=true;
	 
	if(X==this->lastTag)  /* Welches Tag wurde zuletzt gelesen? <x> oder <y>? */
	{ 	    
		this->tmpX=ch.toDouble(&ok);  /* x-Koordinate parsen und konvertieren */	
	}
	else if(Y==this->lastTag)
	{ 
		this->tmpY=ch.toDouble(&ok);  /* x-Koordinate parsen und konvertieren */    		
	}
	return true;
}

/**
*	@brief gibt das ge'parste' <em>Polygon</em> zurueck		
*
*	@return das Polygon, welches aus der XML-Datei erzeugt wurde
*/
Polygon *SAX::getParsedPolygon()
{
	return this->input;
}
