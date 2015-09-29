/******************************************************************************/
/* SAX.hpp           	                                                 	  */
/******************************************************************************/

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _SAX_HPP_
#define _SAX_HPP_

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include <QXmlDefaultHandler>
#include "util/Vertex.hpp"
#include "geom/Polygon.hpp"

/******************************************************************************/
/* Enumerations																  */
/******************************************************************************/

enum tag { X, Y };                                       /* <x>- oder <y>-Tag */

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@author Patrick Vogt
*
*	@brief ein eigener SAX-Parser, der eine vom Programm abgespeicherte und 
*	konforme Datei einlesen kann
*/
class SAX: public QXmlDefaultHandler 
{
private:

	/**
	*	@brief Zeiger auf das eingelesene Polygon
	*/
	Polygon *input;
	
	/**
	*	@brief temporaere x-Koordinate
	*/
	double tmpX;
	
	/**
	*	@brief temporaere y-Koordinate
	*/
	double tmpY;

	/**
	*	@brief speichert, ob das letzte Tag ein \<x> oder \<y> war
	*/
	enum tag lastTag;

public:

	/**
	*	@brief Konstruktor
	*
	*	erzeugt einen neuen SAX-Parser und liest automatisch die Datei
	*	mit dem uebergebenen Pfad/-Dateinamen ein
	*
	*	@param filename Dateiname, der XML-Datei, die eingelesen werden soll
	*/	SAX(QString &filename);
	
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
	virtual bool startElement(const QString &namespaceURI, 
		const QString &localName, const QString &qName, 
		const QXmlAttributes &attributes);
		
	/**
	*	@brief erkennt jede Folge von Buchstaben und verarbeitet diese
	*	entsprechend		
	*
	*	@param ch eingelesene Folge von Buchstaben (String)
	*
	*	@return immer 'true'
	*/
  	virtual bool characters(const QString &ch);
  	
  	/**
	*	@brief erkennt jedes schließende Tag und verarbeitet dieses entsprechend	
	*
	*	@param namespaceURI the namespace URI
	*	@param localName the local name (without prefix)
	*	@param qName qualified (tag-)name
	*	
	*	@return immer 'true'
	*/
  	virtual bool endElement(const QString &namespaceURI, 
  		const QString &localName, const QString &qName);
  	
  	/**
	*	@brief gibt das ge'parste' <em>Polygon</em> zurueck		
	*
	*	@return das Polygon, welches aus der XML-Datei erzeugt wurde
	*/
	Polygon *getParsedPolygon();
  
};
#endif /* _SAX_HPP_ */
