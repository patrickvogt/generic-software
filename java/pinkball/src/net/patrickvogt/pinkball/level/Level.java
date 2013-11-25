package net.patrickvogt.pinkball.level;

/*
 * Level.java
 */



import java.util.LinkedList;
import java.util.List;

import net.patrickvogt.pinkball.geom.GeometricObject;
import net.patrickvogt.pinkball.vector.Coordinate;
import net.patrickvogt.pinkball.vector.Dimension2D;


/**
 * implementiert eine Klasse die den LevelContent in einer generischen <code>List</code> abspeichern kann
 * und noch eine Konstante fuer Weite und Hoehe der Gitterfelder enthaelt
 * 
 * @author Patrick Vogt
 *
 */
public class Level {

	/**
	 * Konstante welche die Weite und Hoehe der Gitterfelder beschreibt
	 */
	private final float myGridWidth=20.0f;
	
	/**
	 * speichert alle Inhalte eines Levels
	 */
	protected List<GeometricObject> myLevelContent;
	
	/**
	 * erzeugt eine Instanz von <code>Level</code> mit einer leeren Liste, die dann von den 
	 * Unterklassen gefuellt werden kann
	 */
	public Level() {
		//leere generische Liste erzeugen
		this.myLevelContent=new LinkedList<GeometricObject>();
	}
	
	/**
	 * Zugriffsmethode um die generische Liste zu bekommen, in dem die LevelInhalte gespeichert sind
	 * 
	 * @return generische Liste mit den LevelInhalten (den jeweiligen <code>GeometricObject</code>s)
	 * 
	 */
	public List<GeometricObject> getLevelContent() {
		return(this.myLevelContent);
	}
	
	/**
	 * gibt einen Koordinatenvektor zurueck, der die Koordinaten des <code>horizontal</code>-ten und
	 * des <code>vertical</code>-ten Gitterfeldes beschreibt
	 * 
	 * @param horizontal das <code>horizontal</code>-ste Gitterfeld
	 * 
	 * @param vertical das <code>vertikal</code>-ste Gitterfeld
	 * 
	 * @return Koordinaten-Vektor des <code>horizontal</code>-ten und
	 * des <code>vertical</code>-ten Gitterfeldes im Level
	 * 
	 */
	protected Coordinate getGridCoordinate(int horizontal, int vertical) {
		return(new Coordinate(horizontal*this.myGridWidth, vertical*this.myGridWidth));
	}
	
	/**
	 * gibt eine Default-Dimension zurueck, bei der die Weite 1*myGridWidth und die Hoehe ebenfalls
	 * 1*gridWidth ist
	 * 
	 * @see net.patrickvogt.pinkball.level.Level#myGridWidth
	 * 
	 * @return Dimension, bei der die Weite und Hoehe jeweils 1*myGridWith ist
	 * 
	 */
	protected Dimension2D getDefaultGridDimension() {
		return(new Dimension2D(this.myGridWidth, this.myGridWidth));
	}
	
	/**
	 * vereinfachte <code>add</code>-Methode, die der LevelContent-Liste ein ubergebenes Objekt 
	 * (<code>GeometricObject</code>) hinzufuegt
	 * 
	 * @param that neues <code>GeometricObject</code>, das der Liste fuer den LevelContent hinzugefuegt
	 * werden soll
	 * 
	 */
	protected void add(GeometricObject that) {
		this.myLevelContent.add(that);
	}
	
	/**
	 * Zugriffsmethode, um die Kontante fuer die Weite/Hoehe der Gitterfelder zu bekommen
	 * 
	 * @return Weite/Hoehe der Gitterfelder im Level
	 * 
	 */
	protected float getGridWidth() {
		return(this.myGridWidth);
	}
}
