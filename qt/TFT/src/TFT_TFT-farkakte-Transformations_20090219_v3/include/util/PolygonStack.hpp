/******************************************************************************/
/* PolygonStack.hpp           	                                              */
/******************************************************************************/ 

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _POLYGONSTACK_HPP_
#define _POLYGONSTACK_HPP_

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "geom/Polygon.hpp"
#include "util/Node.hpp"

/**
*	@author Patrick Vogt
*
*	@brief Stack, der Polygone speichern kann
*/
class PolygonStack
{
private:
	/**
	*	@brief Zeiger auf den Kopf des Stacks
	*/
	Node *head;
	
protected:

public:
	/**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>PolygonStack</em>
	*/
	PolygonStack();
	
	//PolygonStack(const Polygon &rhs);
	
	/**
	*	@brief Desktruktor
	*
	*	loescht ein Objekt vom Typ <em>PolygonStack</em>
	*/
	virtual ~PolygonStack();

	/**
	*	@brief gibt das oberste Polygon des Stacks zurueck
	*
	*	Achtung: Das oberste Element wird hierbei nicht aus dem Stack enfernt
	*
	*	@return Zeiger auf das oberste Polygon des Stacks
	*/
	Polygon *top() const;
	
	/**
	*	@brief gibt das oberste Polygon des Stacks zurueck und loescht dieses
	*	aus dem Stack
	*
	*	@return Zeiger auf das oberste Polygon des Stacks
	*/
	Polygon *pop();	
	
	/**
	*	@brief fuegt ein neues uebergebe Polygon auf den Stack
	*
	*	@param p das zu speichernde Polygon
	*/
	void push(Polygon *p);
	
	/**
	*	@brief gibt zurueck, ob der Stack leer ist
	*
	*	@return ob der Stack leer ist
	*/
	bool isEmpty() const;

};

#endif /* _POLYGONSTACK_HPP_ */
