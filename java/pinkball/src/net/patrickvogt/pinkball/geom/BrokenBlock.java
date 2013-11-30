package net.patrickvogt.pinkball.geom;

import java.awt.Color;



import net.patrickvogt.pinkball.painter.IPainter;
import net.patrickvogt.pinkball.vector.Vector;

/*
 * BrokenBlock.java
 */



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
	public BrokenBlock(float __pos_x, float __pos_y, float __width, float __height, Color __color) {
        super(new Vector(__pos_x,__pos_y), new Vector(__width,__height), __color);
    }
	
	
	public void paint(IPainter p)
    {
        p.paint(this);
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
	public GeometricObject handleCollision(GeometricObject that)  {
		//ist that eine Kugel? (nur Kugeln koennen sich im Spiel bewegen)
		if(that instanceof Ball) {
			//feststellen, ob die Kugel mit einer horizontalen oder mit einer vertikalen
			//Seite kollidiert ist
			double diffX = that.getCenterX()-this.getCenterX();
	       	double diffY = that.getCenterY()-this.getCenterY();
	       	
	       	if(Math.max(Math.abs(diffX), Math.abs(diffY))==Math.abs(diffX)) {
	       		//Kugel kollidiert mit einer vertikalen Seite der Wand
	       		if(diffX>0 && that.speed.getX()<0) {
	       			//that.getSpeed().getDX()<0 soll dafuer sorgen, dass sich die Kugel
	       			//komplett aus dem this-Objekt herausbewegt
	       			
	       			//Kugel kollidiert mit rechter Seite
	       			
	       			//Geschwindigkeit in x-Richtung umdrehen
	       		 that.speed = new Vector(-that.speed.getX(), that.speed.getY());
	       		}
	       		else if(diffX<0 && that.speed.getX()>0) {
	       			//that.getSpeed().getDX()>0 soll dafuer sorgen, dass sich die Kugel
	       			//komplett aus dem this-Objekt herausbewegt
	       			
	       			//Kugel kollidiert mit linker Seite
	       			
	       			//Geschwindigkeit in x-Richtung umdrehen
	       		 that.speed = new Vector(-that.speed.getX(), that.speed.getY());
	       		}
	       	}
	       	else {
	       		//Kugel kollidiert mit einer horizontalen Seite der Wand
	       		if(diffY>0 && that.speed.getY()<0) {
	       			//that.getSpeed().getDY()<0 soll dafuer sorgen, dass sich die Kugel
	       			//komplett aus dem this-Objekt herausbewegt
	       			
	       			//Kugel kollidiert mit der unteren Seite
	       			
	       			//Geschwindigkeit in y-Richtung umdrehen
	       		 that.speed = new Vector(that.speed.getX(), -that.speed.getY());
	       		}
	       		else if(diffY<0 && that.speed.getY()>0) {
	       			//that.getSpeed().getDY()>0 soll dafuer sorgen, dass sich die Kugel
	       			//komplett aus dem this-Objekt herausbewegt
	       			
	       			//Kugel kollidiert mit der oberen Seite
	       			
	       			//Geschwindigkeit in y-Richtung umdrehen
	       		    that.speed = new Vector(that.speed.getX(), -that.speed.getY());
	       		}
	       	}
		
	       	//Haben Kugel und BrokenBlock die gleiche Farbe?
			if(this.getColor()==Color.GRAY || this.getColor()==that.getColor()) {
				return this;
			}
		}
		return null;
	}
}
