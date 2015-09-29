/******************************************************************************/
/* VertexLi.cpp           	                                                  */
/******************************************************************************/

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "util/VertexLi.hpp"

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@brief Konstruktor fuer eine leere Liste
*
*	erzeugt ein neues leeres Objekt vom Typ <em>VertexLi</em>
*/
VertexLi::VertexLi()
	:hd(0.0,0.0), tl(NULL), isEmpt(true)
{
	
}

/**
*	@brief Konstruktor
*
*	erzeugt ein neues Objekt vom Typ <em>VertexLi</em>
*
*	@param h Kopf der neuen Liste
*	@param t Rumpf der neuen Liste
*/
VertexLi::VertexLi(Vertex h,VertexLi *const t)
	:hd(h), tl(t), isEmpt(false)
{

}

/**
*	@brief Kopier-Konstruktor
*
*	kopiert ein Objekt vom Typ <em>VertexLi</em>
*
*	@param rhs die zu kopierende Liste
*/
VertexLi::VertexLi(const VertexLi &rhs)
	:ToString::ToString(), WriteAsXML::WriteAsXML(), WriteAsSVG::WriteAsSVG(), 
		hd(rhs.head()), tl(rhs.tail()->copy())
{

}

/**
*	@brief Desktruktor
*
*	loescht ein Objekt vom Typ <em>VertexLi</em>
*/
VertexLi::~VertexLi() 
{
    if(!this->isEmpty()) 
    {
    	delete this->tail();
    }
}

/**
*	@brief gibt den Kopf der Liste zurueck
*
*	@return den Kopf der Liste
*/ 
const Vertex &VertexLi::head() const 
{
    return this->hd;
}

/**
*	@brief gibt den Rumpf der Liste zurueck
*
*	@return den Rumpf der Liste
*/
VertexLi *VertexLi::tail() const 
{
    return this->tl;
}

/**
*	@brief gibt den ersten Vertex der Liste zurueck
*
*	@return erster Vertex der Liste
*/
const Vertex &VertexLi::first() const
{
	return this->hd;
}

/**
*	@brief gibt den letzten Vertex der Liste zurueck
*
*	@return letzter Vertex der Liste
*/
const Vertex &VertexLi::last() const
{
	if(this->tl->isEmpty())
	{
		return this->hd;
	}
	return this->tl->last();
}

/**
*	@brief testet ob eine Liste leer ist
*
*	@return ob die Liste leer
*/
bool VertexLi::isEmpty() const 
{
	return this->isEmpt;
}

/**
*	@brief kopiert die 'this'-Liste
*
*	@return die kopierte 'this'-Liste
*/
VertexLi *VertexLi::copy() const
{
	if(this->isEmpty()) 
	{
		return new VertexLi();
	}
	return new VertexLi(this->head(), this->tail()->copy());	
}

/**
*	@brief gibt die Laenge der Liste zurueck
*
*	@return die Laenge der Liste
*/
unsigned int VertexLi::length() const 
{
	if(this->isEmpty()) 
	{
		return 0;
	}
	return this->tail()->length()+1;
}

/**
*	@brief gibt das i. Element in der Liste zurueck
*
*	@param i der Index des Elements innerhalb der Liste
*
*	@return das i. Element der Liste
*/
const Vertex VertexLi::get(const unsigned int i) const
{
	if(this->isEmpty()) 
	{
		return Vertex(0,0);
	}
	else if(0==i) 
	{
		return this->head();
	}
	return this->tail()->get(i-1);
}

/**
*	@brief gibt eine Teilliste bestehend aus den ersten i Elementen zurueck
*
*	@param i Index der Grenze bis wohin die Teilliste gehen soll
*
*	@return Teilliste bestehend aus den ersten i Elementen
*/
VertexLi *VertexLi::take(const unsigned int i) const
{
	if(this->isEmpty() || (0==i)) 
	{
		return new VertexLi();
	}
	return new VertexLi(this->head(), this->tail()->take(i-1));
}

/**
*	@brief gibt eine Teilliste ohne die ersten i Elementen zurueck
*
*	@param i Index der Grenze ab der die Teilliste beginnen soll
*
*	@return Teilliste ohne die ersten i Elementen
*/
VertexLi *VertexLi::drop(const unsigned int i) const
{
	if(this->isEmpty()) 
	{
		return new VertexLi();
	}
	else if(0==i) 
	{
		return this->copy();
	}
	return this->tail()->drop(i-1);
}
   
/**
*	@brief gibt eine Teilliste vom from. Element zum to. Element zurueck
*
*	@param from hier soll die Teilliste beginnen
* 	@param to bis hierhin soll die Teilliste gehen
*	
*	@return Teilliste vom from. Element zum to. Element
*/ 
VertexLi *VertexLi::sublist(const unsigned int from, 
	const unsigned int to) const
{
	VertexLi *tmp=this->take(to);         /* kopierte Liste zwischenspiechern */
	VertexLi *retval=tmp->drop(from-1);
	delete tmp;					  /* Speicher von temporaerer Liste freigeben */
	return retval;
}

/**
*	@brief konkateniert zwei Listen
*
*	@param other die Liste, die an die 'this'-Liste angehaengt werden soll
*
*	@return die konkatenierte Liste
*/
VertexLi *VertexLi::append(VertexLi* other) const
{
	if(this->isEmpty()) 
	{
		return other->copy();
	}
	return new VertexLi(this->head(), this->tail()->append(other));
}

/**
*	@brief prueft, ob die 'this'-Liste das uebergebene Element enthaelt
*
*	@param elem das Element welches ueberprueft werden soll
*
*	@return ob die Liste das Element enthaelt
*/
bool VertexLi::contains(const Vertex &elem) const
{
	if(this->isEmpty()) 
	{
		return false;
	}
	if(this->head()==elem) 
	{
		return true;
	}
	return this->tail()->contains(elem);
}

/**
*	@brief prueft, ob sich 'this'-Liste und uebergebene Liste gleichen
*
*	@param that die Liste, die mit der 'this'-Liste vergleicht werden soll
*
*	@return ob die beiden Listen sich gleichen
*/ 
bool VertexLi::equals(VertexLi *const that) const
{
	if(this->isEmpty() && that->isEmpty())
	{
		return true;
	}
	if(!(this->head()==that->head())) 
	{
		return false;
	}
	return this->tail()->equals(that->tail());
}

/**
*	@brief transformiert alle Vertexe der Liste mit der uebergebenen Matrix
*
*	@param m die Matrix mit der die Vertexe transformiert werden sollen
*
*	@return die Liste mit den transformierten Vertexen
*/   
VertexLi *VertexLi::transform(const Matrix &m) const
{
	if(this->isEmpty())
	{
		return new VertexLi();
	}
	return new VertexLi((m*(this->head())), this->tail()->transform(m));
}

/**
*	@brief transformiert alle Vertexe der Liste mithilfe der uebergebenen 
*	Funktion
*
*	@return die Liste mit den transformierten Vertexen
*/ 
VertexLi *VertexLi::transform(Vertex &(f)(Vertex)) const
{
	if(this->isEmpty())
	{
		return new VertexLi();
	}
	return new VertexLi(f(this->head()), this->tail()->transform(f));
}

/**
*	@brief fuegt der Liste einen Vertex hinzu
*
*	@param v der Vertex, der hinzugefuegt werden soll
*
*	@return die neue Liste mit dem eingefuegten Vertex
*/ 
VertexLi *VertexLi::add(const Vertex &v) const
{
	if(this->isEmpty())
	{
		return new VertexLi();
	}
	
	const Vertex &h = this->head();
	
	Vertex n_v = Vertex(v.getX()+h.getX(), v.getY()+h.getY());
	return new VertexLi(n_v, this->tail()->add(v));
}

/**
*	@brief gibt einen String zurueck, der die Liste repraesentiert
*
*	@return der String, der die Liste repraesentiert
*/
std::string VertexLi::toString() const 
{
   return "("+this->toStringAux()+")";
}
  
/**
*	@brief Hilfsmethode, die zur Ausgabe der Liste als String benoetigt wird
*
*	@return String der die Liste repraesentiert
*/ 
std::string VertexLi::toStringAux() const
{
	if(this->isEmpty()) 
	{
		return "";
    }
    if(this->tail()->isEmpty())
    {
    	return this->head().toString();
    }
    return this->head().toString()+","+this->tail()->toStringAux();
}

/**
*	@brief schreibt eine VertexListe XML-konform in den Zielstream
*
*	@param dest der Zielstream, in den die Liste geschrieben werden soll
*/
void VertexLi::writeXML(std::fstream &dest) const
{
	if(!this->isEmpty())
	{
		this->head().writeXML(dest);
		this->tail()->writeXML(dest);
	}
}

/**
*	@brief Hilfsmethode, die zum Schreiben der Liste als SVG benoetigt wird
*
*	@param dest Zielstream der SVG-Datei
*/  
void VertexLi::innerWriteSVG(std::fstream &dest) const
{
	if(!this->isEmpty())
	{
		this->head().writeSVG(dest);
		this->tail()->innerWriteSVG(dest);
	}
}

/**
*	@brief schreibt eine VertexListe SVG-konform in den Zielstream
*
*	@param dest der Zielstream, in den die Liste geschrieben werden soll
*/  
void VertexLi::writeSVG(std::fstream &dest) const
{
	dest << "points=\"";
	
	this->innerWriteSVG(dest);
	
	dest << "\"";
}
