/******************************************************************************/
/* Polygon.hpp           	                                                  */
/******************************************************************************/

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _POLYGON_HPP_
#define _POLYGON_HPP_

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "util/VertexLi.hpp"
#include "util/Matrix.hpp"
#include "util/WriteAsXML.hpp"
#include "util/WriteAsSVG.hpp"
#include <QPainter>

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@author Patrick Vogt
*
*	@brief Polygon, welches aus einer liste von Punkten besteht
*/
class Polygon: public ToString, public WriteAsXML, public WriteAsSVG
{
private:

protected:
	/**
	*	@brief Liste mit allen zum Polygon gehoerenden Punkten
	*/
	VertexLi *points;

public:
	/**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>Polygon</em>,
	*	welches eine leere Liste von Punkten enthält
	*
	*/
	Polygon();
	
	/**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>Polygon</em>
	*
	*	@param points zum Polygon gehoerende <em>Vertex</em>-Liste	
	*/
	Polygon(VertexLi *points);
	
	//Polygon(const Polygon &rhs);
	
	/**
	*	@brief Destruktor
	*
	*	loescht ein Objekt vom Typ <em>Polygon</em>	
	*/
	virtual ~Polygon();
	
	/**
	*	@brief gibt den absoluten Mittelpunkt des Polygons zurueck
	*	
	*	@param positiv gibt an, ob der Mittelpunkt als (x,y) oder (-x,-y) 
	*	zurueckgegeben werden soll
	*
	*	@return den absoluten Mittelpunkt des Poylgons
	*/
	Vertex getCenterABS(const bool positiv) const;
	
	/**
	*	@brief gibt den relativen Mittelpunkt des Polygons zurueck
	*	
	*	@param positiv gibt an, ob der Mittelpunkt als (x,y) oder (-x,-y) 
	*	zurueckgegeben werden soll
	*
	*	@return den relativen Mittelpunkt des Poylgons
	*/
	Vertex getCenterREL(const bool positiv) const;
	
	/**
	*	@brief gibt eine Kopie des Polygon im sichtbaren Bereich zurueck
	*
	*	Wichtig fuer die Ausgabe als SVG-Datei oder zum Drucken
	*
	*	@return eine Kopie des Polygon im sichtbaren Bereich
	*/
	Polygon *intoRampenlicht();
	
	/**
	*	@brief gibt die Liste mit den Punkten des Polygons zurueck
	*
	*	@return Punkte des Polygons
	*/
	VertexLi *getPoints();
	
	/**
	*	@brief gibt den ersten Punkt des Polygons zurueck
	*
	*	@return erster Punkt des Polygons
	*/
	const Vertex &first() const;
	
	/**
	*	@brief gibt den letzten Punkt des Polygons zurueck
	*
	*	@return letzter Punkt des Polygons
	*/
	const Vertex &last() const;
	
	/**
	*	@brief fuegt dem Polygon einen Punkt hinzu
	*
	*	@param v den hinzuzufuegenden Punkt
	*/
	void addPoint(const Vertex &v);
	
	/**
	*	@brief transformiert jeden Punkt des Polygons mit der uebergebenen 
	*	Matrix
	*
	*	@param m Matrix, die zum transformieren benutzt werden soll
	*/
	void transform(const Matrix &m);
	
	/**
	*	@brief zentriert das Polygon
	*/
	void centerThatPolygon();
	
	/**
	*	@brief konvertiert die Liste der Punkte des Polygons in ein QPoint-Array
	*
	*	@return ein QPointArray mit allen Punkten des Polygons
	*/
	virtual QPointF *toQPointFArray() const;
	
	/**
	*	@brief zeichnet das 'this'-Polygon auf dem uebergebenen QPainter-Objekt
	*
	*	@param painter QPainter-Objekt, auf dem das Polygon gezeichnet werden 
	*	soll
	*/
	void paintMe(QPainter &painter);
	
	/**
	*	@brief gibt das Polygon als ein String ( als { (x,y)....} ) aus
	*
	*	@return den String, der das Polygon repraesentiert
	*/
	virtual std::string toString() const;
	
	/**
	*	@brief gibt den minimalen X-Wert des Polygons zurueck
	*
	*	@return minimaler X-Wert einer Koordinate
	*/
	double getMinX() const;
	
	/**
	*	@brief gibt den minimalen Y-Wert des Polygons zurueck
	*
	*	@return minimaler Y-Wert einer Koordinate
	*/
	double getMinY() const;
	
	/**
	*	@brief gibt den maximalen X-Wert des Polygons zurueck
	*
	*	@return maximalen X-Wert einer Koordinate
	*/
	double getMaxX() const;
	
	/**
	*	@brief gibt den maximalen Y-Wert des Polygons zurueck
	*
	*	@return maximalen Y-Wert einer Koordinate
	*/
	double getMaxY() const;
	
	/**
	*	@brief gibt die Hoehe des Polygons zurueck
	*
	*	@return Hoehe des Polygons
	*/
	double getHeight() const;
	
	/**
	*	@brief gibt die Weite des Polygons zurueck
	*
	*	@return Weite des Polygons
	*/
	double getWidth() const;
	
	/**
	*	@brief schreibt das Polygon als XML in den uebergebenen Zielstream
	*	
	*	@param dest Zielstream der XML-Datei
	*/	
	void writeXML(std::fstream &dest) const;
	
	/**
	*	@brief schreibt das Polygon als SVG in den uebergebenen Zielstream
	*	
	*	@param dest Zielstream der SVG-Datei
	*/	
	void writeSVG(std::fstream &dest) const;

};


#endif /* _POLYGON_HPP_ */
