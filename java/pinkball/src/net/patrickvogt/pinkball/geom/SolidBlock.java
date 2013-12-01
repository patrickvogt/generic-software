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
// SolidBlock ist eine Unterklasse von GeometricObject
public class SolidBlock extends GeometricObject
{

    /**
     * erzeugt eine neue Instanz von <code>SolidBlock</code>
     * 
     * @param _x
     *            die x-Position des zu erzeugenden Objekts
     * 
     * @param _y
     *            die y-Position des zu erzeugenden Objekts
     * 
     * @param _width
     *            die Weite (gleichzeitig Hoehe) des zu erzeugenden Objekts
     * 
     */
    public SolidBlock(float _x, float _y, float _width, float _height,
            Color colour)
    {
        // oberen Konstruktor aufrufen
        super(new Vector(_x, _y), new Vector(_width, _height), colour);
    }

    public void paint(IPainter p)
    {
        p.paint(this);
    }

    /**
     * reagiert auf eine Kollision zwischen <code>SolidBlock</code> und
     * <code>Ball</code>
     * 
     * @param that
     *            das Objekt, welches das this Objekt beruehrt
     */
    @Override
    public GeometricObject handleCollision(GeometricObject that)
    {
        // ist that eine Kugel? (Nur Kugeln koennen sich im Spiel bewegen)
        // feststellen, ob die Kugel mit einer horizontalen oder mit einer
        // vertikalen
        // Seite kollidiert ist
        double diffX = that.getCenterX() - this.getCenterX();
        double diffY = that.getCenterY() - this.getCenterY();

        if(Math.abs(diffX) > Math.abs(diffY))
        {
            that.speed.invertX();
        }
        else
        {
            that.speed.invertY();
        }

        // Farbe der Kugel aendern
        // Grau gilt im Spiel als neutrale Farbe, deshalb aendert ein graues
        // Stein nicht die
        // Farbe von den Kugeln
        if(this.getColor() != Color.GRAY && this.getColor() != that.getColor())
        {
            that.setColor(this.getColor());
        }

        return null;
    }
}
