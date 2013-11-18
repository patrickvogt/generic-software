package net.patrickvogt.pinkball.main;

/*
 * Main.java
 */

import net.patrickvogt.pinkball.gui.Frame;

/**
 * startet hauptsaechlich einen neuen <code>Frame (package: net.patrickvogt.pinkball.gui)</code> und setzt diesen direkt auf <code>visible</code>
 * 
 * @author Patrick Vogt
 *
 */
public class Main {
	
	/**
	 * erzeugt einen neuen <code>Frame (package: net.patrickvogt.pinkball.gui)</code> und setzt diesen direkt auf <code>visible</code>
	 * 
	 * @param args vom Programmstart uebergebene Parameter
	 * 
	 */
	public static void main(String[] args) {
		new Frame().setVisible(true);
	}
}
