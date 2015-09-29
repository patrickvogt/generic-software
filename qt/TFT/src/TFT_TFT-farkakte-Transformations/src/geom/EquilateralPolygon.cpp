/******************************************************************************/
/* EquilateralPolygon.cpp  	                                                  */
/******************************************************************************/ 

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "geom/EquilateralPolygon.hpp"

/******************************************************************************/
/* Klassendefinition														  */
/******************************************************************************/

/**
*	@brief Konstruktor
*
*	erzeugt ein neues Objekt vom Typ <em>EquilateralPolygon</em>
*
*	@param x x-Korrdinate
*	@param y y-Korrdinate 
*	@param width Breite und Hoehe
*	@param n Anzahl der Kanten
*/
EquilateralPolygon::EquilateralPolygon(const double x, const double y, 
	const double width, const int n)
{
	               /* Winkel fuer die Berechnung der einzelnen Polygon-punkte */
	const double angle=360/n;
	
	double passedAngle=angle;
	
	Vertex center(x+width/2, y+width/2);
	
	Vertex origin(x, y);
	
	VertexLi *tmp = new VertexLi(origin, new VertexLi());
	
	Vertex edge(origin.getX()-center.getX(), origin.getY()-center.getY());
	
	do {                 /* SOLANGE ein kompletter Vollkreis abgelaufen wurde */
	
		edge=edge.rotate(angle);         /* rotiere den Punkt um 'angle' Grad */
		
		/* neuer Punkt, der dem Polygon, bzw. der VertexListe hinzugefuegt 
		                                                                 wird */
		tmp = new VertexLi(
			Vertex(center.getX()+edge.getX(), center.getY()+edge.getY()), tmp);
		passedAngle=passedAngle+angle; /*'passierte' Grad Winkel aktualisieren*/
	}
	while(passedAngle<360.0);
	
	this->points=tmp;               /* points-Liste des Polygon aktualisieren */
}

/**
*	@brief Destruktor
*
*	loescht ein Objekt vom Typ <em>EquilateralPolygon</em>
*/
EquilateralPolygon::~EquilateralPolygon()
{

}
