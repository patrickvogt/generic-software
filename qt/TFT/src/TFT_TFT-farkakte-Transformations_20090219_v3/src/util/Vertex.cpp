/******************************************************************************/
/* Vertex.cpp           	                                                  */
/******************************************************************************/

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "util/Vertex.hpp"
#include <iostream>

/******************************************************************************/
/* Klassendefinition														  */
/******************************************************************************/

/**
*	@brief Konstruktor
*
*	erzeugt ein neues Objekt vom Typ <em>Vertex</em>
*
*	@param x x-Korrdinate
*	@param y y-Korrdinate 
*/
Vertex::Vertex(const double x, const double y)
	:x(x),y(y) 
{

}

/**
*	@brief Kopier-Konstruktor
*
*	kopiert ein Objekt vom Typ <em>Vertex</em>
*
*	@param rhs der zu kopierende Vertex
*/
Vertex::Vertex(const Vertex &rhs)
	:ToString::ToString(), WriteAsXML::WriteAsXML(), WriteAsSVG::WriteAsSVG(),
		x(rhs.getX()), y(rhs.getY())
{

}

/**
*	@brief Desktruktor
*
*	loescht ein Objekt vom Typ <em>Circle</em>
*/
Vertex::~Vertex() 
{

}

/**
*	@brief gibt die x-Koordinate des Vertexs zurueck
*
*	@return die x-Koordinate des Vertexs
*/
double Vertex::getX() const
{
	return this->x;
}

/**
*	@brief gibt die y-Koordinate des Vertexs zurueck
*
*	@return die y-Koordinate des Vertexs
*/
double Vertex::getY() const
{
	return this->y;
}

/**
*	@brief verschiebt den 'this'-Vertex um den uebergebenen Vertex
*
*	@param v der Verschiebevetrex
*/
void Vertex::move(const Vertex &v)
{
	this->x = this->x + v.getX();
	this->y = this->y + v.getY();
}

/**
*	@brief berechnet das arithmetische Mittel des Vertexs
*
*	@return das arithmetische Mittel des Vertexs
*/
double Vertex::arithMiddle() const
{
	return (this->x+this->y)/2;
}

/**
*	@brief rotiert den Punkt um 'angle_degree' Grad
*
*	@param angle_degree Winkel (in Grad), um den der Punkt verschoben werden
*	soll 
*
*	@return der rotierte Vertexs
*/
const Vertex Vertex::rotate(const double angle_degree) const
{
	const double angle_radiant=angle_degree*M_PI/180;
	
	                                          
	double a= cos(angle_radiant); 				 /* Rotationsmatrix erstellen */
	double b= -1*sin(angle_radiant);
	double c= sin(angle_radiant);
	double d= cos(angle_radiant);
	
	Vertex v = *this;
	
	return Vertex(	(a*v.x)+(b*v.y),					   /* Vertex rotieren */
					(c*v.x)+(d*v.y)	);
}

/**
*	@brief gibt einen String zurueck, der den Vertex repraesentiert
*
*	@return der String, der den Vertex repraesentiert
*/
std::string Vertex::toString() const
{
	std::string result ="(";
	result=result+this->x+","+this->y+")";
	return result;
}

/**
*	@brief ueberladener ==-Operator, der zwei Vertexe komponentenweise 
*	vergleicht
*
*	@param that Vertex mit dem der 'this'-Vertex verglichen werden soll
*
*	@return ob die beiden Vertexe sich gleichen
*/
bool Vertex::operator==(const Vertex &that) const
{
	if(this->x==that.x && this->y==that.y) {
		return true;
	}
	return false;
}

/**
*	@brief ueberladener ~-Operator, der zwei Vertexe komponentenweise 
*	mit einer gewissen Toleranz vergleicht
*
*	@param that Vertex mit dem der 'this'-Vertex verglichen werden soll
*
*	@return ob die beiden Vertexe sich ungefaehr gleichen
*/
bool Vertex::operator>=(const Vertex &that) const
{
	static double eps = 3.51;

	if(this->x+eps > that.x 
		&& this->x-eps < that.x 
		&& this->y+eps > that.y 
		&& this->y-eps < that.y) {
		return true;
	}
	return false;
}

/**
*	@brief ueberladener ~-Operator, der zwei Vertexe komponentenweise 
*	mit einer gewissen Toleranz vergleicht
*
*	@param that Vertex mit dem der 'this'-Vertex verglichen werden soll
*
*	@return ob die beiden Vertexe sich ungefaehr gleichen
*/
bool Vertex::operator<=(const Vertex &that) const
{
	return *(this) >= that;
}

/**
*	@brief schreibt den Vertex als XML in den Zielstream
*
*	@param dest Zielstream der XML-Datei
*/
void Vertex::writeXML(std::fstream &dest) const
{
	dest << "<vertex>" << "<x>" << this->x << "</x>"
	<< "<y>" << this->y << "</y>" << "</vertex>" << std::endl;
}

/**
*	@brief schreibt den Vertex als SVG in den Zielstream
*
*	@param dest Zielstream der SVG-Datei
*/
void Vertex::writeSVG(std::fstream &dest) const
{
	dest << this->x << " " << this->y << " ";
}
