/******************************************************************************/
/* ReadFromXML.hpp         	                                                  */
/******************************************************************************/ 

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _READFROMXML_HPP_
#define _READFROMXML_HPP_

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include <iostream>
#include <fstream>
#include <QString>

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@author Patrick Vogt
*
*	@brief PSEUDO-Interface, welches von anderen Klassen implementiert werden 
*	kann, um XML-Dateien einzulesen
*/
class ReadFromXML
{
private:

protected:

public:
	/**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>ReadFromXML</em>
	*/
	ReadFromXML();
	
	/**
	*	@brief Desktruktor
	*
	*	loescht ein Objekt vom Typ <em>ReadFromXML</em>
	*/
	virtual ~ReadFromXML();
	
	/**
	*	@brief liest eine XML-Datei ein
	*
	*	abstrakte Methode, die von den implementierenden Klassen implementiert 
	*	werden muss
	*
	*	@param src Dateiname der einzulesenden Datei
	*/	
	virtual void readXML(QString &src)=0;

};

#endif /* _READFROMXML_HPP_ */
