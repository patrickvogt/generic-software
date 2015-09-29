/******************************************************************************/
/* WriteAsSVG.hpp         	                                                  */
/******************************************************************************/ 

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _WRITEASSVG_HPP_
#define _WRITEASSVG_HPP_

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
*	kann, Bilder als SVG-Datei herauszuschrieben
*/
class WriteAsSVG
{
private:

protected:

public:
	/**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>WriteAsSVG</em>
	*/
	WriteAsSVG();
	
	/**
	*	@brief Desktruktor
	*
	*	loescht ein Objekt vom Typ <em>ReadFromSVG</em>
	*/
	virtual ~WriteAsSVG();
	
	/**
	*	@brief schreibt eine SVG-Datei in den Zielstream
	*
	*	abstrakte Methode, die von den implementierenden Klassen implementiert 
	*	werden muss
	*
	*	@param dest Zielstream, in den die SVG-Datei geschrieben werden soll
	*/	
	virtual void writeSVG(std::fstream &dest) const=0;

};

#endif /* _WRITEASSVG_HPP_ */
