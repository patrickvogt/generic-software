package net.patrickvogt.pinkball.geom;

/*
 * OutputHole.java
 */

import java.awt.*;

import net.patrickvogt.pinkball.vector.*;

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
	public OutputHole(double _x, double _y, double _width) {
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
	public OutputHole(Coordinate _myPosition, double _width) {
		//oberen Konstruktor aufrufen
		this(_myPosition, new Dimension2D(_width,_width));
	}
	
	/**
	 * zeichnet das Objekt auf dem uebergebenen Graphik-Kontext
	 * 
	 * @param g der Graphik-Kontext, auf dem das Objekt gezeichnet werden soll
	 * 
	 */
	@Override
	public void paintMeTo(Graphics g) {
		//graue Kontur zeichnen
		g.setColor(Color.GRAY);
		g.drawRect((int) this.getPosition().getX(), 
				(int) this.getPosition().getY(), 
				(int) this.getDimension().getWidth(), 
				(int) this.getDimension().getHeight());
		//mittig, kleines und farbiges OutputHole zeichnen
		g.setColor(this.getColor());
		g.fillOval((int) (this.getPosition().getX()+0.375*this.getDimension().getWidth()+1), 
				(int) (this.getPosition().getY()+0.375*this.getDimension().getHeight()+1), 
				(int) (0.25*this.getDimension().getWidth()), 
				(int) (0.25*this.getDimension().getHeight()));
		//vier kleine Kuegelchen an den vier Ecken zeichnen
		g.setColor(Color.RED);
		g.fillOval((int) (this.getPosition().getX()-3), 
				(int) (this.getPosition().getY()-3), 
						6, 6);
		g.fillOval((int) (this.getPosition().getX()+this.getDimension().getWidth()-3), 
				(int) (this.getPosition().getY()-3), 
						6, 6);
		g.fillOval((int) (this.getPosition().getX()-3), 
				(int) (this.getPosition().getY()+this.getDimension().getHeight()-3), 
						6, 6);
		g.fillOval((int) (this.getPosition().getX()+this.getDimension().getWidth()-3), 
				(int) (this.getPosition().getY()+this.getDimension().getHeight()-3), 
						6, 6);
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
				if(this.touches(that)) {
					//WENN ja DANN ist OutPutHole blockiert
					_isBlocked=_isBlocked||true;
				}
			}
		}
		return(_isBlocked);
	}
}
