package net.patrickvogt.pinkball.vector;

/*
 * Speed.java
 */

/**
 * implementiert einen speziellen 2-dimensionalen 'Geschwindigkeits'-Vektor (als Unterklasse von der abstrakten 
 * Klasse <code>Vector</code>, welcher als 1.-Komponente die 'Geschwindigkeit in x-Richtung' bzw. die Veraenderung
 * des Ortes in x-Richtung (math. <code>dX</code>) und als 2.-Komponente die 'Geschwindigkeit in y-Richtung' 
 * bzw. die Veraenderung des Ortes in y-Richtung (math. <code>dY</code>) enthaelt 
 * 
 * @author Patrick Vogt
 *
 */
//Speed ist eine Unterklasse von Vector
public class Speed extends Vector {
	
	/**
	 * erzeugt eine neue Instanz von <code>Speed</code> mit den beiden Anfangswerten
	 * <code>_dX</code> und <code>_dY</code>
	 * 
	 * @param _dX die Geschwindigkeit in x-Richtung des zu erzeugenden <code>Speed</code>-Vektors
	 * 
	 * @param _dY die Geschwindigkeit in y-Richtung des zu erzeugenden <code>Speed</code>-Vektors
	 * 
	 */
	public Speed(double _dX, double _dY) {
		//this-Felder setzen
		this.x=_dX;
		this.y=_dY;
	}
	
	/**
	 * Zugriffsmethode um die aktuelle x-Geschwindigkeit des <code>this</code>-<code>Speed</code>-Vektors zu bekommen
	 * 
	 * @return die aktuelle x-Geschwindigkeit des <code>this</code>-<code>Speed</code>-Vektors
	 * 
	 */
	public double getDX() {
		return(this.x);
	}
	
	/**
	 * Zugriffsmethode um die x-Geschwindigkeit des <code>this</code>-<code>Speed</code>-Vektors 
	 * auf einen zu uebergebenen Wert zu setzen
	 * 
	 * @param _dX neue x-Geschwindigkeit des <code>this</code>-<code>Speed</code>-Vektors
	 * 
	 */
	public void setDX(double _dX) {
		this.x=_dX;
	}
	
	/**
	 * Zugriffsmethode um die aktuelle y-Geschwindigkeit des <code>this</code>-<code>Speed</code>-Vektors zu bekommen
	 * 
	 * @return die aktuelle y-Geschwindigkeit des <code>this</code>-<code>Speed</code>-Vektors
	 * 
	 */
	public double getDY() {
		return(this.y);
	}
	
	/**
	 * Zugriffsmethode um die y-Geschwindigkeit des <code>this</code>-<code>Speed</code>-Vektors 
	 * auf einen zu uebergebenen Wert zu setzen
	 * 
	 * @param _dY neue y-Geschwindigkeit des <code>this</code>-<code>Speed</code>-Vektors
	 * 
	 */
	public void setDY(double _dY) {
		this.y=_dY;
	}	
}
