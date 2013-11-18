package net.patrickvogt.pinkball.exceptions;

/*
 * DestroyThatException.java
 */

import net.patrickvogt.pinkball.geom.*;

/**
 * implementiert eine Exception die geworfen wird, wenn ein Objekt vom Spielfeld gelescht werden soll.
 * Dabei entschieden die beiden Felder der Exception welches Element vom Spielfeld geloescht werden soll
 * und ob danach der Punktestand (Score) erhoeht werden soll
 * 
 * @author Patrick Vogt
 *
 */
public class DestroyThatException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * beschreibt, welches Element vom Spielfeld geloescht werden soll
	 */
	private GeometricObject destroyMe;
	/**
	 * beschreibt, ob der Punktestand erhoeht werden soll
	 */
	private boolean raiseScore=false;

	/**
	 * erzeugt eine neue <code>DestroyThat</code>-Exception mit den beiden 
	 * 
	 * @param that das Element das vom Spielfeld geloescht werden soll
	 * 
	 * @param _raiseScore der bool'sche Wert ob der Punktestand erhoeht werde muss
	 * 
	 */
	public DestroyThatException(GeometricObject that, boolean _raiseScore) {
		super();
		//this-Felder setzen
		this.destroyMe=that;
		this.raiseScore=_raiseScore;
	}
	/**
	 * Zugriffsmethode um das Element welches vom Spielfeld geloescht werden soll zu bekommen
	 * 
	 * @return welches Element vom Spielfeld geloescht werden soll
	 * 
	 */
	public GeometricObject getElementToDestroy() {
		return(this.destroyMe);
	}
	
	/**
	 * Zugriffsmethode um den boolschen Wert zu bekommen, ob der Punktestand erhoeht werden muss
	 * 
	 * @return ob der Punktestand erhoeht werden muss
	 * 
	 */
	public boolean getRaiseScore() {
		return(this.raiseScore);
	}
}
