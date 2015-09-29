/******************************************************************************/
/* ToString.cpp           	                                                  */
/******************************************************************************/

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "util/ToString.hpp"
#include <sstream>

/******************************************************************************/
/* Klassendefinition														  */
/******************************************************************************/

/**
*	@brief Konstruktor
*
*	erzeugt ein neues Objekt vom Typ <em>ToString</em>
*/
ToString::ToString()
{

}

/**
*	@brief Desktruktor
*
*	loescht ein Objekt vom Typ <em>ToString</em>
*/
ToString::~ToString()
{

}

/**
*	@brief Hilfsmehtode, die einen double-Wert in einen String 'umwandelt'
*
*	@param i double-Wert der konvertiert werden soll
*
*	@return den konvertierten double-Wert als String
*/
std::string doubleToString(const double i)
{
	std::stringstream sts;
	sts<<i;
	return sts.str();
}

/**
*	@brief ueberladener +-Operator der einen String mit einem doble-Wert 
*	konkateniert
*
*	@param s String der links vom '+' steht
*	@param i double-Wert der rechts vom '+' steht
*
*	@return den konkatenierten String
*/
std::string operator+(const std::string s, const double i)
{
	return s+doubleToString(i);
}

/**
*	@brief ueberladener +-Operator der einen doble-Wert mit einem String
*	konkateniert
*
*	@param i double-Wert der rechts vom '+' steht
*	@param s String der links vom '+' steht
*
*	@return den konkatenierten String
*/
std::string operator+(const double i, const std::string s)
{
	return doubleToString(i)+s;
}
