package net.patrickvogt.pinkball.gui;

/*
 * GameOverDialog.java
 */

import javax.swing.*;

/**
 * zeigt dem Spieler an, dass er das Spiel verloren hat
 * 
 * @author Patrick Vogt
 *
 */
//GameOverDialog ist eine Unterklasse von JDialog
public class GameOverDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * beschreibt die Weite des <code>GameOverDialog</code>s
	 */
	private final int dialogWidth=300;
	
	/**
	 * beschreibt die Hoehe des <code>GameOverDialog</code>s
	 */
	private final int dialogHeight=80; 

	/**
	 * erzeugt eine neue Instanz von <code>GameOverDialog</code> und poisitioniert diese mittig
	 * im parent-Component
	 * 
	 * @param _width die Weite des parent-Components
	 * 
	 * @param _height die Hoehe des parent-Components
	 * 
	 */
	public GameOverDialog(int _width, int _height) {
		super();
		this.setTitle("Game Over!");
		this.setLayout(null);
		
	    this.setBounds(_width/2-this.dialogWidth/2, _height/2-this.dialogHeight/2, 
	    		this.dialogWidth, this.dialogHeight);
		JLabel gameOverText=new JLabel("A ball entered a hole of the wrong colour");
		gameOverText.setBounds(35, -15, this.dialogWidth, this.dialogHeight);
		this.add(gameOverText);
		//GameOverDialog soll nicht in der Groesse veranderbar sein
		this.setResizable(false);
		//GameOverDIalog soll immersichtbar sein
		this.setAlwaysOnTop(true);
	}
}
