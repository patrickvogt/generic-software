package net.patrickvogt.pinkball.geom;

import java.awt.Color;

import net.patrickvogt.pinkball.painter.IPainter;
import net.patrickvogt.pinkball.vector.Vector;

/*
 * SolidBlock.java
 */


/**
 * implementiert einen quadratischen farbigen Block, an dem Kugeln abprallen und 
 * dessen Farbe uebernehmen koennen
 * 
 * @author Patrick Vogt
 *
 */
//SolidBlock ist eine Unterklasse von GeometricObject
public class SolidBlock extends GeometricObject {
	
	/**
	 * erzeugt eine neue Instanz von <code>SolidBlock</code>
	 * 
	 * @param _myPosition die Koordinate (linke obere Ecke) des zu erzeugenden Objekts
	 * 
	 * @param _myDimension die Dimension des zu erzeugenden Objekts
	 * 
	 * @param _myColor die Farbe des zu erzeugenden Objekts
	 * 
	 */
	public SolidBlock(Vector _myPosition, Vector _myDimension, Color _myColor) {
		//super-Konstruktor (von GeometricObject) aufrufen
		super(_myPosition, _myDimension, _myColor);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>SolidBlock</code>
	 * 
	 * @param _x die x-Position des zu erzeugenden Objekts
	 * 
	 * @param _y die y-Position des zu erzeugenden Objekts
	 * 
	 * @param _width die Weite (gleichzeitig Hoehe) des zu erzeugenden Objekts
	 * 
	 */
	public SolidBlock(float _x, float _y, float _width, float _height, Color colour) {
		//oberen Konstruktor aufrufen
		this(new Vector(_x,_y), new Vector(_width,_height), colour);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>SolidBlock</code>
	 * 
	 * @param _x die x-Position des zu erzeugenden Objekts
	 * 
	 * @param _y die y-Position des zu erzeugenden Objekts
	 * 
	 * @param _width die Weite (gleichzeitig auch Hoehe) des zu erzeugenden Objekts
	 * 
	 * @param _myColor die Farbe des zu erzeugenden Objekts
	 * 
	 */
	public SolidBlock(float _x, float _y, float _width, Color _myColor) {
		//oberen Konstruktor aufrufen
		this(new Vector(_x,_y), new Vector(_width,_width), _myColor);
	}
	
	public void paint(IPainter p)
    {
        p.paint(this);
    }
	
	/**
	 * reagiert auf eine Kollision zwischen <code>SolidBlock</code> und <code>Ball</code>
	 * 
	 * @param that das Objekt, welches das this Objekt beruehrt
	 */
	@Override
	public GeometricObject handleCollision(GeometricObject that) {
		//ist that eine Kugel? (Nur Kugeln koennen sich im Spiel bewegen)
		if(that instanceof Ball) {
			//feststellen, ob die Kugel mit einer horizontalen oder mit einer vertikalen
			//Seite kollidiert ist
			double diffX = that.getCenterX()-this.getCenterX();
	       	double diffY = that.getCenterY()-this.getCenterY();

	       	if(Math.max(Math.abs(diffX), Math.abs(diffY))==Math.abs(diffX)) {
	       		//Kugel kollidiert mit einer vertikalen Seite
	       		if(diffX>0 && that.speed.getX()<0) {
	       			//that.getSpeed().getDX()<0 soll dafuer sorgen, dass sich die Kugel
	       			//komplett aus dem this-Objekt herausbewegt
	       			
	       			//Kugel kollidiert mit rechter Seite
	       			
	       			//Geschwindigkeit in x-Richtung umdrehen
	       		    that.speed = new Vector(-1*that.speed.getX(), that.speed.getY());
	       		}
	       		else if(diffX<0 && that.speed.getX()>0) {
	       			//that.getSpeed().getDX()>0 soll dafuer sorgen, dass sich die Kugel
	       			//komplett aus dem this-Objekt herausbewegt
	       			
	       			//Kugel kollidiert mit linken Seite
	       			
	       			//Geschwindigkeit in x-Richtung umdrehen
	       		 that.speed = new Vector(-that.speed.getX(), that.speed.getY());
	       		}
	       	}
	       	else {
	       		//Kugel kollidiert mit einer horizontalen Seite
	       		if(diffY>0 && that.speed.getY()<0) {
	       			//that.getSpeed().getDY()<0 soll dafuer sorgen, dass sich die Kugel
	       			//komplett aus dem this-Objekt herausbewegt
	       			
	       			//Kugel kollidiert mit unteren Seite
	       			
	       			//Geschwindigkeit in y-Richtung umdrehen
	       		    that.speed = new Vector(that.speed.getX(), -that.speed.getY());
	       		}
	       		else if(diffY<0 && that.speed.getY()>0) {
	       			//that.getSpeed().getDY()>0 soll dafuer sorgen, dass sich die Kugel
	       			//komplett aus dem this-Objekt herausbewegt
	       			
	       			//Kugel kollidiert mit oberer Seite
	       			
	       			//Geschwindigkeit in y-Richtung umdrehen
	       		 that.speed = new Vector(that.speed.getX(), -that.speed.getY());
	       		}
	       	}
	       	
	       	//Farbe der Kugel aendern
	       	//Grau gilt im Spiel als neutrale Farbe, deshalb aendert ein graues Stein nicht die
	       	//Farbe von den Kugeln
	       	if(this.getColor()!=Color.GRAY && this.getColor()!=that.getColor()) {
	       		that.setColor(this.getColor());
	       	}
		}
		return null;
	}
}
