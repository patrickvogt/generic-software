package net.patrickvogt.pinkball.vector;

/*
 * Dimension2D.java
 */

/**
 * implementiert einen speziellen 2-dimensionalen Dimensions-Vektor (als Unterklasse von der abstrakten Klasse 
 * <code>Vector</code>, welcher als 1.-Komponente die 'Weite' (engl. <code>Width</code>) 
 * und als 2.-Komponente die 'Hoehe' (engl. <code>Height</code>) enthaelt 
 * 
 * @author Patrick Vogt
 *
 */
//Dimension2D ist eine Unterklasse von Vector
public class Dimension2D extends Vector {
	
	/**
	 * erzeugt eine neue Instanz von <code>Dimension2D</code> mit den beiden Anfangswerten
	 * <code>_width</code> und <code>_height</code>
	 * 
	 * @param _width die Weite des zu erzeugenden Dimensions-Vektors
	 * 
	 * @param _height die Höhe des zu erzeugenden Dimensions-Vektors
	 * 
	 */
	public Dimension2D(double _width, double _height) {
		//this-Felder setzen
		this.x=_width;
		this.y=_height;
	}
	
	/**
	 * Zugriffsmethode um die aktuelle Weite des <code>this</code>-Dimensions-Vektors zu bekommen
	 * 
	 * @return die aktuelle Weite des <code>this</code>-Dimensions-Vektors
	 * 
	 */
	public double getWidth() {
		return(this.x);
	}
	
	/**
	 * Zugriffsmethode um die Weite des <code>this</code>-Dimensions-Vektors 
	 * auf einen zu uebergebenen Wert zu setzen
	 * 
	 * @param _width die neue Weite des <code>this</code>-Dimensions-Vektors
	 * 
	 */
	public void setWidth(double _width) {
		this.x=_width;
	}
	
	/**
	 * Zugriffsmethode um die aktuelle Hoehe des <code>this</code>-Objekts zu bekommen
	 * 
	 * @return die aktuelle Hoehe des <code>this</code>-Dimensions-Vektors
	 * 
	 */
	public double getHeight() {
		return(this.y);
	}
	
	/**
	 * Zugriffsmethode um die Hoehe des <code>this</code>-Dimensions-Vektors 
	 * auf einen uebergebenen Wert zu setzen
	 * 
	 * @param _height die neue Hoehe des <code>this</code>-Dimensions-Vektors
	 * 
	 */
	public void setHeight(double _height) {
		this.y=_height;
	}
}
