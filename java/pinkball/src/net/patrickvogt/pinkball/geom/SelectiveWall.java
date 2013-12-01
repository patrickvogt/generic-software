package net.patrickvogt.pinkball.geom;

import java.awt.Color;

import net.patrickvogt.pinkball.painter.IPainter;
import net.patrickvogt.pinkball.vector.Vector;

/*
 * SelectiveWall.java
 */

/**
 * implementiert eine selektive Wand, die eine Farbe besitzt und nur von
 * entsprechenden Kugeln (mit der gleichen Farbe der Wand) passiert werden
 * koennen. Andersfarbige Kugeln prallen von dieser Wand ab
 * 
 * @author Patrick Vogt
 * 
 */
// SelectiveWall ist eine Unterklasse von GeometricObject
public class SelectiveWall extends GeometricObject
{

    public SelectiveWall(float _x, float _y, float _width, float _height,
            Color _myColor)
    {
        // oberen Kontruktor aufrufen
        super(new Vector(_x, _y), new Vector(_width, _height), _myColor);
    }

    public void paint(IPainter p)
    {
        p.paint(this);
    }

    /**
     * reagiert auf eine Kollision zwischen <code>SelectiveWall</code> und
     * <code>Ball</code>
     * 
     * @param that
     *            das Objekt, welches das this-Objekt beruehrt
     * 
     */
    @Override
    public GeometricObject handleCollision(GeometricObject that)
    {
        // ist that eine Kugel? (nur Kugeln koennen sich im Spiel bewegen
        // AND ist die Farbe der Kugel nicht grau (neutrale Farbe im Spiel)
        // AND ist die Farbe des this-Objekt ungleich der Farbe des that-Objekts
        if(this.getColor() != that.getColor())
        {
            // WENN ja DANN prall ab

            // feststellen, ob die Kugel mit einer horizontalen oder mit einer
            // vertikalen
            // Seite kollidiert ist
            double diffX = that.getCenterX() - this.getCenterX();
            double diffY = that.getCenterY() - this.getCenterY();
            double absDiffX = Math.abs(diffX) - this.getWidth() / 2;
            double absDiffY = Math.abs(diffY) - this.getHeight() / 2;
            if(absDiffX > absDiffY)
            {
                that.speed.invertX();
            }
            else
            {
                that.speed.invertY();
            }
        }

        return null;
    }
}
