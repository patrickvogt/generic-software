/******************************************************************************/
/* Matrix.hpp           	                                                  */
/******************************************************************************/

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _MATRIX_HPP_
#define _MATRIX_HPP_

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "ToString.hpp"
#include "Vertex.hpp"
#include <string>
#include <iostream>

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@author Patrick Vogt
*
*	@brief implementiert eine 2x2-er Matrix (double)
*/
class Matrix: public ToString
{
private:
	/**
	*	@brief linke obere 'Koordinate'
	*/
	double x1y1;
	
	/**
	*	@brief linke untere 'Koordinate'
	*/
	double x1y2;
	
	/**
	*	@brief rechte obere 'Koordinate'
	*/
	double x2y1;
	
	/**
	*	@brief rechte untere 'Koordinate'
	*/
	double x2y2;
	
protected:

public:	
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
	Matrix(const double x1y1, const double x1y2, 
		const double x2y1, const double x2y2);
		
	/**
	*	@brief Kopier-Konstruktor
	*
	*	kopiert ein Objekt vom Typ <em>Matrix</em>
	*
	*	@param rhs Matrix, die kopiert werden soll
	*/
	Matrix(const Matrix &rhs);
	
	/**
	*	@brief Desktruktor
	*
	*	loescht ein Objekt vom Typ <em>Circle</em>
	*/
	virtual ~Matrix();
	
	/**
	*	@brief gibt die linke obere Korrdinate der Matrix zurueck
	*
	*	@return die linke obere Korrdinate der Matrix
	*/
	double m11() const;
	
	/**
	*	@brief gibt die rechte obere Korrdinate der Matrix zurueck
	*
	*	@return die rechte obere Korrdinate der Matrix
	*/
	double m21() const;
	
	/**
	*	@brief gibt die linke untere Korrdinate der Matrix zurueck
	*
	*	@return die linke untere Korrdinate der Matrix
	*/
	double m12() const;
	
	/**
	*	@brief gibt die rechte untere Korrdinate der Matrix zurueck
	*
	*	@return die rechte untere Korrdinate der Matrix
	*/
	double m22() const;
	
	/**
	*	@brief invertiert die 'this'-Matrix
	*
	*	@return die invertierte Matrix
	*/
	const Matrix inverse() const;
	
	/**
	*	@brief ueberladener ==-Operator, um zwei Matrizen komponentenweise 
	*	vergleichen zu koennen
	*
	*	@param that die mit der 'this'-Matrix zu vergleichende Matrix
	*
	*	@return ob die beiden Matrizen gleich sind
	*/
	bool operator==(const Matrix &that) const;
	
	/**
	*	@brief ueberladener *-Operator, um eine Matrix mit einem Vertex zu
	*	multiplizieren	
	*
	*	@param v der mit der 'this'-Matrix zu multiplizierende Vektor
	*
	*	@return das Ergebnis der Multiplikation
	*/
	const Vertex operator*(const Vertex v) const;
	
	/**
	*	@brief ueberladener !-Operator, um eine Matrix einfach zu invertieren
	*
	*	@return die invertierte Matrix
	*/
	const Matrix &operator!() const;
	
	/**
	*	@brief gibt die Matrix als String zurueck
	*
	*	@return die Matrix repraesentiert als String
	*/	
	std::string toString() const;
};

#endif /* _MATRIX_HPP_ */
