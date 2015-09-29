/******************************************************************************/
/* Vertex.hpp           	                                                  */
/******************************************************************************/ 

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _VERTEX_HPP_
#define _VERTEX_HPP_

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include <string>
#include <cmath>
#include "ToString.hpp"
#include "WriteAsXML.hpp"
#include "WriteAsSVG.hpp"

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@author Patrick Vogt
*
*	@brief repraensiert einen Punkt im 2D-Raum (double)
*/
class Vertex: public ToString, public WriteAsXML, public WriteAsSVG
{
private:
	/**
	*	@brief x-Koordinate
	*/
	double x;
	
	/**
	*	@brief x-Koordinate
	*/
	double y;
	
protected:
	
public:
	/**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>Vertex</em>
	*
	*	@param x x-Korrdinate
	*	@param y y-Korrdinate 
	*/
	Vertex(const double x,const double y);
	
	/**
	*	@brief Kopier-Konstruktor
	*
	*	kopiert ein Objekt vom Typ <em>Vertex</em>
	*
	*	@param rhs der zu kopierende Vertex
	*/
	Vertex(const Vertex &rhs);
	
	/**
	*	@brief Desktruktor
	*
	*	loescht ein Objekt vom Typ <em>Circle</em>
	*/
	virtual ~Vertex();
	
	/**
	*	@brief gibt die x-Koordinate des Vertexs zurueck
	*
	*	@return die x-Koordinate des Vertexs
	*/	
	double getX() const;
	
	/**
	*	@brief gibt die y-Koordinate des Vertexs zurueck
	*
	*	@return die y-Koordinate des Vertexs
	*/
	double getY() const;
	
	/**
	*	@brief verschiebt den 'this'-Vertex um den uebergebenen Vertex
	*
	*	@param v der Verschiebevetrex
	*/
	void move(const Vertex &v);
	
	/**
	*	@brief berechnet das arithmetische Mittel des Vertexs
	*
	*	@return das arithmetische Mittel des Vertexs
	*/
	double arithMiddle() const;	
	
	/**
	*	@brief rotiert den Punkt um 'angle_degree' Grad
	*
	*	@param angle_degree Winkel (in Grad), um den der Punkt verschoben werden
	*	soll 
	*
	*	@return der rotierte Vertexs
	*/
	const Vertex rotate(const double angle_degree) const;
	
	/**
	*	@brief gibt einen String zurueck, der den Vertex repraesentiert
	*
	*	@return der String, der den Vertex repraesentiert
	*/
	std::string toString() const;
	
	/**
	*	@brief ueberladener ==-Operator, der zwei Vertexe komponentenweise 
	*	vergleicht
	*
	*	@param that Vertex mit dem der 'this'-Vertex verglichen werden soll
	*
	*	@return ob die beiden Vertexe sich gleichen
	*/
	bool operator==(const Vertex &that) const;
	
	/**
	*	@brief ueberladener ~-Operator, der zwei Vertexe komponentenweise 
	*	mit einer gewissen Toleranz vergleicht
	*
	*	@param that Vertex mit dem der 'this'-Vertex verglichen werden soll
	*
	*	@return ob die beiden Vertexe sich ungefaehr gleichen
	*/
	bool operator>=(const Vertex &that) const;
	
	/**
	*	@brief ueberladener ~-Operator, der zwei Vertexe komponentenweise 
	*	mit einer gewissen Toleranz vergleicht
	*
	*	@param that Vertex mit dem der 'this'-Vertex verglichen werden soll
	*
	*	@return ob die beiden Vertexe sich ungefaehr gleichen
	*/
	bool operator<=(const Vertex &that) const;
	
	/**
	*	@brief schreibt den Vertex als XML in den Zielstream
	*
	*	@param dest Zielstream der XML-Datei
	*/
	void writeXML(std::fstream &dest) const;
	
	/**
	*	@brief schreibt den Vertex als SVG in den Zielstream
	*
	*	@param dest Zielstream der SVG-Datei
	*/
	void writeSVG(std::fstream &dest) const;
};

#endif /* _VERTEX_HPP_ */
