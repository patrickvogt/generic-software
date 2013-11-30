package net.patrickvogt.pinkball.geom;

import java.awt.Color;

import net.patrickvogt.pinkball.excpetion.GameOverException;
import net.patrickvogt.pinkball.painter.IPainter;
import net.patrickvogt.pinkball.vector.Vector;

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
	public OutputHole(float __pos_x, float __pos_y, float __width, float __height) {
		super(new Vector(__pos_x,__pos_y), new Vector(__width,__height), Color.BLACK);
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
	public boolean isBlocked(java.util.List<Ball> myObjects) {
		boolean _isBlocked=false;
		for(Ball that:myObjects) {
				//beruehrt eines der Objekte das OutputHole
				if(this.touches(that)) {
					//WENN ja DANN ist OutPutHole blockiert
					_isBlocked=_isBlocked||true;
				}
			}
		
		return(_isBlocked);
	}


    @Override
    public GeometricObject handleCollision(GeometricObject that)
            throws GameOverException
    {
        return null;
    }
}
