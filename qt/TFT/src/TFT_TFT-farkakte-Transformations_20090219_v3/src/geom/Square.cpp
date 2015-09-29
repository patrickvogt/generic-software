/******************************************************************************/
/* Square.cpp           	                                                  */
/******************************************************************************/

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "geom/Square.hpp"

/******************************************************************************/
/* Klassendefinition														  */
/******************************************************************************/

/**
*	@brief Konstruktor
*
*	erzeugt ein neues Objekt vom Typ <em>Square</em>,
*	welches eine leere Liste von Punkten enthält
*
*/
Square::Square(const int x, const int y, const int width)
	:Rectangle(x,y,width,width) /* Kontstruktor von Rectangle aufrufen */
{

}

/**
*	@brief Destruktor
*
*	loescht ein Objekt vom Typ <em>Square</em>	
*/
Square::~Square()
{

}
