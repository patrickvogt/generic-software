package net.patrickvogt.pinkball.exceptions;

/*
 * GameOverException.java
 */

/**
 * implementiert eine Exception die singalisiert, dass das Spiel verloren wurde, wenn bspw. eine 
 * blaue Kugel in ein gelbes BlackHole gefallen ist
 * 
 * @author Patrick Vogt
 *
 */
public class GameOverException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * erzeugt eine neue Instanz von <code>GameOverException</code>
	 */
	public GameOverException() {
		super();
	}
}
