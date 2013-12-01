package net.patrickvogt.pinkball.geom;

import java.awt.Color;

import net.patrickvogt.pinkball.painter.IPainter;
import net.patrickvogt.pinkball.vector.Vector;

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
public class ShrinkBlock extends GeometricObject {

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
	public ShrinkBlock(float __pos_x, float __pos_y, float __width, float __height, Color __color) {
        super(new Vector(__pos_x,__pos_y), new Vector(__width,__height), __color);
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
	public GeometricObject handleCollision(GeometricObject that) {
		
			//haben Kugel und ShrinkingBlock die gleiche Farbe?
			//(Grau gilt im Spiel als neutrale Farbe und kann alle Kugeln schrumpfen)
			if(this.getColor()==Color.GRAY || this.getColor()==that.getColor()) {
				//ist der Durchmesser der Kugel groesser als die Haelfte des ShrinkingBlocks?
				if(((Ball)that).getDiameter()>0.5*this.getWidth()) {
					//WENN ja DANN verkleine den Durchmesser ein bisschen
					((Ball)that).setDiameter(((Ball)that).getDiameter()*0.99f);
				}
			}
		
		return null;
	}
}
