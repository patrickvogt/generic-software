/******************************************************************************/
/* CentralWidget.hpp       	                                                  */
/******************************************************************************/ 

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _CENTRALWIDGET_HPP_
#define _CENTRALWIDGET_HPP_

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include <iostream>
#include <fstream>
#include <QFileDialog>
#include <QWidget>
#include <QAction>
#include <QPushButton>
#include <QVBoxLayout>
#include <QString>
#include <QStringList>
#include "geom/Polygon.hpp"
#include "geom/Rectangle.hpp"
#include "geom/Square.hpp"
#include "geom/Circle.hpp"
#include "geom/EquilateralPolygon.hpp"
#include "gui/MatrixInput.hpp"
#include "gui/PaintArea.hpp"
#include "util/PolygonStack.hpp"

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@author Patrick Vogt
*
*	@brief Zentrales Widget, welches sich in der Mitte des Hauptfensters 
*	befindet und alle anderen Widget beinhaltet
*/
class CentralWidget: public QWidget
{
Q_OBJECT

private:
	/**
	*	@brief die EingabeMaske fuer die Transformationsmatrix 
	*/
	MatrixInput *mi;
	
	/**
	*	@brief die Flaeche in der Das Polygon gezeichnet werden soll 
	*/
	PaintArea *pa;
	
	/**
	*	@brief UNDO-Stack 
	*/
	PolygonStack *un;
	
	/**
	*	@brief REDO-Stack 
	*/
	PolygonStack *re;
	
	/**
	*	@brief UndoMenuItem
	*/
	QAction *undoMenuItem;
	
	/**
	*	@brief RedoMenuItem
	*/
	QAction *redoMenuItem;	
	
	/**
	*	@brief Standartgroesse eines neu erzeugten Polygons
	*/
	static const int default_polygon_size=300;
	
protected:
	
public:
	/**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>CentralWidget</em>
	*
	*	@param parent Parent-Widget
	*	@param undoItem Undo-Item im Menu
	*	@param redoItem Redo-Item im Menu
	*/
	CentralWidget(QWidget *parent, QAction *const undoItem, 
		QAction *const redoItem);
		
	/**
	*	@brief Kopier-Konstruktor
	*
	*	kopiert ein Objekt vom Typ <em>CentralWidget</em>
	*
	*	@param rhs zu kopierendes CentralWidget
	*/	
	CentralWidget(const CentralWidget &rhs);
	
	/**
	*	@brief Desktruktor
	*
	*	loescht ein Objekt vom Typ <em>CentralWidget</em>
	*/
	virtual ~CentralWidget();
	
	/**
	*	@brief gibt die in die Maske eingegebene Matrix zurueck
	*
	*	@return die in die Makse eingegebene Matrix
	*/	
	const MatrixInput *getMatrixInput() const;
	
	/**
	*	@brief gibt die PaintArea zurueck
	*
	*	@return die PaintArea
	*/
	const PaintArea *getPaintArea() const;
	
	/**
	*	@brief loescht den Inhalt der PaintArea
	*/
	void clearPaintArea();
	
	/**
	*	@brief macht einen UNDO-Schritt
	*
	*	Sollte ein UNDO nicht moeglich sein, wird natuerlich auch kein 
	*	Undo-Schritt gemacht
	*
	*	@return ob ein UNDO-Schritt gemacht wurde
	*/
	bool undo();
	
	/**
	*	@brief macht einen REDO-Schritt
	*
	*	Sollte ein REDO nicht moeglich sein, wird natuerlich auch kein 
	*	Redo-Schritt gemacht
	*
	*	@return ob ein REDO-Schritt gemacht wurde
	*/
	bool redo();
	
	/**
	*	@brief setzt das Polygon der PaintArea auf das uebergebene Polygon
	*
	*	@param p das neue Polygon, was auf der PaintArea dargestellt werden soll
	*/
	void newPolygon(Polygon *p);
	
	/**
	*	@brief zeigt einen EingabeDialog zur Eingabe von Ganzzahlen an
	*
	*	@param title String in der Titelleiste des Dialoges
	*	@param label Text vor dem Eingabefeld
	*	@param init_value Anfangswert des Eingabefeldes
	*	@param min_value Kleinster gueltiger Wert
	*	@param  max_value Groesster gueltiger Wert
	*	
	*	@return die eingegebene Ganzzahl
	*/	
	int getIntegerDialog(QString title, QString label, int init_value, 
		int min_value, int max_value, int default_value) const;
	
signals:

	/**
	*	@brief wird ausgeloest, wenn ein Polygon transformiert, also veraendert 
	*	wurde
	*/
	void transformed();

public slots:	

	/**
	*	@brief transformiert das Polygon mit der in MatrixInput eingegeben 
	*	Matrix
	*/
	void transform();
	
	/**
	*	@brief zeichnet ein neues Quadrat mit einer Standartweite
	*/
	void newSquare();
	
	/**
	*	@brief zeichnet ein neues Quadrat mit der uebergebenen Weite
	*
	*	@param width Weite des zu zeichnenden Quadrat
	*/
	void newSquare(const int width);
	
	/**
	*	@brief zeichnet ein neues Kreis mit einem Standartdurchmesser
	*/
	void newCircle();
	
	/**
	*	@brief zeichnet ein neuen Kreis mit dem uebergebenen Durchmesser
	*
	*	@param diameter Durchmesser des zu zeichnenden Kreises
	*/
	void newCircle(const int diameter);
	
	/**
	*	@brief zeichnet ein neues Rechteck mit Standart-Weite und Standart-Hoehe
	*/
	void newRectangle();
	
	/**
	*	@brief zeichnet ein neues Rechteck mit der uebergebenen Weite und Hoehe
	*
	*	@param width Weite des zu zeichnenden Rechtecks
	*	@param height Hoehe des zu zeichnenden Rechtecks
	*/
	void newRectangle(const int width, const int height);
	
	/**
	*	@brief zeichnet ein neues gleichseitiges Fuenfeck mit 
	*	Standart-Durchmesser
	*/
	void newEquilateralHeptagon();
	
	/**
	*	@brief zeichnet ein neues gleichseitiges Vieleck mit dem uebergebenen 
	*	Durchmesser und den uebergebenen Anzahl Kanten
	*/
	void newEquilateralPolygon();
	
	/**
	*	@brief schreibt das aktuelle angezeigte Polygon als XML-Datei raus
	*
	*	@param selected der Dateiname, der im Filedialog ausgewaehlt/eingegeben
	*	wurde
	*/
	virtual void writeXML(const QStringList &selected);
	
	/**
	*	@brief zeigt einen FileDialog zum auswaehlen/eingeben der Zieldatei
	*/
	virtual void writeXMLFileDialog();
	
	/**
	*	@brief liest ein Polygon aus der im Filedialog ausgewaehlt/eingegeben 
	*	XML-Datei
	*
	*	@param selected der Dateiname, der im Filedialog ausgewaehlt/eingegeben
	*	wurde
	*/
	virtual void readXML(const QStringList &selected);
	
	/**
	*	@brief zeigt einen FileDialog zum auswaehlen/eingeben der Zieldatei
	*/
	virtual void readXMLFileDialog();
	
	/**
	*	@brief schreibt das aktuelle angezeigte Polygon als SVG-Datei raus
	*
	*	@param selected der Dateiname, der im Filedialog ausgewaehlt/eingegeben
	*	wurde
	*/
	virtual void writeSVG(const QStringList &selected);
	
	/**
	*	@brief zeigt einen FileDialog zum auswaehlen/eingeben der Zieldatei
	*/
	virtual void writeSVGFileDialog();
	
};

#endif /* _CENTRALWIDGET_HPP_ */
