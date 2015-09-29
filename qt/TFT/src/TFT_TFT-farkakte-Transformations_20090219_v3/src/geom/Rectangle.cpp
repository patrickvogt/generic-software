/******************************************************************************/
/* Rectangle.cpp           	                                                  */
/******************************************************************************/

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "geom/Rectangle.hpp"

/******************************************************************************/
/* Klassendefinition														  */
/******************************************************************************/

/**
*	@brief Konstruktor
*
*	erzeugt ein neues Objekt vom Typ <em>Rectangle</em>
*
*	@param x x-Koordinate
*	@param y y-Koordinate
*	@param width Weite
*	@param height Hoehe
*/
Rectangle::Rectangle(const int x, const int y, const int width, const int height)
{
	
	Vertex points[4] =          /* Vertex-Array mit allen 4 Punkten erstellen */
		{
			Vertex(x,y), 
			Vertex(x+width, y), 
			Vertex(x+width, y+height), 
			Vertex(x, y+height)
		};
		
	VertexLi *tmp=new VertexLi();  /* Vertex-Array in eine VertexLi umwandeln */
	for(int i=0; i<4; i=i+1)
	{
		tmp = new VertexLi(points[i], tmp);
	}
	
	this->points=tmp;
}

/**
*	@brief Destruktor
*
*	loescht ein Objekt vom Typ <em>Rectangle</em>	
*/
Rectangle::~Rectangle()
{

}
