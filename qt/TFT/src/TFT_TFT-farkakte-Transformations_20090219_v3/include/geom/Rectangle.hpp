/******************************************************************************/
/* Rectangle.hpp           	                                                  */
/******************************************************************************/ 

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _RECTANGLE_HPP_
#define _RECTANGLE_HPP_

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "Polygon.hpp"

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@author Patrick Vogt
*
*	@brief repraesentiert ein Rechteck mit unterschiedlicher Weite und Hoehe
*/
class Rectangle: public Polygon
{
private:

protected:

public:
	/**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>Rectangle</em>
	*
	*	@param x x-Koordinate
	*	@param y y-Koordinate
	*	@param width Weite
	*	@param height Hoehe
	*/
	Rectangle(const int x, const int y, const int width, const int height);
	
	//Rectangle(const Rectangle &rhs);
	
	/**
	*	@brief Destruktor
	*
	*	loescht ein Objekt vom Typ <em>Rectangle</em>	
	*/
	virtual ~Rectangle();
};

#endif /* _RECTANGLE_HPP_ */
