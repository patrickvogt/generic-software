/******************************************************************************/
/* CentralWidget.cpp       	                                                  */
/******************************************************************************/ 

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "gui/CentralWidget.hpp"

/******************************************************************************/
/* Klassendefinition														  */
/******************************************************************************/

/**
*	@brief Konstruktor
*
*	erzeugt ein neues Objekt vom Typ <em>CentralWidget</em>
*
*	@param parent Parent-Widget
*	@param undoItem Undo-Item im Menu
*	@param redoItem Redo-Item im Menu
*/
CentralWidget::CentralWidget(QWidget *parent, QAction *const undoItem, 
	QAction *const redoItem)
	:undoMenuItem(undoItem), redoMenuItem(redoItem)
{	
	this->un = new PolygonStack();
	this->re = new PolygonStack();

	this->setParent(parent);

	this->mi = new MatrixInput(this);
					
	Circle *some = new Circle(0,0,CentralWidget::default_polygon_size);
	
	this->pa = new PaintArea(some, this);
	
	QVBoxLayout *layout = new QVBoxLayout();
	
	layout->addWidget(this->mi);
	layout->addWidget(this->pa);
	
	this->setLayout(layout);
}

/**
*	@brief Kopier-Konstruktor
*
*	kopiert ein Objekt vom Typ <em>CentralWidget</em>
*
*	@param rhs zu kopierendes CentralWidget
*/	
CentralWidget::CentralWidget(const CentralWidget &rhs)
	:QWidget::QWidget()
{
	Matrix ma = rhs.getMatrixInput()->getMatrix();

	this->mi = new MatrixInput(rhs.parentWidget(), ma.m11(), ma.m21(), 
		ma.m12(), ma.m22());
}

/**
*	@brief Desktruktor
*
*	loescht ein Objekt vom Typ <em>CentralWidget</em>
*/
CentralWidget::~CentralWidget()
{
	delete this->mi;
	delete this->pa;
	delete this->un;
	delete this->re;
}

/**
*	@brief gibt die in die Maske eingegebene Matrix zurueck
*
*	@return die in die Makse eingegebene Matrix
*/
const MatrixInput *CentralWidget::getMatrixInput() const
{
	return this->mi;
}

/**
*	@brief gibt die PaintArea zurueck
*
*	@return die PaintArea
*/
const PaintArea *CentralWidget::getPaintArea() const
{
	return this->pa;
}

/**
*	@brief loescht den Inhalt der PaintArea
*/
void CentralWidget::clearPaintArea()
{	
	this->pa->unsetUserIsDrawing();
	this->pa->clearZoomState();	
}

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
int CentralWidget::getIntegerDialog(QString title, QString label, int init_value, 
	int min_value, int max_value, int default_value) const
{
	bool ok;
    int number = QInputDialog::getInt(const_cast<CentralWidget *>(this), 
    	title, label, init_value, min_value, max_value, 1, &ok);
    
    if(ok) 
    {
    	return number;
    }
    return default_value;
}

/**
*	@brief macht einen UNDO-Schritt
*
*	Sollte ein UNDO nicht moeglich sein, wird natuerlich auch kein 
*	Undo-Schritt gemacht
*
*	@return ob ein UNDO-Schritt gemacht wurde
*/
bool CentralWidget::undo()
{	
	if(!this->un->isEmpty()) 
	{	
		Polygon *akt=this->pa->getPolygon();
		
		Polygon *p=this->un->pop();
	
		this->re->push(new Polygon(akt->getPoints()->copy()));
		bool retval=this->un->isEmpty();

		this->newPolygon(p);

		return retval;
	}
	return false;
}

/**
*	@brief macht einen REDO-Schritt
*
*	Sollte ein REDO nicht moeglich sein, wird natuerlich auch kein 
*	Redo-Schritt gemacht
*
*	@return ob ein REDO-Schritt gemacht wurde
*/
bool CentralWidget::redo()
{
	if(!this->re->isEmpty()) 
	{
		Polygon *akt=this->pa->getPolygon();
	
		Polygon *p=this->re->pop();
	
		this->un->push(new Polygon(akt->getPoints()->copy()));
		bool retval=this->re->isEmpty();

		this->newPolygon(p);
		
		return retval;
	}
	return false;
}

/**
*	@brief transformiert das Polygon mit der in MatrixInput eingegeben 
*	Matrix
*/
void CentralWidget::transform()
{	
	Polygon *p=this->pa->getPolygon();
	this->un->push(new Polygon(p->getPoints()->copy()));

	Matrix m=this->mi->getMatrix(); 
	this->pa->transformPolygon(m);
	
	emit transformed();
}

/**
*	@brief setzt das Polygon der PaintArea auf das uebergebene Polygon
*
*	@param p das neue Polygon, was auf der PaintArea dargestellt werden soll
*/
void CentralWidget::newPolygon(Polygon *p)
{
	this->clearPaintArea();
	this->pa->setPolygon(p);
	this->pa->repaint();
}

/**
*	@brief zeichnet ein neues Quadrat mit einer Standartweite
*/
void CentralWidget::newSquare()
{	
	this->newPolygon(new Square(0,0,CentralWidget::default_polygon_size));
}

/**
*	@brief zeichnet ein neues Quadrat mit der uebergebenen Weite
*
*	@param width Weite des zu zeichnenden Quadrat
*/
void CentralWidget::newSquare(const int width)
{	
	this->newPolygon(new Square(0,0,width));
}

/**
*	@brief zeichnet ein neues Kreis mit einem Standartdurchmesser
*/
void CentralWidget::newCircle()
{
	this->newPolygon(new Circle(0,0,CentralWidget::default_polygon_size));	
}

/**
*	@brief zeichnet ein neuen Kreis mit dem uebergebenen Durchmesser
*
*	@param diameter Durchmesser des zu zeichnenden Kreises
*/
void CentralWidget::newCircle(const int diameter)
{
	this->newPolygon(new Circle(0,0,diameter));	
}

/**
*	@brief zeichnet ein neues Rechteck mit Standart-Weite und Standart-Hoehe
*/
void CentralWidget::newRectangle()
{
	this->newPolygon(new Rectangle(
		0,0,CentralWidget::default_polygon_size,200));
}

/**
*	@brief zeichnet ein neues Rechteck mit der uebergebenen Weite und Hoehe
*
*	@param width Weite des zu zeichnenden Rechtecks
*	@param height Hoehe des zu zeichnenden Rechtecks
*/
void CentralWidget::newRectangle(const int width, const int height)
{
	this->newPolygon(new Rectangle(0,0,width,height));
}

/**
*	@brief zeichnet ein neues gleichseitiges Fuenfeck mit 
*	Standart-Durchmesser
*/
void CentralWidget::newEquilateralHeptagon()
{
	this->newPolygon(new EquilateralPolygon(0,0,CentralWidget::default_polygon_size, 5));
}

/**
*	@brief zeichnet ein neues gleichseitiges Vieleck mit dem uebergebenen 
*	Durchmesser und den uebergebenen Anzahl Kanten
*/
void CentralWidget::newEquilateralPolygon()
{
	int num_edges=this->getIntegerDialog(tr("Edges-Input"), 
			tr("Number of edges: "), 10, 3, 100, 5);
	this->newPolygon(new EquilateralPolygon(0,0,
		CentralWidget::default_polygon_size, num_edges));
}

/**
*	@brief schreibt das aktuelle angezeigte Polygon als XML-Datei raus
*
*	@param selected der Dateiname, der im Filedialog ausgewaehlt/eingegeben
*	wurde
*/
void CentralWidget::writeXML(const QStringList & selected)
{
	QString dest_path = selected.at(0);
	
	std::fstream dest;
	
	dest.open(dest_path.toStdString().c_str(), std::ios::out);

	this->pa->writeXML(dest);
	
	dest.close();
}

/**
*	@brief zeigt einen FileDialog zum auswaehlen/eingeben der Zieldatei
*/
void CentralWidget::writeXMLFileDialog()
{
	QFileDialog *fd = new QFileDialog(this, "Save as XML", 
		QDir::currentPath(), "XML-files (*.xml);;All files(*.*)");
	
	                                 /* Ueberschreiben muss bestaetigt werden */
	fd->setAcceptMode(QFileDialog::AcceptSave);
	fd->setConfirmOverwrite(true);
	
	connect(fd, SIGNAL(filesSelected(const QStringList &)), 
		this, SLOT(writeXML(const QStringList &)));
		
	fd->show();
}

/**
*	@brief liest ein Polygon aus der im Filedialog ausgewaehlt/eingegeben 
*	XML-Datei
*
*	@param selected der Dateiname, der im Filedialog ausgewaehlt/eingegeben
*	wurde
*/
void CentralWidget::readXML(const QStringList &selected)
{	
	QString src_path = selected.at(0);
	
	std::fstream src;
	
	src.open(src_path.toStdString().c_str() , std::ios::in);

	this->pa->readXML(src_path);
	
	src.close();
}

/**
*	@brief zeigt einen FileDialog zum auswaehlen/eingeben der Zieldatei
*/
void CentralWidget::readXMLFileDialog()
{
	QFileDialog *fd = new QFileDialog(this, "Load from XML", 
		QDir::currentPath(), "XML-files (*.xml);;All files(*.*)");
		
	connect(fd, SIGNAL(filesSelected(const QStringList &)), 
		this, SLOT(readXML(const QStringList &)));
		
	fd->show();
}

/**
*	@brief schreibt das aktuelle angezeigte Polygon als SVG-Datei raus
*
*	@param selected der Dateiname, der im Filedialog ausgewaehlt/eingegeben
*	wurde
*/
void CentralWidget::writeSVG(const QStringList &selected)
{
	QString dest_path = selected.at(0);

	std::fstream dest;
	
	dest.open(dest_path.toStdString().c_str(), std::ios::out);

	this->pa->writeSVG(dest);
	
	dest.close();
}

/**
*	@brief zeigt einen FileDialog zum auswaehlen/eingeben der Zieldatei
*/
void CentralWidget::writeSVGFileDialog()
{
	QFileDialog *fd = new QFileDialog(this, "Save as SVG", 
		QDir::currentPath(), "SVG-files (*.svg);;All files(*.*)");
	
	                                 /* Ueberschreiben muss bestaetigt werden */
	fd->setAcceptMode(QFileDialog::AcceptSave);
	fd->setConfirmOverwrite(true);
	
	connect(fd, SIGNAL(filesSelected(const QStringList &)), 
		this, SLOT(writeSVG(const QStringList &)));
		
	fd->show();
}
