package net.patrickvogt.pinkball.exceptions;

/*
 * NextLevelException.java
 */

/**
 * implementiert eine Exception, die geworfen wird, wenn das aktuelle Level absolviert wurde und
 * nun zum naechsten Level gesprungen werden soll
 * 
 * @author Patrick Vogt
 *
 */
public class NextLevelException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * erzeugt eine neue Instanz von <code>NextLevelException</code>
	 */
	public NextLevelException() {
		super();
	}
}
