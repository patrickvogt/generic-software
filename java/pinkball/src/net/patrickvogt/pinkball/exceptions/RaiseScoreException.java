package net.patrickvogt.pinkball.exceptions;

/*
 * RaiseScoreException.java
 */

/**
 * implementiert eine Exception die signalisiert, dass der PunkteStand erhoeht werden soll
 * 
 * @author Patrick Vogt
 *
 */
public class RaiseScoreException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * erzeugt eine neue Instanz von <code>RaiseScoreException</code>
	 */
	public RaiseScoreException() {
		super();
	}
}
