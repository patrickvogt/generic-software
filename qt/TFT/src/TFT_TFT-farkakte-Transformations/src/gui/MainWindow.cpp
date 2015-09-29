/******************************************************************************/
/* MainWindow.cpp       	                                                  */
/******************************************************************************/

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "gui/MainWindow.hpp"

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@brief baut das Menu auf und fuegt es dem Hauptfenster an
*/
void MainWindow::setMenu()
{
	QMenu *fileMenu=new QMenu(tr("&File"));                      /* File-Menu */
	QMenu *newMenu=new QMenu(tr("N&ew"));                   /* File->New-Menu */
	QAction *squareA = newMenu->addAction(QIcon(":/images/file_new_square.png"),
		tr("new S&quare"), center, SLOT(newSquare()));
	QAction *circleA = newMenu->addAction(QIcon(":/images/file_new_circle.png"),
		tr("new C&ircle"), center, SLOT(newCircle()));
	QAction *rectangleA = newMenu->addAction(
		QIcon(":/images/file_new_rectangle.png"),
		tr("new Re&ctangle"), center, SLOT(newRectangle()));
	QAction *heptagonA = newMenu->addAction(
		QIcon(":/images/file_new_heptagon.png"),
		tr("new He&ptagon"), center, SLOT(newEquilateralHeptagon()));
	QAction *polygonA = newMenu->addAction(
		QIcon(":/images/file_new_polygon.png"),
		tr("new P&olygon"), center, SLOT(newEquilateralPolygon()));
	
	(void) fileMenu->addMenu(newMenu);                      
	
	QAction *printA=fileMenu->addAction(QIcon(":/images/file_print.png"), 
		tr("Print"), this, SLOT(print()));
	printA->setShortcut(tr("CTRL+P"));
	QAction *saveXMLA = fileMenu->addAction(QIcon(":/images/file_save-xml.png"), 
		tr("Save Polygon (XML)"), center, SLOT(writeXMLFileDialog()));
	saveXMLA->setShortcut(tr("CTRL+S"));
	QAction *openXMLA = fileMenu->addAction(QIcon(":/images/file_open-xml.png"), 
		tr("Load Polygon (XML)"), center, SLOT(readXMLFileDialog()));
	openXMLA->setShortcut(tr("CTRL+O"));
	QAction *saveSVGA = fileMenu->addAction(QIcon(":/images/file_save-svg.png"), 
		tr("Save as SVG"), center, SLOT(writeSVGFileDialog()));
	QAction *quitA = fileMenu->addAction(QIcon(":/images/file_quit.png"),
		tr("Quit"), this, SLOT(quit()));
	quitA->setShortcut(tr("CTRL+Q"));
	
	this->bar->addMenu(fileMenu);
	
	QMenu *editMenu=new QMenu(tr("&Edit"));                      /* Edit-Menu */
	this->undoMenuItem = editMenu->addAction(QIcon(":/images/edit_undo.png"),
		tr("U&ndo"), this, SLOT(undo()));
	this->redoMenuItem = editMenu->addAction(QIcon(":/images/edit_redo.png"),
		tr("R&edo"), this, SLOT(redo()));
	this->undoMenuItem->setShortcut(tr("CTRL+Z"));
	this->redoMenuItem->setShortcut(tr("CTRL+Y"));
	
	this->undoMenuItem->setEnabled(false);
	this->redoMenuItem->setEnabled(false);
	
	this->bar->addMenu(editMenu);
	
	QMenu *configMenu=new QMenu(tr("&Config"));		           /* Config-Menu */
	QAction *colorA = configMenu->addAction(QIcon(":/images/config_color.png"),
		tr("C&olor"), this, SLOT(showColorDialog()));
	
	this->bar->addMenu(configMenu);
	
	QMenu *helpMenu=new QMenu(tr("&Help"));                      /* Help-Menu */
	/* qApp ist ein Zeiger auf die globale Variable/eindeutige Instanz der 
		                    Anwendung. Dieser Zeiger liegt in \<QApplication> */
	QAction *aboutQtA = 
		helpMenu->addAction(QIcon(":/images/help_about-qt.png"),
		tr("A&bout Qt"), qApp, SLOT(aboutQt()));
	aboutQtA->setShortcut(tr("ALT+SHIFT+F1"));
	QAction *aboutA = 
		helpMenu->addAction(QIcon(":/images/help_about.png"),
		tr("A&bout"), this, SLOT(showAbout()));
	aboutA->setShortcut(tr("F1"));
	
	this->bar->addMenu(helpMenu);
	
	(void *) statusBar();	
	
	QToolBar *tfile = addToolBar(tr("File"));             /* Toolbar aufbauen */
	tfile->addAction(openXMLA);
	tfile->addAction(saveXMLA);
	tfile->addAction(saveSVGA);
	tfile->addAction(printA);
	QToolBar *tedit = addToolBar(tr("Edit"));
	tedit->addAction(this->undoMenuItem);
	tedit->addAction(this->redoMenuItem);
	QToolBar *tpolygon = addToolBar(tr("Polygon"));
	tpolygon->addAction(squareA);
	tpolygon->addAction(rectangleA);
	tpolygon->addAction(circleA);
	tpolygon->addAction(heptagonA);
	tpolygon->addAction(polygonA);
	QToolBar *tconfig = addToolBar(tr("Config"));
	tconfig->addAction(colorA);
	QToolBar *thelp = addToolBar(tr("Help"));
	thelp->addAction(aboutQtA);
	thelp->addAction(aboutA);
	
	tfile->setMinimumHeight(MainWindow::tbar_min_height);
	
	this->setMenuBar(this->bar);
}

/**
*	@brief Konstruktor
*
*	erzeugt ein neues Objekt vom Typ <em>MainWindow</em>
*
*	@param parent Parent-Widget
*/
MainWindow::MainWindow(QWidget *parent)
{
	if(0!=parent)
	{
		this->setParent(parent);
	}
	
	this->setWindowState(Qt::WindowMaximized);
	this->setWindowTitle("TFT: TFT farkakte Transformations");

	this->bar = new QMenuBar(this);
	
	this->center = new CentralWidget(this, this->undoMenuItem, 
		this->redoMenuItem);
	
	connect(center, SIGNAL(transformed()), this, SLOT(setUndo()));
	
	this->setCentralWidget(this->center);
	
	this->setMenu();
	
	this->resize(MainWindow::window_width,MainWindow::window_height);		
}

/**
*	@brief Desktruktor
*
*	loescht ein Objekt vom Typ <em>MainWindow</em>
*/
MainWindow::~MainWindow()
{

}

/**
*	@brief zeigt eine MessageBox ueber das Porgramm an (About-Box)
*/
void MainWindow::showAbout()
{
	statusBar()->showMessage(tr("About TFT"));
	
	/* About-Box anzeigen */
		QMessageBox about(QMessageBox::NoIcon, tr("About TFT"), 
		tr("<a href=\"http://en.wikipedia.org/wiki/"\
		"The_Cabinet_of_Dr._Caligari\">"\
		"<img src=\":/images/caligari_splash.png\" /></a>"\
		"<h3>TFT: TFT <a href= \"http://en.wikipedia.org/wiki/Yinglish\">"\
		"farkakte</a> Transformations</h3>"\
		"<p>Author: Patrick VOGT</p>"\
		"<p>Registration Number: 256558</p>"\
		"<p>Copyright (Pictures/Icons a.o.): Patrick VOGT</p>"\
		"<p>Version: %1</p>").arg(__DATE__), 
		QMessageBox::Ok, this);
		
	about.exec();
	
	statusBar()->clearMessage();
}

/**
*	@brief druckt das Polygon aus, in dem es auf dem Drucker 'gezeichnet' wird
*/
void MainWindow::print()
{
	
	statusBar()->showMessage(tr("Print"));      /* Statusbar 'Print' anzeigen */
	
	QPrinter printer(QPrinter::ScreenResolution);       /* QPrinter erstellen */
	
	QPrintDialog printd(&printer, this);              /* PrintDialog anzeigen */
		
	int ret = printd.exec();                        /* PrintDialog ausfuehren */
		
	if(QDialog::Accepted==ret)                         /* wurde OK gedrueckt? */
	{
		QPainter painter(&printer);
			
		Polygon *p = this->center->getPaintArea()            /* Polygon holen */
			->getPolygon()->intoRampenlicht();	
		
		int n = p->getPoints()->length();                    /* Anzahl Punkte */
		QColor color=this->center->getPaintArea()->getColor();
		
		painter.setBrush(color);
	
		QPointF *poly = p->toQPointFArray();
		
		painter.drawPolygon(poly, n);             /* Polygon drucken/zeichnen */
	}
		
	statusBar()->clearMessage();
}

/**
*	@brief zeigt einen Warn-Dialog und beendet je nach Eingabe dann das 
*	Porgramm
*/
void MainWindow::quit()
{
	statusBar()->showMessage(tr("Quit?"));
	
	QMessageBox close(QMessageBox::Warning, tr("Quit?"), 
		tr("Do you really want to quit the program?"), 
		QMessageBox::NoButton, this);
	QPushButton *yes = close.addButton(tr("Yes"), QMessageBox::YesRole);
	(void *) close.addButton(tr("No"), QMessageBox::NoRole);
	(void) close.exec();
	if(close.clickedButton()==yes)
	{
		this->close();
	}
	statusBar()->clearMessage();
}

/**
*	@brief zeigt eine MessageBox ueber Qt an
*/
void MainWindow::showAboutQt()
{
	statusBar()->showMessage(tr("About Qt"));

	QMessageBox::aboutQt(this, tr("About Qt"));
	
	statusBar()->clearMessage();
}

/**
*	@brief zeigt einen Farbauswahl Dialog an und weist die ausgewaehlte 
*	Farbe (auf mehreren Ebenen) dem Polygon zu
*/	
void MainWindow::showColorDialog()
{
	statusBar()->showMessage(tr("Choose a color"));

	QColor newCol = QColorDialog::getColor(Qt::white, this);
	if(newCol.isValid())
	{
		const_cast<PaintArea *>(this->center->getPaintArea())->
			colorChanged(newCol);
	}
	
	statusBar()->clearMessage();
}

/**
*	@brief aktiviert das UndoMenuItem 
*/
void MainWindow::setUndo()
{
	if(!this->undoMenuItem->isEnabled())
	{
		this->undoMenuItem->setEnabled(true);
	}
}

/**
*	@brief macht einen UNDO-Schritt
*/
void MainWindow::undo()
{
	bool retval=this->center->undo();
	
	if(retval)
	{
		this->undoMenuItem->setEnabled(false);
	}

	if(!this->redoMenuItem->isEnabled())
	{
		this->redoMenuItem->setEnabled(true);
	}
	
	statusBar()->showMessage(tr("UNDO successfull"));
}

/**
*	@brief macht einen REDO-Schritt
*/
void MainWindow::redo()
{
	bool retval=this->center->redo();
	
	if(retval)
	{
		this->redoMenuItem->setEnabled(false);
	}

	if(!this->undoMenuItem->isEnabled())
	{
		this->undoMenuItem->setEnabled(true);
	}
	
	statusBar()->showMessage(tr("REDO successfull"));
}
