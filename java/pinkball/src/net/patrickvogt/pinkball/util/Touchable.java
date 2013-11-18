package net.patrickvogt.pinkball.util;

/*
 * Touchable.java
 */

import net.patrickvogt.pinkball.exceptions.*;
import net.patrickvogt.pinkball.geom.GeometricObject;

/**
 * beschreibt welche Methoden ein Objekt implementieren muss, dass 'beruehrbar' (engl. <code>Touchable</code>) 
 * zu sein
 * 
 * @author Patrick Vogt
 *
 */
public interface Touchable {
	
	/**
	 * Pruefmethode, die testet ob sich das <code>this</code>-Objekt und das <code>that</code>-Objekt beruehren
	 * 
	 * @param that das zu testende 'Beruehr'-Objekt
	 * 
	 * @return ob sich das <code>this</code>-Objekt und das <code>that</code>-Objekt beruehen
	 * 
	 */
	public boolean touches(GeometricObject that);
	
	/**
	 * <p>Aktionsmethode, die auf zwei sich beruehrende Objekte reagieren kann</p>
	 * <p>(bspw: die Bewegungsrichtung der jeweiligen Objekte aendert)</p>
	 * 
	 * @param that das Objekt welches sich mit dem <code>this</code>-Objekt beruehrt
	 * 
	 * @throws GameOverException wenn das Spiel verloren wurde
	 * 
	 * @throws DestroyThatException wenn ein Objekt vom Spielfeld geloescht werden soll
	 * <p>(Bsp: <code>Ball</code> faellt in ein <code>BlackHole</code> 
	 * und muss nun von Spielfeld geloescht werden)</p>
	 * 
	 */
	public void handleCollision(GeometricObject that) throws GameOverException, DestroyThatException;
	
}
