package net.patrickvogt.pinkball.vector;

/*
 * Coordinate.java
 */

/**
 * implementiert einen speziellen 2-dimensionalen Koordinaten-Vektor (als Unterklasse
 * von <code>Vector</code>), der einen Punkt (x,y) im 2-dimensionalen Raum beschreibt
 * 
 * @author Patrick Vogt
 *
 */
//Coordinate ist eine Unterklasse von Vector
public class Coordinate extends Vector {
	
	/**
	 * erzeugt eine Instanz von <code>Coordinate</code> mit den Anfangswerten <code>_x</code>
	 * und <code>_y</code>
	 * 
	 * @param _x x-Koordinate des zu ergeugenden Koordinaten-Vektors
	 * 
	 * @param _y y-Koordinate des zu erzeugenden Koordinaten-Vektors
	 * 
	 */
	public Coordinate(double _x, double _y) {
		//this-Felder setzen
		this.x=_x;
		this.y=_y;
	}
	
	/**
	 * Zugriffsmethode um die x-Komponente des <code>this</code>-Koordinaten-Vektors zu bekommen
	 * 
	 * @return x-Koordinate des <code>this</code>-Koordinaten-Vektors
	 * 
	 */
	public double getX() {
		return(this.x);
	}
	
	/**
	 * Zugriffsmethode um die x-Koordinate des <code>this</code>-Koordinaten-Vektors 
	 * auf einen neuen uebergebenen Wert zu setzen
	 * 
	 * @param _x die neue x-Koordinate des <code>this</code>-Koordinaten-Vektors 
	 * 
	 */	
	public void setX(double _x) {
		this.x=_x;
	}
	
	/**
	 * Zugriffsmethode um die y-Koordinate des <code>this</code>-Koordinaten-Vektors zu bekommen
	 * 
	 * @return y-Koordinate des <code>this</code>-Koordinaten-Vektors
	 * 
	 */
	public double getY() {
		return(this.y);
	}
	
	/**
	 * Zugriffsmethode um die y-Koordinate des <code>this</code>-Koordinaten-Vektors
	 * auf einen neuen uebergebenen Wert zu setzen
	 * 
	 * @param _y die neue y-Koordinate des <code>this</code>-Koordinaten-Vektors
	 * 
	 */	
	public void setY(double _y) {
		this.y=_y;
	}
	
	/**
	 * 'Schiebe'-Methode, die den <code>this</code>-Koordinaten-Vektor um den <code>that</code>-Vektor
	 * im Raum verschiebt
	 * 
	 * @param that der Vektor um den der <code>this</code>-Vektor im Raum verschoben werden soll
	 * 
	 */
	public void move(Coordinate that) {
        this.setX(this.getX()+that.getX());
        this.setY(this.getY()+that.getY());
    }
	
	/**
	 * testet zwei Koordinaten-Vektoren auf ihre Gleichheit mit Hilfe der
	 * <code>equals</code>-Methode aus der abstrakten Oberklasse <code>Vector</code>
	 * 
	 * @see java.lang.Object#equals(Object)
	 * 
	 * @see net.patrickvogt.pinkball.vector.Vector#equals(Object)
	 * 
	 * @return ob die beiden Koordinaten-Vektoren gleich sind
	 * 
	 */
	@Override
	public boolean equals(Object that) {
		//sind this und that identisch? => this und that sind auch gleich
		if(this==that) {
			return(true);
		}
		//ist that eine Instanz von Coordinate?
		else if(that instanceof Coordinate) {
			//WENN ja DANN rufe equals-Methode der Oberklasse auf
			return(super.equals(that));
		}
		else {
			//ANDERNFALLS that kann nicht mit dem this-Objekt gleich sein
			return(false);
		}
	}
}
