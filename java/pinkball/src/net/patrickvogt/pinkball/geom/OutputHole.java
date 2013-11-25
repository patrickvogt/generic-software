package net.patrickvogt.pinkball.geom;

import java.awt.Color;

import net.patrickvogt.pinkball.painter.IPainter;
import net.patrickvogt.pinkball.vector.Coordinate;
import net.patrickvogt.pinkball.vector.Dimension2D;

/*
 * OutputHole.java
 */



/**
 * implementiert ein Loch, aus dem alle Kugeln, die zum LevelContent gehoeren 
 * bei Levelbeginn nacheinander freigelassen werden sollen
 * 
 * @author Patrick Vogt
 *
 */
//OutputHole ist eine Unterklasse von GeometricObject
public class OutputHole extends GeometricObject {

	/**
	 * erzeugt eine neue Instanz von <code>OutputHole</code>
	 * 
	 * @param _myPosition die Koordinate (linke obere Ecke) des zu erzeugenden Objekts
	 * 
	 * @param _myDimension die Dimension des zu erzeugenden Objekts
	 * 
	 */
	public OutputHole(Coordinate _myPosition, Dimension2D _myDimension) {
		//super-Konstruktor (von GeometricObject) aufrufen
		super(_myPosition, _myDimension, Color.BLACK);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>OutputHole</code>
	 * 
	 * @param _x x-Position des zu erzeugenden Objekts
	 * 
	 * @param _y y-Position des zu erzeugenden Objekts
	 * 
	 * @param _width die Weite (gleichzeitig Hoehe) des zu erzeugenden Objekts
	 * 
	 */
	public OutputHole(float _x, float _y, float _width) {
		//oberen Konstruktor aufrufen
		this(new Coordinate(_x,_y), new Dimension2D(_width,_width));
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>OutputHole</code>
	 * 
	 * @param _myPosition Koordinate (linkere obere Ecke) des zu erzeugenden Objekts
	 * 
	 * @param _width Weite (gleichzeitig Hoehe) des zu erzeugenden Objekts
	 * 
	 */
	public OutputHole(Coordinate _myPosition, float _width) {
		//oberen Konstruktor aufrufen
		this(_myPosition, new Dimension2D(_width,_width));
	}
	
	public void paint(IPainter p)
    {
        p.paint(this);
    }
	
	/**
	 * prueft, ob einer der SpielInhalte das OutputHole verdeckt/blockiert
	 * 
	 * @param myObjects die Inhalte des aktuellen Spielstands
	 * 
	 * @return ob einer der SpielInhalte das OutputHole blockiert
	 * 
	 */
	public boolean isBlocked(java.util.List<GeometricObject> myObjects) {
		boolean _isBlocked=false;
		for(GeometricObject that:myObjects) {
			//nur Kugeln sind beweglich -> nur Kugeln koennen das OutputHole blockieren
			if(that instanceof Ball) {
				//beruehrt eines der Objekte das OutputHole
				if(false /*&& this.touches(that)*/) {
					//WENN ja DANN ist OutPutHole blockiert
					_isBlocked=_isBlocked||true;
				}
			}
		}
		return(_isBlocked);
	}
}
