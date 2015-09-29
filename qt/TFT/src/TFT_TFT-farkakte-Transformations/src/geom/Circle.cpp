/******************************************************************************/
/* Circle.cpp           	                                                  */
/******************************************************************************/ 

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "geom/Circle.hpp"

/******************************************************************************/
/* Klassendefinition														  */
/******************************************************************************/

/**
*	@brief Konstruktor
*
*	erzeugt ein neues Objekt vom Typ <em>Circle</em>
*
*	@param x x-Korrdinate
*	@param y y-Korrdinate 
*	@param diameter Durchmesser
*/
Circle::Circle(const int x, const int y, const int diameter)
	:EquilateralPolygon(x,y,diameter,Circle::edges)
{

}

/**
*	@brief Desktruktor
*
*	loescht ein Objekt vom Typ <em>Circle</em>
*/
Circle::~Circle()
{

}
