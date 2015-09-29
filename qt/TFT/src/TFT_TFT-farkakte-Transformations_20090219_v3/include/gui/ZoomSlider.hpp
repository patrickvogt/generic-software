/******************************************************************************/
/* ZoomSlider.hpp       	                                                  */
/******************************************************************************/ 

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _ZOOMSLIDER_HPP_
#define _ZOOMSLIDER_HPP_

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include <QSlider>
#include "util/Matrix.hpp"
#include "geom/Polygon.hpp"

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@author Patrick Vogt
*
*	@brief definiert einen eigenen Slider, der fuer das Zoomen der PaintArea 
*	zustaendig ist
*/
class ZoomSlider: public QSlider
{
Q_OBJECT

private:
	/**
	*	@brief maximale Breite des Zoom-Sliders
	*/
	static const unsigned int maximumWidth=50;
	
	/**
	*	@brief Polygon fuer das der ZoomSlider zustaendig ist
	*/
	Polygon *polygon;

protected:

public:
	/**
	*	@brief mittlerer Wert des ZoomSliders
	*/
	static const unsigned int middleValue=50;
	
	/**
	*	@brief zoomFactor
	*/
	static const double zoomFactor=1;

	/**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>CentralWidget</em>
	*
	*	@param parent Parent-Widget
	*/
	ZoomSlider(QWidget *parent);
	
	//ZoomSlider(const ZoomSlider &rhs);
	
	/**
	*	@brief Desktruktor
	*
	*	loescht ein Objekt vom Typ <em>CentralWidget</em>
	*/
	virtual ~ZoomSlider();

};

#endif /* _ZOOMSLIDER_HPP_ */
