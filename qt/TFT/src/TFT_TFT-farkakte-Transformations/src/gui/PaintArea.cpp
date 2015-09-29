/******************************************************************************/
/* PaintArea.hpp	       	                                                  */
/******************************************************************************/

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "gui/PaintArea.hpp"

/**
*	@brief Konstruktor
*
*	erzeugt ein neues Objekt vom Typ <em>PaintArea</em>
*
*	@param polygon Anfangspolygon
*	@param parent Parent-Widget
*/
PaintArea::PaintArea(Polygon *const polygon, QWidget *parent)
	:polygon(polygon), path(NULL), currentColor(Qt::blue), oldZoom(ZoomSlider::middleValue), userIsDrawing(false)
{
	this->setParent(parent);
	
	this->zooming= new ZoomSlider(this);	
	
	QHBoxLayout *layout=new QHBoxLayout();
	layout->addWidget(zooming);
	
	this->setAutoFillBackground(true);
	this->setBackgroundRole(QPalette::Midlight);
}

/**
*	@brief Desktruktor
*
*	loescht ein Objekt vom Typ <em>PaintArea</em>
*/
PaintArea::~PaintArea()
{
	delete this->polygon;
	//delete this->path;
}

/**
*	@brief setzt das zu anzeigende Polygon auf das uebergebene Poylgon
*
*	@param polygon das neu zu anzeigende Poylgon
*/
void PaintArea::setPolygon(Polygon *polygon)
{
	Polygon *old=this->polygon;
	this->polygon=polygon;
	delete old;
}

/**
*	@brief gibt die aktuell eingestellte Farbe zurueck
*
*	@return die aktuell eingestellte Farbe
*/	
const QColor &PaintArea::getColor() const
{
	return this->currentColor;
}

/**
*	@brief prueft, ob der Benutzer gerade manuell ein Polygon zeichnet
*
*	@return ob der Nutzer gerade zeichnet
*/
bool PaintArea::isUserDrawing()
{
	return this->userIsDrawing;
}

/**
*	@brief setzt den boolschen Wert, dass der Nutzer gerade zeichnet, auf 
*	true
*/
void PaintArea::setUserIsDrawing()
{
	this->userIsDrawing=true;
}

/**
*	@brief setzt den boolschen Wert, dass der Nutzer gerade zeichnet, auf 
*	false
*/
void PaintArea::unsetUserIsDrawing()
{
	this->userIsDrawing=false;
}

/**
*	@brief setzt den ZoomSlider wieder auf dessen Mittel
*/
void PaintArea::clearZoomState()
{
	this->zooming->setValue(ZoomSlider::middleValue);
	this->oldZoom=ZoomSlider::middleValue;
}

/**
*	@brief aendert die Farbe des angezeigten Polygons
*
*	@param col neue Farbe des Poylgons
*/
void PaintArea::colorChanged(QColor &col)
{
	this->currentColor=col;
	this->repaint();
}

/**
*	@brief zeichnet das Polygon neu
*
*	@param event das Event das das Neuzeichnen ausgeloest hat
*/
void PaintArea::paintEvent(QPaintEvent *event)
{
	QPainter p(this);
	(void) event->rect();
	
	/* Kantenglaettung */
	p.setRenderHint(QPainter::Antialiasing, true);
	
	/* Koordinatenursprung verschieben */
	QPointF origin(this->width()/2, this->height()/2);
	
	p.translate(origin);
	
	p.setPen(Qt::NoPen);
    p.setBrush(this->currentColor);
	
	if(!this->userIsDrawing)
	{
		this->polygon->paintMe(p);
	}
	else
	{
		                                        /* wurde Polygon geschlossen? */
		if(this->polygon->first() >= this->polygon->last())
		{
			this->unsetUserIsDrawing();
			this->polygon->paintMe(p);
		}
		else
		{
			QPainterPathStroker *ps=new QPainterPathStroker();
			QPainterPath pa = ps->createStroke(*(this->path));
			p.drawPath(pa);
			delete ps;
		}
	}
	
	this->zooming->setFixedHeight(this->height());
}

/**
*	@brief gibt das aktuell angezeigte Polygon zurueck
*
*	@return das aktuell angezeigte Polygon
*/
Polygon *PaintArea::getPolygon() const
{	
	return this->polygon;
}

/**
*	@brief transformiert das Polygon mit der uebergebenen Matrix
*
*	@param m Matrix mit der das komplette Polygon transformiert werden soll
*/
void PaintArea::transformPolygon(const Matrix &m)
{
	this->polygon->transform(m);	
	this->repaint();
}

/**
*	@brief verarbeitet MousePressEvents
*
*	@param event das Event, das den MousePress ausgeloest hat
*/
void PaintArea::mousePressEvent(QMouseEvent *event)
{
	double x = static_cast<double>(event->x())
		-(this->width()/2);
	double y = static_cast<double>(event->y())
		-(this->height()/2);
		
	Vertex v(x,y);

	if(!this->userIsDrawing)                               /* User will malen */
	{
		this->setUserIsDrawing();
		this->path = new QPainterPath();
		this->path->moveTo(x, y);
		Polygon *old=this->polygon;
		this->polygon=new Polygon();
		this->polygon->addPoint(v);
		delete old;
		return ;
	}
		
	if(!this->userIsDrawing)
	{
		
		this->polygon->addPoint(v);
	}
	else
	{
		this->polygon->addPoint(v);
		this->path->lineTo(x,y);
		this->path->moveTo(x,y);
	}
	
	this->repaint();		
}

/**
*	@brief verarbeitet WheelEvents (Mausrad-Events)
*
*	@param event das Event
*/
void PaintArea::wheelEvent(QWheelEvent *event)
{
	if(event->delta()>0)
	{
		this->zooming->setValue(oldZoom+5);
	}
	else
	{
		this->zooming->setValue(oldZoom-5);
	}
}

/**
*	@brief zoomt das Polygon entsprechend, wenn der ZoomSLider bewegt wurde
*
*	@param value der neue Wert des Sliders
*/
void PaintArea::zoom(int value)
{
	
	double newValue = value/(double)oldZoom;

	Matrix m(newValue*ZoomSlider::zoomFactor, 0, 0, 
		newValue*ZoomSlider::zoomFactor);

	this->polygon->transform(m);
	
	this->repaint();
	
	this->oldZoom=value;
	
	
}

/**
*	@brief schreibt das aktuell angezeigte Polygon in eine XML-Datei
*
*	@param dest Zielstream der XML-Datei
*/
void PaintArea::writeXML(std::fstream &dest) const
{
	dest << "<?xml version=\"1.0\" encoding=\"utf-8\"?>" << std::endl;
	
	this->polygon->writeXML(dest);
}

/**
*	@brief liest ein Polygon aus einer konformen XML-Datei ein
*
*	@param src Dateiname der XML-Datei
*/
void PaintArea::readXML(QString &src)
{	
	SAX saxparer(src);	
	
	Polygon *p=saxparer.getParsedPolygon();
	
	this->clearZoomState();
	this->unsetUserIsDrawing();
	this->setPolygon(p);
	this->repaint();
}

/**
*	@brief schreibt das aktuell angezeigte Polygon in eine SVG-Datei
*
*	@param dest Zielstream der SVG-Datei
*/
void PaintArea::writeSVG(std::fstream &dest) const
{
	dest << "<?xml version=\"1.0\" encoding=\"utf-8\"?>" << std::endl
		<< "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \
		\"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">"
 		<< std::endl << "<svg xmlns=\"http://www.w3.org/2000/svg\"" << std::endl
 		<< "xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:ev=\
 		\"http://www.w3.org/2001/xml-events\""
 		<< std::endl << "version=\"1.1\" baseProfile=\"full\"" << std::endl
 		<< "width=\"" << static_cast<int>(this->polygon->getWidth()) 
 		<< "px\" height=\""<< static_cast<int>(this->polygon->getHeight()) 
 		<< "px\">" << std::endl;

	dest << "<polygon fill=\"rgb("<< this->currentColor.red()<< ","
		<< this->currentColor.green()
		<< ","<< this->currentColor.blue() << ")\" ";

	this->polygon->writeSVG(dest);
	
	dest << "/>" << std::endl;
	
	dest << "</svg>" << std::endl;
}

