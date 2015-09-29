/******************************************************************************/
/* Node.cpp		           	                                                  */
/******************************************************************************/

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#include "util/Node.hpp"

/**
*	@brief Konstruktor
*
*	erzeugt ein neues Objekt vom Typ <em>Node</em>
*
*	@param data	ein Zeiger auf das zu haltende <em>Polygon</em>-Objekt
*	@param next ein Zeiger auf das naechste <em>Node</em>-Objekt
*/
Node::Node(Polygon *data, Node *next)
	:data(data), next(next)
{

}

/**
*	@brief Desktruktor
*
*	loescht ein Objekt vom Typ <em>Node</em>
*/
Node::~Node()
{

}
