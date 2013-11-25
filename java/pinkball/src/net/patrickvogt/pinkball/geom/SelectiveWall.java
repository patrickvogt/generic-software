package net.patrickvogt.pinkball.geom;

import java.awt.Color;

import net.patrickvogt.pinkball.painter.IPainter;
import net.patrickvogt.pinkball.vector.Coordinate;
import net.patrickvogt.pinkball.vector.Dimension2D;

/*
 * SelectiveWall.java
 */


/**
 * implementiert eine selektive Wand, die eine Farbe besitzt und nur von entsprechenden Kugeln
 * (mit der gleichen Farbe der Wand) passiert werden koennen. Andersfarbige Kugeln prallen von
 * dieser Wand ab
 * 
 * @author Patrick Vogt
 *
 */
//SelectiveWall ist eine Unterklasse von GeometricObject
public class SelectiveWall extends GeometricObject {

	/**
	 * erzeugt eine neue Instanz von <code>SelectiveWall</code>
	 * 
	 * @param _myPosition die Position der linken oberen Ecke des zu erzeugenden Objekts
	 * 
	 * @param _myDimension die Dimension des zu erzeugenden Objekts
	 * 
	 * @param _myColor die Farbe des zu erzeugenden Objekts
	 * 
	 */
	public SelectiveWall(Coordinate _myPosition, Dimension2D _myDimension, Color _myColor) {
		//super-Konstruktor (von GeometricObject) aufrufen
		super(_myPosition, _myDimension, _myColor);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>SelectiveWall</code>
	 * 
	 * @param _x
	 * 
	 * @param _y
	 * 
	 * @param _width
	 * 
	 * @param _height
	 * 
	 */
	public SelectiveWall(float _x, float _y, float _width, float _height) {
		//oberen Konstruktor aufrufen
		this(new Coordinate(_x,_y), new Dimension2D(_width,_height), Color.GRAY);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>SelectiveWall</code>
	 * 
	 * @param _myPosition die Koordinate der linken oberen Ecke des zu erzeugenden Objekts 
	 * 
	 * @param _width die Weite des zu erzeugenden Objekts
	 * 
	 * @param _height die Hoehe des zu erzeugenden Objekts
	 * 
	 * @param _myColor die Farbe des zu erzeugenden Objekts
	 * 
	 */
	public SelectiveWall(Coordinate _myPosition, float _width, float _height, Color _myColor) {
		//oberen Kosntruktor
		this(_myPosition, new Dimension2D(_width,_height), _myColor);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>SelectiveWall</code>
	 * 
	 * @param _x die x-Koordinate des zu erzeugenden Objekts
	 * 
	 * @param _y die y-Koordinate des zu erzeugenden Objekts
	 * 
	 * @param _width die Weite des zu erzeugenden Objekts
	 * 
	 * @param _height die Hoehe des zu erzeugenden Objekts
	 * 
	 * @param _myColor die Farbe, die das zu erzeugende Objekt besitzen soll
	 * 
	 */
	public SelectiveWall(float _x, float _y, float _width, float _height, Color _myColor) {
		//oberen Kontruktor aufrufen
		this(new Coordinate(_x,_y), new Dimension2D(_width,_height), _myColor);
	}
	
	public void paint(IPainter p)
    {
        p.paint(this);
    }
	
	/**
	 * reagiert auf eine Kollision zwischen <code>SelectiveWall</code> und <code>Ball</code>
	 * 
	 * @param that das Objekt, welches das this-Objekt beruehrt
	 * 
	 */
	@Override 
	public void handleCollision(GeometricObject that) {
		//ist that eine Kugel? (nur Kugeln koennen sich im Spiel bewegen
		//AND ist die Farbe der Kugel nicht grau (neutrale Farbe im Spiel)
		//AND ist die Farbe des this-Objekt ungleich der Farbe des that-Objekts
		if(that instanceof Ball && this.getColor()!=Color.GRAY 
				&& this.getColor()!= that.getColor()) {
			//WENN ja DANN prall ab
			
			//feststellen, ob die Kugel mit einer horizontalen oder mit einer vertikalen
			//Seite kollidiert ist
			double diffX=that.getCenter().getX()-this.getCenter().getX();
			double diffY=that.getCenter().getY()-this.getCenter().getY();
			double absDiffX = Math.abs(diffX)-this.getDimension().getWidth()/2;
	       	double absDiffY = Math.abs(diffY)-this.getDimension().getHeight()/2;
	       	if(Math.max(absDiffX, absDiffY)==absDiffX) {
	       		//Kugel kollidiert mit einer vertikalen Seite der Wand
	       		if(diffX>0 && that.getSpeed().getDX()<0) {
	       			//that.getSpeed().getDX()<0 soll dafuer sorgen, dass sich die Kugel
	       			//komplett aus dem this-Objekt herausbewegt
	       			
	       			//Kugel kollidiert mit rechter Seite
	       			
	       			//Geschwindigkeit in x-Richtung umdrehen
	       			that.getSpeed().setDX(-1*that.getSpeed().getDX());
	       		}
	       		else if(diffX<0 && that.getSpeed().getDX()>0) {
	       			//that.getSpeed().getDX()>0 soll dafuer sorgen, dass sich die Kugel
	       			//komplett aus dem this-Objekt herausbewegt
	       			
	       			//Kugel kollidiert mit linker Seite
	       			
	       			//Geschwindigkeit in x-Richtung umdrehen
	       			that.getSpeed().setDX(-1*that.getSpeed().getDX());
	       		}
	       	}
	       	else {
	       		//Kugel kollidiert mit einer horizontalen Seite der Wand
	       		if(diffY>0 && that.getSpeed().getDY()<0) {
	       			//that.getSpeed().getDY()<0 soll dafuer sorgen, dass sich die Kugel
	       			//komplett aus dem this-Objekt herausbewegt
	       			
	       			//Kugel kollidiert mit unterer Seite
	       			
	       			//Geschwindigkeit in y-Richtung umdrehen
	       			that.getSpeed().setDY(-1*that.getSpeed().getDY());
	       		}
	       		else if(diffY<0 && that.getSpeed().getDY()>0) {
	       			//that.getSpeed().getDY()>0 soll dafuer sorgen, dass sich die Kugel
	       			//komplett aus dem this-Objekt herausbewegt
	       			
	       			//Kugel kollidiert mit oberer Seite
	       			
	       			//Geschwindigkeit in y-Richtung umdrehen
	       			that.getSpeed().setDY(-1*that.getSpeed().getDY());
	       		}
	       	}
		}
	}
}
