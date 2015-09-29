/******************************************************************************/
/* WriteAsXML.hpp         	                                                  */
/******************************************************************************/ 

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _WRITEASXML_HPP_
#define _WRITEASXML_HPP_

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include <iostream>
#include <fstream>

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@author Patrick Vogt
*
*	@brief PSEUDO-Interface, welches von anderen Klassen implementiert werden 
*	kann, um Daten als XML-Dateien rauszuschreiben
*/
class WriteAsXML
{
private:

protected:

public:
	/**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>WriteAsXML</em>
	*/
	WriteAsXML();
	
	/**
	*	@brief Desktruktor
	*
	*	loescht ein Objekt vom Typ <em>WriteAsXML</em>
	*/
	virtual ~WriteAsXML();
	
	/**
	*	@brief schreibt eine XML-konforme Datei in den Zielstream
	*
	*	abstrakte Methode, die von den implementierenden Klassen implementiert 
	*	werden muss
	*
	*	@param dest Zielstream, in den die XML-Datei geschrieben werden soll
	*/	
	virtual void writeXML(std::fstream &dest) const=0;

};

#endif /* _WRITEASSVG_HPP_ */
