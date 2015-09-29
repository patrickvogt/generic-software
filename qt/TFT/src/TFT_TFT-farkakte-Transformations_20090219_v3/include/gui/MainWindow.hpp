/******************************************************************************/
/* MainWindow.hpp       	                                                  */
/******************************************************************************/ 

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _MAINWINDOW_HPP_
#define _MAINWINDOW_HPP_

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include <QApplication>
#include <QMainWindow>
#include <QMenuBar>
#include <QMenu>
#include <QWidget>
#include "CentralWidget.hpp"
#include <QColorDialog>
#include <QColor>
#include <QMessageBox>
#include <QPrintDialog>
#include <QStatusBar>
#include <QPrinter>
#include <QPainter>
#include <QPointF>
#include <QToolBar>

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@author Patrick Vogt
*
*	@brief Hauptfenster des Programms, welches Toolbar, Menu und ein 
*	CentralWidget enthaelt
*/
class MainWindow: public QMainWindow
{
Q_OBJECT

private:
	/**
	*	@brief Weite des HauptFensters
	*/
	static const unsigned int window_width=1024;
	
	/**
	*	@brief Hoehe des HauptFensters
	*/
	static const unsigned int window_height=768;
	
	/**
	*	@brief Mindesthoehe der Toolbar
	*/
	static const unsigned int tbar_min_height=50;
	
	/**
	*	@brief CenterWidget, welches sich in der Mitte des Hauptfensters 
	*	befindet
	*/
	CentralWidget *center;
	
	/**
	*	@brief Menubar des Hauptfensters
	*/
	QMenuBar *bar;
	
	/**
	*	@brief UndoMenuItem
	*/
	QAction *undoMenuItem;
	
	/**
	*	@brief RedoMenuItem
	*/
	QAction *redoMenuItem;
	
	/**
	*	@brief baut das Menu auf und fuegt es dem Hauptfenster an
	*/
	void setMenu();

protected:

public:
	/**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>MainWindow</em>
	*
	*	@param parent Parent-Widget
	*/
	MainWindow(QWidget *parent=0);
	
	//MainWindow(const MainWindow &rhs);
	
	/**
	*	@brief Desktruktor
	*
	*	loescht ein Objekt vom Typ <em>CentralWidget</em>
	*/
	virtual ~MainWindow();
	
public slots:
	
	/**
	*	@brief zeigt einen Warn-Dialog und beendet je nach Eingabe dann das 
	*	Porgramm
	*/
	void quit();
	
	/**
	*	@brief druckt das Polygon aus, in dem es auf dem Drucker 'gezeichnet' wird
	*/
	void print();
	
	/**
	*	@brief zeigt eine MessageBox ueber das Porgramm an (About-Box)
	*/
	void showAbout();
	
	/**
	*	@brief zeigt eine MessageBox ueber Qt an
	*/
	void showAboutQt();

	/**
	*	@brief zeigt einen Farbauswahl Dialog an und weist die ausgewaehlte 
	*	Farbe (auf mehreren Ebenen) dem Polygon zu
	*/	
	void showColorDialog();
	
	/**
	*	@brief aktiviert das UndoMenuItem 
	*/
	void setUndo();
	
	/**
	*	@brief macht einen UNDO-Schritt
	*/
	void undo();
	
	/**
	*	@brief macht einen REDO-Schritt
	*/
	void redo();

};

#endif /* _MAINWINDOW_HPP_ */
