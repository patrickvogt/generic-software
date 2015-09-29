/******************************************************************************/
/* Node.hpp		           	                                                  */
/******************************************************************************/ 

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _NODE_HPP_
#define _NODE_HPP_

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "geom/Polygon.hpp"

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@author Patrick Vogt
*
*	@brief implementiert einen Container, der ein Polygon und einen Zeiger auf
*	einen anderen Container erhaelt.
*
*	Kann zum Bau einer Polygon-Liste/Stack benutzt werden
*/
class Node
{
	friend class PolygonStack;               /* PolygonStack ist FreundKlasse */
	/* PolygonStack kann auf die privaten Exemplarvariablen von Node zugreifen*/

private:
	/**
	*	@brief zeigt auf ein <em>Polygon</em>-Objekt
	*/
	Polygon *data;
	
	/**
	*	@brief zeigt auf ein anderes <em>Node</em>-Objekt
	*/
	Node *next;

protected:

public:
	/**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>Node</em>
	*
	*	@param data	ein Zeiger auf das zu haltende <em>Polygon</em>-Objekt
	*	@param next ein Zeiger auf das naechste <em>Node</em>-Objekt
	*/
	Node(Polygon *data, Node *next);
	
	//Node(const Node &rhs);
	
	/**
	*	@brief Desktruktor
	*
	*	loescht ein Objekt vom Typ <em>Node</em>
	*/
	virtual ~Node();
};

#endif /* _NODE_HPP_ */
