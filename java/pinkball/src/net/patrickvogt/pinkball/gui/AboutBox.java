package net.patrickvogt.pinkball.gui;

/*
 * AboutBox.java
 */

import javax.swing.*;

/**
 * implementiert eine AboutBox, in der bestimmte Informationen zum Programm angezeigt werden
 * 
 * @author Patrick Vogt
 *
 */
//AboutBox ist eine Unterklasse von JDialog
public class AboutBox extends JDialog {

	private static final long serialVersionUID = 1L;
	
	/**
	 * beschreibt die Weite der AboutBox
	 */
	private final int dialogWidth=200;
	
	/**
	 * beschreibt die Hoehe der AboutBox
	 */
	private final int dialogHeight=100; 

	/**
	 * erzeugt eine neue AboutBox, die durch die uebergebenen Parameter im parent-Frame mittig
	 * positioniert werden kann
	 * 
	 * @param _width die Weite des parent-Frame in dem die AboutBox angezeigt werden soll
	 * 
	 * @param _height die Hoehe des parent-Frame in dem die AboutBox angezeigt werden soll
	 * 
	 */
	public AboutBox(int _width, int _height) {
		super();
		this.setTitle("About");
		this.setLayout(null);
		
	    this.setBounds(_width/2-this.dialogWidth/2, _height/2-this.dialogHeight/2, 
	    		this.dialogWidth, this.dialogHeight);
		
		JLabel myLabel=new JLabel("<html>Author: Patrick VOGT<br>"+
				"Registration number: 256558<br>"+
		"Description: PInkBall</html>");
		this.add(myLabel);
		myLabel.setBounds(15,-15,this.dialogWidth,this.dialogHeight);
		//AboutBox soll nicht in der Groesse veraenderbar sein.
		this.setResizable(false);
		//AboutBox soll immer angezeigt werden, bis es geschlossen wird
		this.setAlwaysOnTop(true);
	}
}
