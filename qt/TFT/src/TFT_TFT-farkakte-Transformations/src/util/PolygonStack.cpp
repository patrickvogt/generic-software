/******************************************************************************/
/* PolygonStack.cpp           	                                              */
/******************************************************************************/ 

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "util/PolygonStack.hpp"

/******************************************************************************/
/* Klassendefinition														  */
/******************************************************************************/

/**
*	@brief Konstruktor
*
*	erzeugt ein neues Objekt vom Typ <em>PolygonStack</em>
*/
PolygonStack::PolygonStack()
	:head(NULL)
{

}

/**
*	@brief Desktruktor
*
*	loescht ein Objekt vom Typ <em>PolygonStack</em>
*/
PolygonStack::~PolygonStack()
{

}

/**
*	@brief gibt das oberste Polygon des Stacks zurueck
*
*	Achtung: Das oberste Element wird hierbei nicht aus dem Stack enfernt
*
*	@return Zeiger auf das oberste Polygon des Stacks
*/
Polygon *PolygonStack::top() const
{
	return this->head->data;	
}

/**
*	@brief gibt das oberste Polygon des Stacks zurueck und loescht dieses
*	aus dem Stack
*
*	@return Zeiger auf das oberste Polygon des Stacks
*/
Polygon *PolygonStack::pop()
{
	if(!this->isEmpty())
	{
		Polygon *p=this->head->data;
	
		Node *tmp=this->head;                 /* alten Head zwischenspeichern */
	
		this->head=this->head->next;
	
		delete tmp;                 /* alten Head loeschen/Speicher freigeben */
	
		return p;
	}
	return new Polygon();       /* WENN leer DANN leeres Polygon zurueckgeben */
}	

/**
*	@brief fuegt ein neues uebergebe Polygon auf den Stack
*
*	@param p das zu speichernde Polygon
*/
void PolygonStack::push(Polygon *p)
{	
	Node *oldHead = this->head;
	
	this->head=new Node(p, oldHead);
}

/**
*	@brief gibt zurueck, ob der Stack leer ist
*
*	@return ob der Stack leer ist
*/	
bool PolygonStack::isEmpty() const
{
	if(NULL==this->head)
	{
		return true;
	}
	return false;
}
	
