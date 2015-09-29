/******************************************************************************/
/* Matrix.cpp           	                                                  */
/******************************************************************************/

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "util/Matrix.hpp"

/******************************************************************************/
/* Klassendefinition														  */
/******************************************************************************/

/**
*	@brief Konstruktor
*
*	erzeugt ein neues Objekt vom Typ <em>Matrix</em>
*
*	@param x1y1 linke obere Ecke
*	@param x1y2 linke obere Ecke
*	@param x2y1 linke obere Ecke
*	@param x2y2 linke obere Ecke
*/
Matrix::Matrix(const double x1y1, const double x2y1, 
		const double x1y2, const double x2y2)
	:x1y1(x1y1), x1y2(x1y2), x2y1(x2y1), x2y2(x2y2)
{

}

/**
*	@brief Kopier-Konstruktor
*
*	kopiert ein Objekt vom Typ <em>Matrix</em>
*
*	@param rhs Matrix, die kopiert werden soll
*/
Matrix::Matrix(const Matrix &rhs)
	:ToString::ToString(), x1y1(rhs.m11()), x1y2(rhs.m12()), x2y1(rhs.m21()),
	x2y2(rhs.m22())
{

}

/**
*	@brief Desktruktor
*
*	loescht ein Objekt vom Typ <em>Circle</em>
*/
Matrix::~Matrix()
{

}

/**
*	@brief gibt die linke obere Korrdinate der Matrix zurueck
*
*	@return die linke obere Korrdinate der Matrix
*/
double Matrix::m11() const
{
	return this->x1y1;
}

/**
*	@brief gibt die linke untere Korrdinate der Matrix zurueck
*
*	@return die linke untere Korrdinate der Matrix
*/
double Matrix::m12() const
{
	return this->x1y2;
}

/**
*	@brief gibt die rechte obere Korrdinate der Matrix zurueck
*
*	@return die rechte obere Korrdinate der Matrix
*/
double Matrix::m21() const
{
	return this->x2y1;
}

/**
*	@brief gibt die rechte untere Korrdinate der Matrix zurueck
*
*	@return die rechte untere Korrdinate der Matrix
*/
double Matrix::m22() const
{
	return this->x2y2;
}

/**
*	@brief ueberladener ==-Operator, um zwei Matrizen komponentenweise 
*	vergleichen zu koennen
*
*	@param that die mit der 'this'-Matrix zu vergleichende Matrix
*
*	@return ob die beiden Matrizen gleich sind
*/
bool Matrix::operator==(const Matrix &that) const
{
	if(this->x1y1!=that.x1y1) return false;
	if(this->x1y2!=that.x1y2) return false;
	if(this->x2y1!=that.x2y1) return false;
	if(this->x2y2!=that.x2y2) return false;
	
	return true;                   /* Matrizen gleichen sich komponentenweise */
}

/**
*	@brief ueberladener *-Operator, um eine Matrix mit einem Vertex zu
*	multiplizieren	
*
*	@param v der mit der 'this'-Matrix zu multiplizierende Vektor
*
*	@return das Ergebnis der Multiplikation
*/
const Vertex Matrix::operator*(const Vertex v) const
{	
	return Vertex(	(this->x1y1*v.getX())+(this->x2y1*v.getY()),
					(this->x1y2*v.getX())+(this->x2y2*v.getY())	);
}

/**
*	@brief gibt die Matrix als String zurueck
*
*	@return die Matrix repraesentiert als String
*/
std::string Matrix::toString() const
{
	std::string result="\n(";
	
	result=result+this->x1y1+" "+this->x2y1+")\n"
		+"("+this->x1y2+" "+this->x2y2+")\n";
		
	return result;
}

/**
*	@brief ueberladener !-Operator, um eine Matrix einfach zu invertieren
*
*	@return die invertierte Matrix
*/
const Matrix &Matrix::operator!() const
{
	const Matrix &m=this->inverse();
	
	return m;
}

/**
*	@brief invertiert die 'this'-Matrix
*
*	@return die invertierte Matrix
*/
const Matrix Matrix::inverse() const
{
	const double eps=0.001;                                        /* Epsilon */

	double a=1,b=0,c=0,d=1;
	double det = (this->x1y1*this->x2y2) - (this->x1y2*this->x2y1);
	
	if(det+eps>0 && det-eps<0)                         /* Determinante nahe 0 */
	{
		
		return Matrix(a,b,c,d);         /* Einheitsmatrix / Identitaetsmatrix */
	}

	a = (this->x2y2)/(det);                         /* Inversmatrix berechnen */
	if(this->x2y1!=0) {b = (-1* (this->x2y1))/(det);} else {b=0;}
	if(this->x1y2!=0) {c = (-1* (this->x1y2))/(det);} else {c=0;}
	d = (this->x1y1)/(det);
	
	return Matrix(a, b, c, d);
}
