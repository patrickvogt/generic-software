/******************************************************************************/
/* Polygon.cpp           	                                                  */
/******************************************************************************/

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "geom/Polygon.hpp"

/******************************************************************************/
/* Klassendefinition														  */
/******************************************************************************/

/**
*	@brief Konstruktor
*
*	erzeugt ein neues Objekt vom Typ <em>Polygon</em>,
*	welches eine leere Liste von Punkten enthält
*
*/
Polygon::Polygon()
{
	this->points=new VertexLi();          /* neue leere Vertex-Liste erzeugen */
}

/**
*	@brief Konstruktor
*
*	erzeugt ein neues Objekt vom Typ <em>Polygon</em>
*
*	@param points zum Polygon gehoerende <em>Vertex</em>-Liste	
*/
Polygon::Polygon(VertexLi *points)
	:points(points)
{

}

/**
*	@brief Destruktor
*
*	loescht ein Objekt vom Typ <em>Polygon</em>	
*/
Polygon::~Polygon()
{
	delete this->points;                             /* Vertex-Liste loeschen */
}

/**
*	@brief gibt die Liste mit den Punkten des Polygons zurueck
*
*	@return Punkte des Polygons
*/
VertexLi *Polygon::getPoints()
{
	return this->points;
}

/**
*	@brief gibt den ersten Punkt des Polygons zurueck
*
*	@return ersterPunkt des Polygons
*/
const Vertex &Polygon::first() const
{
	return this->points->first();
}

/**
*	@brief gibt den letzten Punkt des Polygons zurueck
*
*	@return letzter Punkt des Polygons
*/
const Vertex &Polygon::last() const
{
	return this->points->last();
}

/**
*	@brief fuegt dem Polygon einen Punkt hinzu
*
*	@param v den hinzuzufuegenden Punkt
*/
void Polygon::addPoint(const Vertex &v)
{
	this->points = new VertexLi(v, this->points);  /* neuen Punkt hinzufuegen */
}

/**
*	@brief transformiert jeden Punkt des Polygons mit der uebergebenen 
*	Matrix
*
*	@param m Matrix, die zum transformieren benutzt werden soll
*/
void Polygon::transform(const Matrix &m)
{
	VertexLi *tmp = this->points;
	this->points = this->points->transform(m); 
										   /* Liste mit Matrix transformieren */
	delete tmp;
}

/**
*	@brief gibt den absoluten Mittelpunkt des Polygons zurueck
*	
*	@param positiv gibt an, ob der Mittelpunkt als (x,y) oder (-x,-y) 
*	zurueckgegeben werden soll
*
*	@return den absoluten Mittelpunkt des Poylgons
*/
Vertex Polygon::getCenterABS(const bool positiv) const
{
	Vertex v=this->getCenterREL(positiv);
	Vertex v1=this->points->head();
	
	if(positiv) 
	{	
		return Vertex(v.getX()+v1.getX(), v.getY()+v1.getY());
	}
	return Vertex(v.getX()-v1.getX(), v.getY()-v1.getY());
}

/**
*	@brief gibt den relativen Mittelpunkt des Polygons zurueck
*	
*	@param positiv gibt an, ob der Mittelpunkt als (x,y) oder (-x,-y) 
*	zurueckgegeben werden soll
*
*	@return den relativen Mittelpunkt des Poylgons
*/
Vertex Polygon::getCenterREL(const bool positiv) const
{
	double x=0;
	double y=0;
	
	double sum_x=0;
	double sum_y=0;
	int n=this->points->length();
	
	VertexLi *current=this->points;
	while(!current->isEmpty())
	{
		sum_x=sum_x+current->head().getX();
		sum_y=sum_y+current->head().getY();
		
		current=current->tail();
	}
	
	x=sum_x/n;
	y=sum_y/n;
	
	if(positiv) 
	{
		return Vertex(x,y);
	}
	return Vertex(-1*x,-1*y);
}

/**
*	@brief zentriert das Polygon
*/
void Polygon::centerThatPolygon()
{
	VertexLi *old=this->points;
	VertexLi *current=this->points;
	VertexLi *newLi=new VertexLi();
	Vertex toCenter = this->getCenterREL(false);
	
	while(!current->isEmpty())
	{
		Vertex v = current->head();
		v.move(toCenter);		
		newLi=new VertexLi(v, newLi);
		current=current->tail();
	}
	
	delete old;
	
	this->points=newLi;
}

/**
*	@brief konvertiert die Liste der Punkte des Polygons in ein QPoint-Array
*
*	@return ein QPointArray mit allen Punkten des Polygons
*/
QPointF *Polygon::toQPointFArray() const
{
	unsigned int i=0;
	unsigned int n=this->points->length();
	QPointF *const tmp = new QPointF[n];
	
	VertexLi *current=this->points;
	while(!current->isEmpty())
	{
		Vertex v=current->head();
		tmp[i]=QPointF(v.getX(), v.getY());
		i=i+1;	
		current=current->tail();
	}
	
	return tmp;
}

/**
*	@brief zeichnet das 'this'-Polygon auf dem uebergebenen QPainter-Objekt
*
*	@param painter QPainter-Objekt, auf dem das Polygon gezeichnet werden 
*	soll
*/
void Polygon::paintMe(QPainter &painter)
{
	this->centerThatPolygon();
	
	unsigned int n=this->points->length();
	
	QPointF *const polygon = this->toQPointFArray();
	
	painter.drawPolygon(polygon, n);
	
	delete polygon;		
}

/**
*	@brief gibt das Polygon als ein String ( als { (x,y)....} ) aus
*
*	@return den String, der das Polygon repraesentiert
*/
std::string Polygon::toString() const
{
	return this->points->toString();
}

/**
*	@brief gibt den minimalen X-Wert des Polygons zurueck
*
*	@return minimaler X-Wert einer Koordinate
*/
double Polygon::getMinX() const
{
	VertexLi *current=this->points;
	double minX=current->head().getX();
	double otherX=current->head().getX();
	
	while(!current->isEmpty())
	{
		otherX=current->head().getX();
		if(minX > otherX)
		{
			minX=otherX;
		}
		current=current->tail();
	}
	
	return minX;		
}

/**
*	@brief gibt den minimalen Y-Wert des Polygons zurueck
*
*	@return minimaler Y-Wert einer Koordinate
*/
double Polygon::getMinY() const
{
	VertexLi *current=this->points;
	double minY=current->head().getY();
	double otherY=current->head().getY();
	
	while(!current->isEmpty())
	{
		otherY=current->head().getY();
		if(minY > otherY)
		{
			minY=otherY;
		}
		current=current->tail();
	}
	
	return minY;
}

/**
*	@brief gibt den maximalen X-Wert des Polygons zurueck
*
*	@return maximalen X-Wert einer Koordinate
*/
double Polygon::getMaxX() const
{
	VertexLi *current=this->points;
	double maxX=current->head().getX();
	double otherX=current->head().getX();	
	
	maxX=current->head().getX();
	
	while(!current->isEmpty())
	{
		otherX=current->head().getX();
		if(maxX < otherX)
		{
			maxX=otherX;
		}
		current=current->tail();
	}
	
	return maxX;
}

/**
*	@brief gibt den maximalen Y-Wert des Polygons zurueck
*
*	@return maximalen Y-Wert einer Koordinate
*/
double Polygon::getMaxY() const
{
	VertexLi *current=this->points;
	double maxY=current->head().getY();
	double otherY=current->head().getY();
	
	while(!current->isEmpty())
	{
		otherY=current->head().getY();
		if(maxY < otherY)
		{
			maxY=otherY;
		}
		current=current->tail();
	}
	
	return maxY;
}

/**
*	@brief gibt die Hoehe des Polygons zurueck
*
*	@return Hoehe des Polygons
*/
double Polygon::getHeight() const
{
	return this->getMaxY()-this->getMinY()+1;
}

/**
*	@brief gibt die Weite des Polygons zurueck
*
*	@return Weite des Polygons
*/
double Polygon::getWidth() const
{
	return this->getMaxX()-this->getMinX()+1;
}

/**
*	@brief schreibt das Polygon als XML in den uebergebenen Zielstream
*	
*	@param dest Zielstream der XML-Datei
*/
void Polygon::writeXML(std::fstream &dest) const
{
	dest << "<polygon>" << std::endl;  /* Polygon-Tag in Zielstream schreiben */
	
	this->points->writeXML(dest);
	
	dest << "</polygon>" << std::endl;
								   /* Polygon-End-Tag in Zielstream schreiben */
}

/**
*	@brief gibt eine Kopie des Polygon im sichtbaren Bereich zurueck
*
*	Wichtig fuer die Ausgabe als SVG-Datei oder zum Drucken
*
*	@return eine Kopie des Polygon im sichtbaren Bereich
*/
Polygon *Polygon::intoRampenlicht()
{
	                     /* Polygon bzw. Kopie in sichtbaren bereich schieben */
	double minX=this->getMinX();
	double minY=this->getMinY();	
	
	Vertex v(-1*minX, -1*minY);
	
	VertexLi *copy = this->points->add(v);	
	
	return new Polygon(copy);
}

/**
*	@brief schreibt das Polygon als SVG in den uebergebenen Zielstream
*	
*	@param dest Zielstream der SVG-Datei
*/	
void Polygon::writeSVG(std::fstream &dest) const
{	
	Polygon *p_copy = const_cast<Polygon *>(this)->intoRampenlicht();	
	
	p_copy->getPoints()->writeSVG(dest);
	
	delete p_copy;
}
	
