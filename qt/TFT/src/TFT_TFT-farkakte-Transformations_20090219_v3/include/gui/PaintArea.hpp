/******************************************************************************/
/* PaintArea.hpp	       	                                                  */
/******************************************************************************/ 

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _PAINTAREA_HPP_
#define _PAINTAREA_HPP_

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include <QWidget>
#include <QPaintEvent>
#include "geom/Polygon.hpp"
#include <QHBoxLayout>
#include <QSlider>
#include <QColor>
#include <QPainterPath>
#include <QPainterPathStroker>
#include "util/Vertex.hpp"
#include "gui/ZoomSlider.hpp"
#include "util/WriteAsXML.hpp"
#include "util/WriteAsSVG.hpp"
#include "util/ReadFromXML.hpp"
#include "xml/SAX.hpp"

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@author Patrick Vogt
*
*	@brief implementiert einen Zeichenbereich
*/
class PaintArea: public QWidget, public WriteAsXML, public WriteAsSVG, 
	public ReadFromXML
{
Q_OBJECT

private:
	/**
	*	@brief Polygon, welches gezeichnet werden soll
	*/
	Polygon *polygon;
	
	/**
	*	@brief Zeichenpfad waehrend des manuellen Zeichnens
	*/
	QPainterPath *path;
	
	/**
	*	@brief ZoomSlider
	*/
	QSlider *zooming;
	
	/**
	*	@brief aktuell ausgewaehlte Farbe
	*/
	QColor currentColor;
	
	/**
	*	@brief alter Zoom-Wert
	*/
	int oldZoom;
	
	/**
	*	@brief gibt an, ob der User gerade manuell ein Polygon zeichnet
	*/
	bool userIsDrawing;
	
protected:
	
public:
	/**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>PaintArea</em>
	*
	*	@param polygon Anfangspolygon
	*	@param parent Parent-Widget
	*/
	PaintArea(Polygon *const polygon, QWidget *parent);
	
	//PaintArea(const PaintArea &rhs);
	
	/**
	*	@brief Desktruktor
	*
	*	loescht ein Objekt vom Typ <em>PaintArea</em>
	*/
	virtual ~PaintArea();
	
	/**
	*	@brief gibt das aktuell angezeigte Polygon zurueck
	*
	*	@return das aktuell angezeigte Polygon
	*/	
	Polygon *getPolygon() const;
	
	/**
	*	@brief setzt das zu anzeigende Polygon auf das uebergebene Poylgon
	*
	*	@param polygon das neu zu anzeigende Poylgon
	*/	
	void setPolygon(Polygon *polygon);
	
	/**
	*	@brief gibt die aktuell eingestellte Farbe zurueck
	*
	*	@return die aktuell eingestellte Farbe
	*/	
	const QColor &getColor() const;
	
	/**
	*	@brief prueft, ob der Benutzer gerade manuell ein Polygon zeichnet
	*
	*	@return ob der Nutzer gerade zeichnet
	*/
	bool isUserDrawing();
	
	/**
	*	@brief setzt den boolschen Wert, dass der Nutzer gerade zeichnet, auf 
	*	true
	*/
	void setUserIsDrawing();
	
	/**
	*	@brief setzt den boolschen Wert, dass der Nutzer gerade zeichnet, auf 
	*	false
	*/
	void unsetUserIsDrawing();
	
	/**
	*	@brief setzt den ZoomSlider wieder auf dessen Mittel
	*/
	void clearZoomState();
	
	/**
	*	@brief aendert die Farbe des angezeigten Polygons
	*
	*	@param col neue Farbe des Poylgons
	*/
	void colorChanged(QColor &col);
	
	/**
	*	@brief transformiert das Polygon mit der uebergebenen Matrix
	*
	*	@param m Matrix mit der das komplette Polygon transformiert werden soll
	*/
	void transformPolygon(const Matrix &m);
	
	/**
	*	@brief zeichnet das Polygon neu
	*
	*	@param event das Event das das Neuzeichnen ausgeloest hat
	*/
	virtual void paintEvent(QPaintEvent *event);
	
	/**
	*	@brief verarbeitet MousePressEvents
	*
	*	@param event das Event, das den MousePress ausgeloest hat
	*/
	void mousePressEvent(QMouseEvent *event); 
	
	/**
	*	@brief verarbeitet WheelEvents (Mausrad-Events)
	*
	*	@param event das Event
	*/
	void wheelEvent(QWheelEvent *event); 
	
	/**
	*	@brief schreibt das aktuell angezeigte Polygon in eine XML-Datei
	*
	*	@param dest Zielstream der XML-Datei
	*/
	virtual void writeXML(std::fstream &dest) const;
	
	/**
	*	@brief liest ein Polygon aus einer konformen XML-Datei ein
	*
	*	@param src Dateiname der XML-Datei
	*/
	virtual void readXML(QString &src);
	
	/**
	*	@brief schreibt das aktuell angezeigte Polygon in eine SVG-Datei
	*
	*	@param dest Zielstream der SVG-Datei
	*/
	virtual void writeSVG(std::fstream &dest) const;
	
public slots:
	/**
	*	@brief zoomt das Polygon entsprechend, wenn der ZoomSLider bewegt wurde
	*
	*	@param value der neue Wert des Sliders
	*/
	void zoom(const int value);
};

#endif /* _PAINTAREA_HPP_ */
