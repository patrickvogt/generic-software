package net.patrickvogt.pinkball.geom;

/*
 * BrokenBlock.java
 */

import java.awt.*;

import net.patrickvogt.pinkball.vector.*;
import net.patrickvogt.pinkball.exceptions.*;

/**
 * implementiert eine poroesen Block, der durch eine Kollision mit einer gleichfarbigen Kugel
 * zerfaellt (bzw. vom Spielfeld geloescht wird)
 * 
 * @author Patrick Vogt
 *
 */
public class BrokenBlock extends GeometricObject {	
	
	/**
	 * erzeugt eine neue Instanz von <code>BrokenBlock</code>
	 * 
	 * @param _myPosition die Koordinate (der linken oberen Ecke) des zu erzeugenden Objekts
	 * 
	 * @param _myDimension die Dimension des zu erzeugenden Objekts
	 * 
	 * @param _myColor die Farbe des zu erzeugenden Objekts
	 * 
	 */
	public BrokenBlock(Coordinate _myPosition, Dimension2D _myDimension, Color _myColor) {
		//super-Konstruktor von GeometricObject aufrufen
		super(_myPosition, _myDimension, _myColor);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>BrokenBlock</code>
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
	public BrokenBlock(double _x, double _y, double _width, Color _myColor) {
		//oberen Konstruktor aufrufen
		this(new Coordinate(_x,_y), new Dimension2D(_width,_width), _myColor);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>BrokenBlock</code>
	 * 
	 * @param _x die x-Position des zu erzeugenden Objekts
	 * 
	 * @param _y die y-Position des zu erzeugenden Objekts
	 * 
	 * @param _width die Weite (gleichzeitig Hoehe) des zu erzeugenden Objekts
	 * 
	 */
	public BrokenBlock(double _x, double _y, double _width) {
		this(new Coordinate(_x,_y), new Dimension2D(_width,_width), Color.GRAY);
	}
	
	/**
	 * zeichnet das Objekt auf dem uebergebenen Graphik-Kontext
	 * 
	 * @param g der Graphik-Kontext auf dem das Objekt gezeichnet werden soll
	 * 
	 */
	@Override 
	public void paintMeTo(Graphics g) {
		//farbiges Quadrat zeichnen
		g.setColor(this.getColor());
		g.fillRect((int) this.getPosition().getX(), (int) this.getPosition().getY(), 
				(int) this.getDimension().getWidth(), (int) this.getDimension().getHeight());
		//schwarze Kontur zeichnen
		g.setColor(Color.BLACK);
		g.drawRect((int) this.getPosition().getX(), (int) this.getPosition().getY(), 
				(int) this.getDimension().getWidth(), (int) this.getDimension().getHeight());
		
		//passendes X ueber dem farbigen Quadrat zeichnen -> X unterscheidet BrokenBlock von SolidBlock
		if(this.getColor()!=Color.BLACK) {
			g.setColor(Color.BLACK);	
		}
		else {
			g.setColor(Color.WHITE);
		}
        g.drawLine((int) this.getPosition().getX(),
				(int) (this.getPosition().getY()+this.getDimension().getHeight()), 
				(int) (this.getPosition().getX()+this.getDimension().getWidth()),
				(int)  this.getPosition().getY());
		g.drawLine((int) this.getPosition().getX(),
				(int)  this.getPosition().getY(),
				(int) (this.getPosition().getX()+this.getDimension().getWidth()),
				(int) (this.getPosition().getY()+this.getDimension().getHeight()));
	}
	
	/**
	 * reagiert auf eine Kollision zwischen <code>BrokenBlock</code> und <code>BlackHole</code>
	 * 
	 * @param that das Objekt, welches das this-Objekt beruehrt
	 * 
	 * @throws DestroyException wenn das this-Objekt von einer gleichfarbigen Kugel getroffen wurde
	 * 
	 */
	@Override
	public void handleCollision(GeometricObject that) throws DestroyThatException {
		//ist that eine Kugel? (nur Kugeln koennen sich im Spiel bewegen)
		if(that instanceof Ball) {
			//feststellen, ob die Kugel mit einer horizontalen oder mit einer vertikalen
			//Seite kollidiert ist
			double diffX = that.getCenter().getX()-this.getCenter().getX();
	       	double diffY = that.getCenter().getY()-this.getCenter().getY();
	       	
	       	if(Math.max(Math.abs(diffX), Math.abs(diffY))==Math.abs(diffX)) {
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
	       			
	       			//Kugel kollidiert mit der unteren Seite
	       			
	       			//Geschwindigkeit in y-Richtung umdrehen
	       			that.getSpeed().setDY(-1*that.getSpeed().getDY());
	       		}
	       		else if(diffY<0 && that.getSpeed().getDY()>0) {
	       			//that.getSpeed().getDY()>0 soll dafuer sorgen, dass sich die Kugel
	       			//komplett aus dem this-Objekt herausbewegt
	       			
	       			//Kugel kollidiert mit der oberen Seite
	       			
	       			//Geschwindigkeit in y-Richtung umdrehen
	       			that.getSpeed().setDY(-1*that.getSpeed().getDY());
	       		}
	       	}
		
	       	//Haben Kugel und BrokenBlock die gleiche Farbe?
			if(this.getColor()==Color.GRAY || this.getColor()==that.getColor()) {
				//WENN ja DANN muss das this-Objekt (der BrokenBlock) vom Spielfeld geloescht werden
				
				//werfe eine DestroyThatException mit dem this-Objekt
				throw new DestroyThatException(this, false);
			}
		}
	}
}
