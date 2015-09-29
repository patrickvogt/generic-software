/******************************************************************************/
/* Square.hpp           	                                                  */
/******************************************************************************/ 

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _SQUARE_HPP_
#define _SQUARE_HPP_

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "Rectangle.hpp"

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@author Patrick Vogt
*
*	@brief <em>Square</em> ist ein <em>Rectangle</em> mit gleicher Weite und 
*	Hoehe
*/
class Square: public Rectangle
{
private:

protected:

public:

	/**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>Square</em>,
	*	welches eine leere Liste von Punkten enthält
	*
	*/
	Square(const int x, const int y, const int width);
	
	//Square(const Square &rhs);
	
	/**
	*	@brief Destruktor
	*
	*	loescht ein Objekt vom Typ <em>Square</em>	
	*/
	virtual ~Square();

};

#endif /* _SQUARE_HPP_ */
