/******************************************************************************/
/* Circle.hpp           	                                                  */
/******************************************************************************/ 

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _CIRCLE_HPP_
#define _CIRCLE_HPP_

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "EquilateralPolygon.hpp"

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@author Patrick Vogt
*
*	@brief Ein Kreis ist an ein gleichseitiges Vieleck (engl. 
*	<em>EquiateralPolygon</em>) angenaehert
*/
class Circle: public EquilateralPolygon
{
private:
	/**
	*	@brief Anzahl der Ecken eines Kreises
	*/
	static const unsigned int edges=50;

protected:

public:
	/**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>Circle</em>
	*
	*	@param x x-Korrdinate
	*	@param y y-Korrdinate 
	*	@param diameter Durchmesser
	*/
	Circle(const int x, const int y, const int diameter);
	
	//Circle(const Circle &rhs);
	
	/**
	*	@brief Desktruktor
	*
	*	loescht ein Objekt vom Typ <em>Circle</em>
	*/
	virtual ~Circle();
};

#endif /* _CIRCLE_HPP_ */
