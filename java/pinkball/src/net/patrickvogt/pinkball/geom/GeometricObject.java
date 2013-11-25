package net.patrickvogt.pinkball.geom;

import java.awt.Color;


import net.patrickvogt.pinkball.painter.IPaintable;
import net.patrickvogt.pinkball.painter.IPainter;
import net.patrickvogt.pinkball.util.Touchable;
import net.patrickvogt.pinkball.vector.Coordinate;
import net.patrickvogt.pinkball.vector.Dimension2D;
import net.patrickvogt.pinkball.vector.Speed;

/*
 * GeometricObject.java
 */


/**
 * <p>implementiert eine Oberklasse, von der alle geometrischen Objekte spaeter erben sollen.</p>
 * 
 * @author Patrick Vogt
 *
 */
//GeometricObject implementiert die Schnittstellen Paintable, Touchsble und Moveable
public abstract class GeometricObject implements IPaintable, Touchable {
	
	/**
	 * beschreibt die Koordinate der linken oberen Ecke der BoundingBox
	 */
	protected Coordinate myPosition;
	
	/**
	 * beschreibt die Dimension (Weite/Hoehe) des geometrischen Objekts in 2-dimensionalen Raum
	 */
	protected Dimension2D myDimension;
	
	/**
	 * beschreibt die aktuelle Farbe des Objekts
	 */
	protected Color myColor;
	
	/**
	 * beschreibt die Geschwindigkeit (Veraenderung des Ortes) in x und y des Objekts
	 */
	protected Speed mySpeed;
	
	/**
	 * erzeugt eine neue Instanz von <code>GeometricObject</code>
	 * 
	 * @param _myPosition die Position (linke obere Ecke) des Objekts
	 * 
	 * @param _myDimension die Dimension (Weite/Hoehe) des Objekts
	 * 
	 * @param _myColor die Farbe des zu erzeugenden Objekts
	 * 
	 */
	public GeometricObject(Coordinate _myPosition, Dimension2D _myDimension, Color _myColor) {
		//this-Felder setzen
		this.myPosition=_myPosition;
		this.myDimension=_myDimension;
		this.myColor=_myColor;
		//alle Objekte mit der Geschwindigkeit 0 (beide Richtungen) initialisieren
		this.mySpeed=new Speed(0.0f,0.0f);
	}
	
	/**
	 * erzeugt eine Instanz von <code>GeometricObjekt</code>
	 * 
	 * @param _x die x-Position auf dem Spielfeld
	 * 
	 * @param _y die y-Position auf dem Spielfeld
	 * 
	 * @param _width die Weite des Objekts
	 * 
	 * @param _height die Hoehe des Objekts
	 * 
	 */
	public GeometricObject(float _x, float _y, float _width, float _height) {
		//oberen Konstrukor aufrufen
		this(new Coordinate(_x,_y), new Dimension2D(_width,_height), Color.GRAY);
	}
	
	/**
	 * Zugriffsmethode um die aktuelle Poistion des Objekts (linke obere Ecke) zu bekommen
	 * 
	 * @return Koordinate/Position (der linken oberen Ecke) des Objekts
	 * 
	 */
	public Coordinate getPosition() {
		return(this.myPosition);
	}
	
	public float getX()
	{
	    return this.myPosition.getX();
	}
	
	public int getXAsInt()
	{
	    return this.myPosition.getXAsInt();
	}
	
	public float getY()
	{
	    return this.myPosition.getY();
	}
	
	public int getYAsInt()
	{
	    return this.myPosition.getYAsInt();
	}
	
	/**
	 * Zugriffsmethode um die aktuelle Position (linke obere Ecke) des Objekts auf eine neue
	 * uebergebene Koordinate zu setzen
	 * 
	 * @param _myPosition die neue Koordinate (linke obere Ecke) des Objekts
	 * 
	 */
	public void setPosition(Coordinate _myPosition) {
		this.myPosition=_myPosition;
	}
	
	/**
	 * Zugriffsmethode um die aktuelle Dimension des Objekts zu bekommen
	 * 
	 * @return die aktuelle Dimension des Objekts
	 * 
	 */
	public Dimension2D getDimension() {
		return(this.myDimension);
	}
	
	   public float getWidth()
	    {
	        return this.myDimension.getWidth();
	    }
	    
	    public int getWidthAsInt()
	    {
	        return this.myDimension.getWidthAsInt();
	    }
	    
	    public float getHeight()
	    {
	        return this.myDimension.getHeight();
	    }
	    
	    public int getHeightAsInt()
	    {
	        return this.myDimension.getHeightAsInt();
	    }
	
	/**
	 * Zugriffsmethode um die Dimension des Objekts auf den uebergebenen Wert zu setzen
	 * 
	 * @param _myDimension neue Dimesnion (Weite/Hoehe) des Objekts
	 * 
	 */
	public void setDimension(Dimension2D _myDimension) {
		this.myDimension=_myDimension;
	}
	
	/**
	 * Zugrifsmethode um die aktuelle Farbe des Objekts zu bekommen
	 * 
	 * @return die aktuelle Farbe des Objekts
	 * 
	 */
	public Color getColor() {
		return(this.myColor);
	}
	
	/**
	 * Zugriffmethode um die aktuelle Farbe des Objekts auf eine uebergebene Farbe zu setzen
	 * 
	 * @param _myColor die neue Farbe des Objekts
	 * 
	 */
	public void setColor(Color _myColor) {
		this.myColor=_myColor;
	}
	
	/**
	 * Zugriffsmethode um den aktuellen Geschwindigkeitsvektor des Objekts zu bekommen
	 * 
	 * @return der aktuelle Geschwindigkeitsvektor des Objekts
	 * 
	 */
	public Speed getSpeed() {
		return(this.mySpeed);
	}
	
	/**
	 * Zugriffsmethode um den Geschwindigkeitsvektor auf einen uebergebenen Vektor zu setzen
	 * 
	 * @param _mySpeed der neue Geschwindigkeitsvektor des Objekts
	 * 
	 */
	public void setSpeed(Speed _mySpeed) {
		this.mySpeed=_mySpeed;
	}
	
	/**
	 * gibt die Koordinate des Mittelpunktes des Objekts zurueck
	 * 
	 * @return Koordinate des Mittelpunkts 
	 * 
	 */
	public Coordinate getCenter() {
		return(new Coordinate(this.getPosition().getX()+this.getDimension().getWidth()/2.0f,
				this.getPosition().getY()+this.getDimension().getHeight()/2.0f));
	}
	
	public abstract void paint(IPainter p);
	
	/**
	 * ueberprueft, ob das Objekt den Rand des Spielfed derzeit beruehrt oder sich schon ueber den Rand
	 * hinaus bewegt hat
	 * 
	 * @param BOARD_WIDTH die Weite des Spielfelds
	 * 
	 * @param BOARD_HEIGHT die Hoehe des Spielfelds
	 * 
	 */
	public void checkCollisionOnBorder(int BOARD_WIDTH, int BOARD_HEIGHT) {
		
	}
	
	/**
	 * <p>soll auf eine Beruehrung zweier Objekte angemessen reagieren. </p>
	 * <p>Diese Methode wird von den Unterklassen individuell ueberschrieben</p>
	 */
	public void handleCollision(GeometricObject that)  {
		
	}
	
	/**
	 * aendert die Koordinate der linken oberen Ecke der BoundingBox auf die uebergebene Koordinate
	 * 
	 * @param _myPosition die neue Koordinate der BoundingBox
	 * 
	 */
	public void moveTo(Coordinate _myPosition) {
		this.getPosition().setX(_myPosition.getX());
		this.getPosition().setY(_myPosition.getY());
	}
	
	/**
	 * prueft, ob sich eine Koordinate in dem this-Objekt befindet
	 * 
	 * @param p die zu ueberpriefende Koordinate
	 * 
	 * @return ob sich die Koordinate p innerhalb des this-Objekts befindet
	 * 
	 */
	public boolean hasWithin(Coordinate p) {
        return p.getX() >= this.getPosition().getX() 
        		&& p.getX() <= this.getPosition().getX()+this.getDimension().getWidth() 
        		&& p.getY() >= this.getPosition().getY() 
        		&& p.getY() <= (this.getPosition().getY()+this.getDimension().getHeight()); 
    }
	
	/**
	 * interne Hilfsmethode, die entscheidet ob das this-Objekt links vom that-Objekt liegt
	 * 
	 * @param that das mit dem this-Objekt zu vergleichende Objekt
	 * 
	 * @return ob das this-Objekt ulinks vom that-Objekt liegt
	 * 
	 */
	private boolean isLeftOf(GeometricObject that) {
    	//liegt das this-Objekt links vom that-Objekt?
        if(this.getPosition().getX()+this.getDimension().getWidth() < that.getPosition().getX()) {
            return(true);
        }
        else {
            return(false);
        }
    }
    
	/**
	 * interne Hilfsmethode, die entscheidet ob das this-Objekt ueberhalb des that-Objekts liegt
	 * 
	 * @param that das mit dem this-Objekt zu vergleichende Objekt
	 * 
	 * @return ob das this-Objekt ueberhalb des that-Objekt liegt
	 * 
	 */
    private boolean isTopOf(GeometricObject that) {
    	//liegt das this-Objekt ueberhalb des that-Objekt?
        if(this.getPosition().getY()+this.getDimension().getHeight() < that.getPosition().getY()) {
            return(true);
        }
        else {
            return(false);
        }  
    }
	
    /**
     * erkennt, ob sich zwei Objekte in ihren BoundingBoxen beruehren
     * 
     * @param that das mit dem this zu vergleichenden Objekt
     * 
     * @return ob this und that sich beruehren
     * 
     */
	public boolean touches(GeometricObject that) {
		//Nur Kugeln ueberpruefen, da sich nur diese auf de mSpielfeld bewegen koennen
		if(that instanceof Ball) {
			//sind die Objekte uebereinander OR nebeneinander
			if(this.isLeftOf(that) || this.isTopOf(that) || that.isLeftOf(this) || that.isTopOf(this)) {
				//WENN ja DANN koennen sie sich nicht beruehren
	            return(false);
	        }
	        else {
	        	//WENN die Objekte nicht uebereinander AND nicht nebeneinander sind, 
	        	//dann muessen sie sich beruehren
	            return(true);
	        }
		}
		else {
			//2 nicht bewegte Objekte koennen sich nicht beruehren
			return(false);
		}

	}
}
