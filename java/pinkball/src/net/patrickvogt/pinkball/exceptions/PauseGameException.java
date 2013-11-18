package net.patrickvogt.pinkball.exceptions;

/*
 * PauseGameException.java
 */

/**
 * implementiert eine Exception, die singalisiert, dass das Spiel pausiert werden soll
 * (bspw. durch Tastendruck oder durch die Auswahl in der MenuBar)
 * 
 * @author Patrick Vogt
 *
 */
public class PauseGameException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * erzeugt eine neue Instanz von <code>PauseCodeException</code>
	 */
	public PauseGameException() {
		super();
	}
}
