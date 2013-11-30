//package net.patrickvogt.pinkball.gui;
//
//import java.awt.Dimension;
//import java.util.LinkedList;
//
//import javax.swing.JPanel;
//
//import net.patrickvogt.pinkball.geom.GeometricObject;
//import net.patrickvogt.pinkball.geom.SolidBlock;
//
///*
// * LeftVerticalBorder.java
// */
//
//
///**
// * implementiert eine Unterklasse von JPanel welche den linken vertikalen Rand des Hauptfensters beschreibt
// * 
// * @author Patrick Vogt
// *
// */
////LeftVerticalBorder ist eine Unterklasse von JPanel
//public class LeftVerticalBorder extends JPanel {
//
//	private static final long serialVersionUID = 1L;
//	
//	/**
//	 * beschreibt die Weite des linken vertikalen Rand des Hauptfensters
//	 */
//	private final int WIDTH;
//	
//	/**
//	 * beschreibt die Hoehe des linken vertikalen Rand des Hauptfensters
//	 */
//	private final int HEIGHT;
//	
//	/**
//	 * speichert den Inhalt des linken Rand des Hauptfensters, der zum Zeichnen benoetigt wird
//	 */
//	private java.util.List<GeometricObject> myObjects;
//	
//	/**
//	 * erzeugt eine neue Instanz von <code>LeftVerticalBorder</code>
//	 * 
//	 * @param _height die Hoehe des linken vertikalen Rand im Hauptfenster
//	 * 
//	 * @param stoneWidth gleichzeitig Breite des linken Rand, sowie die Hoehe/Breite 
//	 * des einzelnen Steine im Rand
//	 * 
//	 */
//	public LeftVerticalBorder(int _height, int stoneWidth) {
//		this.WIDTH=stoneWidth+1;
//		this.HEIGHT=_height;
//		this.myObjects=new LinkedList<GeometricObject>();
//		for(int i=0; i<this.HEIGHT/stoneWidth; i++) {
//			myObjects.add(new SolidBlock(0, i*stoneWidth, stoneWidth));
//		}
//	}
//	
//	/**
//	 * gibt die bevorzugte Dimension des linken vertikalen Rand des Hauptfensters zurueck
//	 */
//	@Override
//	public Dimension getPreferredSize() {
//		return(new Dimension(this.WIDTH, this.HEIGHT));
//	}
//	
////	/**
////	 * zeichnet alle Komponenten in der myObjects-Liste auf dem uebergeben Graphik-Kontext
////	 */
////	@Override
////    public void paintComponent(Graphics g) {  
////		g.clearRect(0, 0, this.WIDTH, this.HEIGHT);
////        for(Paintable that:this.myObjects) {
////            that.paintMeTo(g);
////        }
////    }
//}
