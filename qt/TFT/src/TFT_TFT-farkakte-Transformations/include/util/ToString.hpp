/******************************************************************************/
/* ToString.hpp           	                                                  */
/******************************************************************************/ 

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _TOSTRING_HPP_
#define _TOSTRING_HPP_

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include <string>

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@author Patrick Vogt
*
*	@brief PSEUDO-Interface, das andere Klassen implementieren koennen, die sich
*	selbst als String ausgeben wollen koennen
*/
class ToString 
{
private:

protected:

public:
	/**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>ToString</em>
	*/
	ToString();
	
	/**
	*	@brief Desktruktor
	*
	*	loescht ein Objekt vom Typ <em>ToString</em>
	*/
	virtual ~ToString();
	
	/**
	*	@brief gibt einen String zurueck
	*
	*	abstrakte Methode, die von den implementierenden Klassen implementiert 
	*	werden muss
	*
	*	@return einen String, der die jeweilige Klasse repraesentiert
	*/
	virtual std::string toString() const=0;
};

/**
*	@brief ueberladener +-Operator der einen String mit einem doble-Wert 
*	konkateniert
*
*	@param s String der links vom '+' steht
*	@param i double-Wert der rechts vom '+' steht
*
*	@return den konkatenierten String
*/
std::string operator+(const std::string s, const double i);

/**
*	@brief ueberladener +-Operator der einen doble-Wert mit einem String
*	konkateniert
*
*	@param i double-Wert der rechts vom '+' steht
*	@param s String der links vom '+' steht
*
*	@return den konkatenierten String
*/
std::string operator+(const double i, const std::string s);

#endif /* _TOSTRING_HPP_ */
