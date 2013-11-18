package net.patrickvogt.pinkball.vector;

/*
 * Vector.java
 */

/**
 * implementiert ein abstraktes Grundgeruest fuer einen 2-dimensionalen
 * Vektor mit einer 1.-Komponente und einer 2.-Komponente und einer passenden
 * <code>equals</code>-Methode, die 2 Instanzen von <code>Vector</code> auf Gleichheit pruefen kann.
 * 
 * @author Patrick Vogt
 *
 */
abstract class Vector {
	
	/**
	 * repraesentiert die 1.-Komponente in einem 2-dimensionalen Vektor
	 */	
	protected double x;
	/**
	 * repraesentiert die 2.-Komponente in einem 2-dimensionalen Vektor
	 */
	protected double y;
	
	/**
	 * <p>prueft zwei Vektoren auf ihre Gleichheit</p>
	 * <p>'gleich' sind zwei Vektoren dann, wenn beide Komponenten der Vektoren
	 * gleich sind</p>
	 * 
	 * @param that mit dem <code>this</code>-Vektor zu vergleichender Vektor
	 * 
	 * @see java.lang.Object#equals(Object)
	 * 
	 * @return ob die Vektoren gleich sind
	 * 
	 */
	@Override
	public boolean equals(Object that) {
		//sind this und that identisch? => this und that sind auch gleich
		if(this==that) {
			return(true);
		}
		//ist that eine Instanz von Vector (oder einer Unterklasse von Vector)? 
		else if(that instanceof Vector) {
			//gleichen sich 1.-Komponente und 2.-Komponente der Vektoren
			if(Math.round(this.x)==Math.round(((Vector)that).x) 
					&& Math.round(this.y)==Math.round(((Vector)that).y)) {
				return(true);
			}
			else {
				return(false);
			}
		}	
		else {
			//that ist keine Instanz von Vector (oder deren Unterklassen)
			// => that kann nicht dem this-Vektor gleichen
			return(false);
		}
	}
}
