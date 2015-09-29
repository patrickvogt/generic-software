/******************************************************************************/
/* VertexLi.hpp           	                                                  */
/******************************************************************************/ 

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _VERTEXLI_HPP_
#define _VERTEXLI_HPP_

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include <string>
#include "ToString.hpp"
#include "Vertex.hpp"
#include "Matrix.hpp"
#include "WriteAsXML.hpp"
#include "WriteAsSVG.hpp"

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@author Patrick Vogt
*
*	@brief implementiert eine rekursiv definierte Liste, die Vertexe halten kann 
*/
class VertexLi: public ToString, public WriteAsXML, public WriteAsSVG
{

private:
	/**
	*	@brief ein Vertex-Objekt
	*/
    Vertex hd;
    
    /**
	*	@brief der Zeiger auf den Rumpf der Liste
	*/
    VertexLi *tl;
    
    /**
	*	@brief Hilfsvariable, die festhaelt, ob das aktuelle Objekt leer ist
	*	bzw. das letzte Element ist
	*/
    bool isEmpt;
    
    /**
	*	@brief Hilfsmethode, die zur Ausgabe der Liste als String benoetigt wird
	*
	*	@return String der die Liste repraesentiert
	*/    
    std::string toStringAux() const;
    
    /**
	*	@brief Hilfsmethode, die zum Schreiben der Liste als SVG benoetigt wird
	*
	*	@param dest Zielstream der SVG-Datei
	*/     
    void innerWriteSVG(std::fstream &dest) const;

protected:

public:
	/**
	*	@brief Konstruktor fuer eine leere Liste
	*
	*	erzeugt ein neues leeres Objekt vom Typ <em>VertexLi</em>
	*/
    explicit VertexLi();
    
    /**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>VertexLi</em>
	*
	*	@param h Kopf der neuen Liste
	*	@param t Rumpf der neuen Liste
	*/
    VertexLi(Vertex h, VertexLi *const t);
    
    /**
	*	@brief Kopier-Konstruktor
	*
	*	kopiert ein Objekt vom Typ <em>VertexLi</em>
	*
	*	@param rhs die zu kopierende Liste
	*/
    VertexLi(const VertexLi &rhs);
    
    /**
	*	@brief Desktruktor
	*
	*	loescht ein Objekt vom Typ <em>VertexLi</em>
	*/
    virtual ~VertexLi();
    
    /**
	*	@brief gibt den Kopf der Liste zurueck
	*
	*	@return den Kopf der Liste
	*/    
    const Vertex &head() const;
    
    /**
	*	@brief gibt den Rumpf der Liste zurueck
	*
	*	@return den Rumpf der Liste
	*/
    VertexLi *tail() const;
    
    /**
	*	@brief gibt den ersten Vertex der Liste zurueck
	*
	*	@return erster Vertex der Liste
	*/
	const Vertex &first() const;
	
	/**
	*	@brief gibt den letzten Vertex der Liste zurueck
	*
	*	@return letzter Vertex der Liste
	*/
	const Vertex &last() const;
    
    /**
	*	@brief testet ob eine Liste leer ist
	*
	*	@return ob die Liste leer
	*/
    bool isEmpty() const;
    
    /**
	*	@brief kopiert die 'this'-Liste
	*
	*	@return die kopierte 'this'-Liste
	*/
    VertexLi *copy() const;
    
    /**
	*	@brief gibt die Laenge der Liste zurueck
	*
	*	@return die Laenge der Liste
	*/
    unsigned int length() const;
    
    /**
	*	@brief gibt das i. Element in der Liste zurueck
	*
	*	@param i der Index des Elements innerhalb der Liste
	*
	*	@return das i. Element der Liste
	*/
    const Vertex get(const unsigned int i) const;
    
    /**
	*	@brief gibt eine Teilliste bestehend aus den ersten i Elementen zurueck
	*
	*	@param i Index der Grenze bis wohin die Teilliste gehen soll
	*
	*	@return Teilliste bestehend aus den ersten i Elementen
	*/
    VertexLi *take(const unsigned int i) const;
    
    /**
	*	@brief gibt eine Teilliste ohne die ersten i Elementen zurueck
	*
	*	@param i Index der Grenze ab der die Teilliste beginnen soll
	*
	*	@return Teilliste ohne die ersten i Elementen
	*/
    VertexLi *drop(const unsigned int i) const;
    
    /**
	*	@brief gibt eine Teilliste vom from. Element zum to. Element zurueck
	*
	*	@param from hier soll die Teilliste beginnen
	* 	@param to bis hierhin soll die Teilliste gehen
	*	
	*	@return Teilliste vom from. Element zum to. Element
	*/
    VertexLi *sublist(const unsigned int from, const unsigned int to) 
    	const;
    	
    /**
	*	@brief konkateniert zwei Listen
	*
	*	@param other die Liste, die an die 'this'-Liste angehaengt werden soll
	*
	*	@return die konkatenierte Liste
	*/
    VertexLi *append(VertexLi *const other) const;
    
    /**
	*	@brief prueft, ob die 'this'-Liste das uebergebene Element enthaelt
	*
	*	@param elem das Element welches ueberprueft werden soll
	*
	*	@return ob die Liste das Element enthaelt
	*/
    bool contains(const Vertex &elem) const; 
    
    /**
	*	@brief prueft, ob sich 'this'-Liste und uebergebene Liste gleichen
	*
	*	@param that die Liste, die mit der 'this'-Liste vergleicht werden soll
	*
	*	@return ob die beiden Listen sich gleichen
	*/   
    bool equals(VertexLi *const that) const; 
        
    /**
	*	@brief transformiert alle Vertexe der Liste mit der uebergebenen Matrix
	*
	*	@param m die Matrix mit der die Vertexe transformiert werden sollen
	*
	*	@return die Liste mit den transformierten Vertexen
	*/    
    VertexLi *transform(const Matrix &m) const;    
    
    /**
	*	@brief transformiert alle Vertexe der Liste mithilfe der uebergebenen 
	*	Funktion
	*
	*	@return die Liste mit den transformierten Vertexen
	*/  
    VertexLi *transform(Vertex &(f)(Vertex)) const;
    
    /**
	*	@brief fuegt der Liste einen Vertex hinzu
	*
	*	@param v der Vertex, der hinzugefuegt werden soll
	*
	*	@return die neue Liste mit dem eingefuegten Vertex
	*/ 
    VertexLi *add(const Vertex &v) const;
    
    /**
	*	@brief gibt einen String zurueck, der die Liste repraesentiert
	*
	*	@return der String, der die Liste repraesentiert
	*/ 
    std::string toString() const;
    
    /**
	*	@brief schreibt eine VertexListe XML-konform in den Zielstream
	*
	*	@param dest der Zielstream, in den die Liste geschrieben werden soll
	*/     
    virtual void writeXML(std::fstream &dest) const;
    
    /**
	*	@brief schreibt eine VertexListe SVG-konform in den Zielstream
	*
	*	@param dest der Zielstream, in den die Liste geschrieben werden soll
	*/  
	virtual void writeSVG(std::fstream &dest) const;
};

#endif /* _VERTEXLI_HPP_ */

