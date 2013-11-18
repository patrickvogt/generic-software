package net.patrickvogt.pinkball.util;

/*
 * Moveable.java
 */

/**
 * beschreibt, welche Methoden ein Objekt implementieren muss um 'beweglich' (engl. <code>Moveable</code>) 
 * zu sein
 * 
 * @author Patrick Vogt
 *
 */
public interface Moveable {
	
	/**
	 * 'Bewegungs'-Methode, die das <code>this</code>-Objekt um 
	 * einen bestimmten Vektor im 2-dimensionalen Raum bewegt
	 */		
	public void move();
	
}
