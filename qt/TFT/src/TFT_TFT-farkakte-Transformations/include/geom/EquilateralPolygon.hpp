/******************************************************************************/
/* EquilateralPolygon.cpp  	                                                  */
/******************************************************************************/

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _EQUILATERALPOLYGON_HPP_
#define _EQUILATERALPOLYGON_HPP_

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "Polygon.hpp"
#include "util/Vertex.hpp"
#include <cmath>

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@author Patrick Vogt
*
*	@brief Gleichseitiges Polygon (Vieleck)
*/
class EquilateralPolygon: public Polygon
{
private:

protected:
	
public:
	/**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>EquilateralPolygon</em>
	*
	*	@param x x-Korrdinate
	*	@param y y-Korrdinate 
	*	@param width Breite und Hoehe
	*	@param n Anzahl der Kanten
	*/
	EquilateralPolygon(const double x, const double y, const double width, 
		const int n);
		
	//EquilateralPolygon(const EquilateralPolygon & rhs);
	
	/**
	*	@brief Destruktor
	*
	*	loescht ein Objekt vom Typ <em>EquilateralPolygon</em>
	*/
	virtual ~EquilateralPolygon();
};

#endif /* _EQUILATERALPOLYGON_HPP_ */
