/******************************************************************************/
/* ZoomSlider.cpp       	                                                  */
/******************************************************************************/ 

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "gui/ZoomSlider.hpp"

/******************************************************************************/
/* Klassendefinition														  */
/******************************************************************************/

/**
*	@brief Konstruktor
*
*	erzeugt ein neues Objekt vom Typ <em>CentralWidget</em>
*
*	@param parent Parent-Widget
*/
ZoomSlider::ZoomSlider(QWidget *parent)
	:QSlider::QSlider(Qt::Vertical)
{
	this->setParent(parent);
	
	this->setRange(1,100);
	this->setValue(ZoomSlider::middleValue);
	
	this->setMaximumWidth(ZoomSlider::maximumWidth);
	
	this->connect(this, SIGNAL(valueChanged(int)), parent, 
		SLOT(zoom(int)));
}

/**
*	@brief Desktruktor
*
*	loescht ein Objekt vom Typ <em>CentralWidget</em>
*/
ZoomSlider::~ZoomSlider()
{

}
