package net.patrickvogt.pinkball.geom;

import java.awt.Color;

import net.patrickvogt.pinkball.painter.IPainter;
import net.patrickvogt.pinkball.vector.Coordinate;
import net.patrickvogt.pinkball.vector.Dimension2D;

/*
 * BlowUpBlock.java
 */


/**
 * implementiert einen Spielstein der alle Kugeln die darueberrollen aufblaest/vergroessert
 * 
 * @author Patrick Vogt
 *
 */
//BlowUpBlock ist eine Unterklasse von GeometricObject
public class BlowUpBlock extends GeometricObject {
	
	/**
	 * erzeugt eine neue Instanz von <code>BlowUpBlock</code>
	 * 
	 * @param _myPosition die Koordinate (der linken oberen Ecke) des zu erzeugenden Objekts
	 * 
	 * @param _myDimension die Dimension des zu erzeugenden Objekts
	 * 
	 * @param _myColor die Farbe des zu erzeugenden Objekts
	 * 
	 */
	public BlowUpBlock(Coordinate _myPosition, Dimension2D _myDimension, Color _myColor) {
		//super-Konstruktor (von GeometricObject) aufrufen
		super(_myPosition, _myDimension, _myColor);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>BlowUpBlock</code>
	 * 
	 * @param _x die x-Position des zu erzeugenden Objekts
	 * 
	 * @param _y die y-Position des zu erzeugenden Objekts
	 * 
	 * @param _width die Weite (gleichzeitig Hoehe) des zu erzeugenden Objekts
	 * 
	 */
	public BlowUpBlock(float _x, float _y, float _width) {
		//oberen Konstruktor aufrufen
		this(new Coordinate(_x,_y), new Dimension2D(_width,_width), Color.GRAY);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>BlowUpBlock</code>
	 * 
	 * @param _myPosition die Koordinate des zu erzeugenden Objekts
	 * 
	 * @param _width die Weite (gleichzeitig Hoehe) des zu erzeugenden Objekts
	 * 
	 * @param _myColor die Farbe des zu erzeugenden Objekts
	 * 
	 */
	public BlowUpBlock(Coordinate _myPosition, float _width, Color _myColor) {
		//oberen Konstruktor aufrufen
		this(_myPosition, new Dimension2D(_width,_width), _myColor);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>BlowUpBlock</code>
	 * 
	 * @param _x die x-Position des zu erzeugenden Objekts
	 * 
	 * @param _y die y-Position des zu erzeugenden Objekts
	 * 
	 * @param _width die Weite (gleichzeitig Hoehe) des zu erzeugenden Objekts
	 * 
	 * @param _myColor die Farbe des zu erzeugenden Objekts
	 * 
	 */
	public BlowUpBlock(float _x, float _y, float _width, Color _myColor) {
		//oberen Konstruktor aufrufen
		this(new Coordinate(_x,_y), new Dimension2D(_width,_width), _myColor);
	}
	
	public void paint(IPainter p)
    {
        p.paint(this);
    }
	
	/**
	 * reagiert auf eine Kollision zwischen <code>BlowUpBlock</code> und Kugel
	 * 
	 * @param that das Objekt, welches das this-Objekt beruehrt
	 * 
	 */
	@Override
	public void handleCollision(GeometricObject that) {
		//ist that eine Kugel? (Nur Kugeln koennen sich im Spiel bewegen)
		if(that instanceof Ball) {
			//entspricht die Farbe des BlowUpBlock der Farbe der Kugel?
			if(this.getColor()==Color.GRAY || this.getColor()==that.getColor()) {
				//ist die Kugel kleiner als ein bestimmer Wert?
				//(das anderthalbfache des BlowUpBlocks)
				if(((Ball)that).getDiameter()<1.5*this.getDimension().getWidth()) {
					//WENN ja DANN vergoessere den Durchmesser der Kugel
					((Ball)that).setDiameter(((Ball)that).getDiameter()*1.01f);
				}
			}
		}
	}
}
