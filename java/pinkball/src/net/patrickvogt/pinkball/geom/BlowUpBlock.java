package net.patrickvogt.pinkball.geom;

import java.awt.Color;

import net.patrickvogt.pinkball.painter.IPainter;
import net.patrickvogt.pinkball.vector.Vector;

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
	public BlowUpBlock(float __pos_x, float __pos_y, float __width, float __height, Color __color) {
        super(new Vector(__pos_x,__pos_y), new Vector(__width,__height), __color);
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
	public GeometricObject handleCollision(GeometricObject that) {
		//ist that eine Kugel? (Nur Kugeln koennen sich im Spiel bewegen)
		if(that instanceof Ball) {
			//entspricht die Farbe des BlowUpBlock der Farbe der Kugel?
			if(this.getColor()==Color.GRAY || this.getColor()==that.getColor()) {
				//ist die Kugel kleiner als ein bestimmer Wert?
				//(das anderthalbfache des BlowUpBlocks)
				if(((Ball)that).getDiameter()<1.5*this.getWidth()) {
					//WENN ja DANN vergoessere den Durchmesser der Kugel
					((Ball)that).setDiameter(((Ball)that).getDiameter()*1.01f);
				}
			}
		}
		return null;
	}
}
