package net.patrickvogt.pinkball.gui;

import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.JPanel;

import net.patrickvogt.pinkball.geom.GeometricObject;
import net.patrickvogt.pinkball.geom.SolidBlock;

/*
 * RightVerticalBorder.java
 */


/**
 * implementiert eine Unterklasse von JPanel welche den rechten vertikalen Rand des Hauptfensters beschreibt
 * 
 * @author Patrick Vogt
 *
 */
//RigtVerticalBorder ist eine Unterklasse von JPanel
public class RightVerticalBorder extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * beschreibt die Weite des rechten Rand des Hauptfensters
	 */
	private final int WIDTH;
	
	/**
	 * beschreibt die Hoehe des rechten Rand des Hauptfensters
	 */
	private final int HEIGHT;
	
	/**
	 * speichert den Inhalt des unteren Rand des Hauptfensters, der zum Zeichnen benoetigt wird
	 */
	private java.util.List<GeometricObject> myObjects;
	
	/**
	 * erzeugt eine neue Instanz von <code>RightVerticalBorder</code>
	 * 
	 * @param _height die Hoehe des rechten vertikalen Rand im Hauptfenster
	 * 
	 * @param stoneWidth gleichzeitig Breite des unteren Rand, sowie die Hoehe/Breite 
	 * des einzelnen Steine im Rand
	 * 
	 */
	public RightVerticalBorder(int _height, int stoneWidth) {
		//this-Felder setzen
		this.WIDTH = stoneWidth-1;
		this.HEIGHT = _height;
		this.myObjects= new LinkedList<GeometricObject>();
		for(int i=0; i<this.HEIGHT/stoneWidth; i++) {
			this.myObjects.add(new SolidBlock(0, i*stoneWidth, stoneWidth));
		}
	}
	
	/**
	 * gibt die bevorzugte Dimension des rechten vertikalen Rand des Hauptfensters zurueck
	 */
	@Override
	public Dimension getPreferredSize() {
		return(new Dimension(this.WIDTH, this.HEIGHT));
	}
	
//	/**
//	 * zeichnet alle Komponenten in der myObjects-Liste auf dem uebergeben Graphik-Kontext
//	 */
//	@Override
//    public void paintComponent(Graphics g) {  
//		g.clearRect(0, 0, this.WIDTH, this.HEIGHT);
//        for(Paintable that:this.myObjects) {
//            that.paintMeTo(g);
//        }
//    }
}
