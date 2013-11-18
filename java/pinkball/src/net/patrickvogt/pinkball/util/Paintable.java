package net.patrickvogt.pinkball.util;

/*
 * Paintable.java
 */

import java.awt.Graphics;

/**
 * beschreibt, welche Methoden ein Objekt implementieren muss um 'zeichenbar' (engl. <code>Paintable</code>)
 * zu sein
 * 
 * @author Patrick Vogt
 *
 */
public interface Paintable {
	
	/**
	 * Zeichen-Methode, die das <code>this</code>-Objekt auf dem uebergebenen Graphik-Kontext zeichnen kann
	 * 
	 * @param g der Graphik-Kontext, auf dem das Objekt gezeichnet werden soll
	 */
	public void paintMeTo(Graphics g);
	
}
