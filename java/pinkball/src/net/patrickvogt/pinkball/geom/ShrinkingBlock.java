package net.patrickvogt.pinkball.geom;

import java.awt.Color;

import net.patrickvogt.pinkball.painter.IPainter;
import net.patrickvogt.pinkball.vector.Coordinate;
import net.patrickvogt.pinkball.vector.Dimension2D;

/*
 * ShrinkingBlock.java
 */



/**
 * implementiert einen SpielStein, der die Kugeln bis zu einer bestimmten Groesse schrumpfen laesst
 * 
 * @author Patrick Vogt
 *
 */
//ShrinkingBlock ist eine Unterklasse von GeometricObject
public class ShrinkingBlock extends GeometricObject {

	/**
	 * erzeugt eine neue Instanz von <code>ShrinkingBlock</code>
	 * 
	 * @param _myPosition die Koordinate (der linken oberen Ecke) des zu erzeugenden Objekts
	 * 
	 * @param _myDimension die Dimension (Weite/Hoehe) des zu erzeugenden Objekts
	 * 
	 * @param _myColor die Farbe des zu erzeugenden Objekts
	 * 
	 */
	public ShrinkingBlock(Coordinate _myPosition, Dimension2D _myDimension, Color _myColor) {
		super(_myPosition, _myDimension, _myColor);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>ShrinkingBlock</code>
	 * 
	 * @param _x die x-Position des zu erzeugenden Objekts
	 * 
	 * @param _y die y-Position des zu erzeugenden Objekts
	 * 
	 * @param _width die Weite (gleichzeitig Hoehe) des zu erzeugenden Objekts
	 * 
	 */
	public ShrinkingBlock(float _x, float _y, float _width) {
		this(new Coordinate(_x,_y), new Dimension2D(_width,_width), Color.GRAY);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>ShrinkingBlock</code>
	 * 
	 * @param _myPosition die Koordinate des zu erzeugenden Objekts
	 * 
	 * @param _width die Weite (gleichzeitig Hoehe) des zu erzeugenden Objekts
	 * 
	 * @param _myColor die Farbe des zu erzeugenden Objekts
	 * 
	 */
	public ShrinkingBlock(Coordinate _myPosition, float _width, Color _myColor) {
		this(_myPosition, new Dimension2D(_width,_width), _myColor);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>ShrinkingBlock</code>
	 * 
	 * @param _x x-Position des zu erzeugenden Objekts
	 * 
	 * @param _y y-Position des zu erzeugenden Objekts
	 *  
	 * @param _width die Weite (gleichzeitig Hoehe) des zu erzeugenden Objekts
	 * 
	 * @param _myColor die Farbe des zu erzeugenden Objekts
	 * 
	 */
	public ShrinkingBlock(float _x, float _y, float _width, Color _myColor) {
		//oberen Konstruktor aufrufen
		this(new Coordinate(_x,_y), new Dimension2D(_width,_width), _myColor);
	}
	
	public void paint(IPainter p)
    {
        p.paint(this);
    }
	
	/**
	 * reagiert auf eine Kollision zwischen <code>ShrinkingBlock</code> und <code>Ball</code>
	 * 
	 * @param that das Objekt, welches das this-Objekt beruehrt
	 * 
	 */
	@Override
	public void handleCollision(GeometricObject that) {
		//is that eine Kugel? (nur Kugeln koennen sich im Spiel bewegen)
		if(that instanceof Ball) {
			//haben Kugel und ShrinkingBlock die gleiche Farbe?
			//(Grau gilt im Spiel als neutrale Farbe und kann alle Kugeln schrumpfen)
			if(this.getColor()==Color.GRAY || this.getColor()==that.getColor()) {
				//ist der Durchmesser der Kugel groesser als die Haelfte des ShrinkingBlocks?
				if(((Ball)that).getDiameter()>0.5*this.getDimension().getWidth()) {
					//WENN ja DANN verkleine den Durchmesser ein bisschen
					((Ball)that).setDiameter(((Ball)that).getDiameter()*0.99f);
				}
			}
		}
	}
}
