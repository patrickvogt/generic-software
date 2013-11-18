package net.patrickvogt.pinkball.gui;

/*
 * BottomHorizontalBorder.java
 */

import javax.swing.*;
import java.util.*;
import java.awt.*;

import net.patrickvogt.pinkball.geom.*;
import net.patrickvogt.pinkball.util.Paintable;

/**
 * implementiert eine Unterklasse von JPanel welche den unteren horizontalen Rand des Hauptfensters beschreibt
 * 
 * @author Patrick Vogt
 *
 */
//BottomHorizontalBorder ist eine Unterklasse von JPanel
public class BottomHorizontalBorder extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * beschreibt die Weite des unteren Rand des Hauptfensters
	 */
	private final int WIDTH;
	
	/**
	 * beschreibt die Hoehe des unteren Rand des Hauptfensters
	 */
	private final int HEIGHT;
	
	/**
	 * speichert den Inhalt des unteren Rand des Hauptfensters, der zum Zeichnen benoetigt wird
	 */
	private java.util.List<GeometricObject> myObjects;
	
	/**
	 * erzeugt eine neue Instanz von <code>BottomHorizontalBorder</code>
	 * 
	 * @param _width die Breite des unteren horizontalen Rand im Hauptfenster
	 * 
	 * @param stoneWidth gleichzeitig Hoehe des unteren Rand, sowie die Hoehe/Breite 
	 * des einzelnen Steine im Rand
	 * 
	 */
	public BottomHorizontalBorder(int _width, int stoneWidth) {
		//this-Felder setzen
		this.WIDTH=_width;
		this.HEIGHT=stoneWidth-1;
		this.myObjects=new LinkedList<GeometricObject>();
		for(int i=0; i<this.WIDTH/stoneWidth; i++) {
			this.myObjects.add(new SolidBlock(i*stoneWidth, 0, stoneWidth));
		}
	}
	
	/**
	 * gibt die bevorzugte Dimension des unteren horizontalen Rand des Hauptfensters zurueck
	 */
	@Override
	public Dimension getPreferredSize() {
		return(new Dimension(this.WIDTH, this.HEIGHT));
	}
	
	/**
	 * zeichnet alle Komponenten in der myObjects-Liste auf dem uebergeben Graphik-Kontext
	 */
	@Override
    public void paintComponent(Graphics g) {  
		//fuer jedes Element in der myObjects-Liste
        for(Paintable that:this.myObjects) {
        	//zeichne dich selbst auf dem uebergebenen Graphik-Kontext
            that.paintMeTo(g);
        }
    }
}
