package net.patrickvogt.pinkball.geom;

import java.awt.Color;

import net.patrickvogt.pinkball.excpetion.GameOverException;
import net.patrickvogt.pinkball.painter.IPaintable;
import net.patrickvogt.pinkball.painter.IPainter;
import net.patrickvogt.pinkball.util.ITouchable;
import net.patrickvogt.pinkball.vector.Vector;

/*
 * GeometricObject.java
 */

/**
 * <p>
 * implementiert eine Oberklasse, von der alle geometrischen Objekte spaeter
 * erben sollen.
 * </p>
 * 
 * @author Patrick Vogt
 * 
 */
// GeometricObject implementiert die Schnittstellen Paintable, Touchsble und
// Moveable
public abstract class GeometricObject implements IPaintable, ITouchable
{

    /**
     * beschreibt die Koordinate der linken oberen Ecke der BoundingBox
     */
    protected Vector position;

    /**
     * beschreibt die Dimension (Weite/Hoehe) des geometrischen Objekts in
     * 2-dimensionalen Raum
     */
    protected Vector dimension;

    /**
     * beschreibt die Geschwindigkeit (Veraenderung des Ortes) in x und y des
     * Objekts
     */
    protected Vector speed;

    /**
     * beschreibt die aktuelle Farbe des Objekts
     */
    protected Color color;

    /**
     * erzeugt eine neue Instanz von <code>GeometricObject</code>
     * 
     * @param _myPosition
     *            die Position (linke obere Ecke) des Objekts
     * 
     * @param _myDimension
     *            die Dimension (Weite/Hoehe) des Objekts
     * 
     * @param _myColor
     *            die Farbe des zu erzeugenden Objekts
     * 
     */
    public GeometricObject(Vector _position, Vector _dimension,
            Color _color)
    {
        // this-Felder setzen
        this.position = _position;
        this.dimension = _dimension;
        this.color = _color;
        // alle Objekte mit der Geschwindigkeit 0 (beide Richtungen)
        // initialisieren
        this.speed = new Vector(0.0f, 0.0f);
    }

    /**
     * erzeugt eine Instanz von <code>GeometricObjekt</code>
     * 
     * @param _x
     *            die x-Position auf dem Spielfeld
     * 
     * @param _y
     *            die y-Position auf dem Spielfeld
     * 
     * @param _width
     *            die Weite des Objekts
     * 
     * @param _height
     *            die Hoehe des Objekts
     * 
     */
    public GeometricObject(float _x, float _y, float _width, float _height)
    {
        // oberen Konstrukor aufrufen
        this(new Vector(_x, _y), new Vector(_width, _height),
                Color.GRAY);
    }

    public float getX()
    {
        return this.position.getX();
    }

    public int getXAsInt()
    {
        return this.position.getXAsInt();
    }

    public float getY()
    {
        return this.position.getY();
    }

    public int getYAsInt()
    {
        return this.position.getYAsInt();
    }

    public float getWidth()
    {
        return this.dimension.getX();
    }

    public int getWidthAsInt()
    {
        return this.dimension.getXAsInt();
    }

    public float getHeight()
    {
        return this.dimension.getY();
    }

    public int getHeightAsInt()
    {
        return this.dimension.getYAsInt();
    }

    public void setDimension(Vector _myDimension)
    {
        this.dimension = _myDimension;
    }

    public Color getColor()
    {
        return this.color;
    }
    
    public void setColor(Color _color)
    {
        this.color = _color;
    }
    
    public abstract void paint(IPainter p);

    public abstract GeometricObject handleCollision(GeometricObject that) throws GameOverException;

    public void moveTo(Vector _myPosition)
    {
        this.position = _myPosition;
    }
    
    public void moveTo(int x, int y)
    {
        this.position = new Vector(x,y);
    }

    public boolean hasWithin(Vector p)
    {
        return p.getX() >= this.position.getX()
                && p.getX() <= this.position.getX()
                        + this.dimension.getX()
                && p.getY() >= this.position.getY()
                && p.getY() <= (this.position.getY() + this.dimension
                        .getY());
    }

    private boolean isLeftOf(GeometricObject that)
    {
        return this.position.getX() + this.dimension.getX() < that
                .position.getX();
    }

    private boolean isTopOf(GeometricObject that)
    {
        return this.position.getY() + this.dimension.getY() < that
                .position.getY();
    }

    public boolean touches(GeometricObject that)
    {
            // sind die Objekte uebereinander OR nebeneinander
            return !this.isLeftOf(that) && !this.isTopOf(that) 
                    && !that.isLeftOf(this) && !that.isTopOf(this);
    }
    
    public Vector getCenter()
    {
        return new Vector(getCenterX(),getCenterY());
    }
    
    public float getCenterX()
    {
        return this.position.getX()+this.dimension.getX()/2;
    }
    
    public float getCenterY()
    {
        return this.position.getY()+this.dimension.getY()/2;
    }
    
    public int getCenterYAsInt()
    {
        return (int)this.getCenterY();
    }

    public int getCenterXAsInt()
    {
        return (int)this.getCenterX();
    }
}
