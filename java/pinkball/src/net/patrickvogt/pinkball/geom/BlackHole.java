package net.patrickvogt.pinkball.geom;

import java.awt.Color;

import net.patrickvogt.pinkball.excpetion.GameOverException;
import net.patrickvogt.pinkball.painter.IPainter;
import net.patrickvogt.pinkball.vector.Vector;

public class BlackHole extends GeometricObject
{

    public BlackHole(float __pos_x, float __pos_y, float __width,
            float __height, Color __color)
    {
        super(new Vector(__pos_x, __pos_y), new Vector(__width, __height),
                __color);
    }

    public void paint(IPainter p)
    {
        p.paint(this);
    }

    @Override
    public boolean touches(GeometricObject that)
    {
        // ist that eine Kugel? (Nur Kugeln koennen sich im Spiel bewegen)
        if(that instanceof Ball)
        {
            // beruehren sich die BoundingBoxen der beiden Objekte?
            if(super.touches(that))
            {
                // Vektor zwischen Kugel und BlackHole bestimmen
                Vector c = new Vector(this.getCenterX() - that.getCenterX(),
                        this.getCenterY() - that.getCenterY());

                // Distanz bzw. Betrag des Vektors bestimmen
                double d = Math.sqrt(c.getX() * c.getX() + c.getY() * c.getY());

                return d < 3 * this.dimension.getX() / 8
                        + that.dimension.getX() / 2;
            }
            return false;
        }
        return false;
    }

    @Override
    public GeometricObject handleCollision(GeometricObject that)
            throws GameOverException
    {
        // ist that eine Kugel? (Nur Kugeln koennen sich im Spiel bewegen)
        // AND passt die Kugel ueberhauot in dieses schwarze Loch
        if(this.getWidth() >= that.getWidth())
        {
            // Attribut isInBlackHole in Kugel setzen, um zu verhindern, dass
            // die Kugeln
            // innerhalb des schwarzen Lochs abprallen
            if(!((Ball) that).getIsInBalckHole())
            {
                ((Ball) that).toggleIsInBlackHole();
            }
            // Kugel soll sich geradewegs zum Zentrum des schwarzen Lochs
            // weiterbewegen
            // entsprechend die Geschwindigkeitsvektoren setzen
            that.speed = new Vector(-0.2f
                    * (that.getCenterX() - this.getCenterX()), -0.2f
                    * (that.getCenterY() - this.getCenterY()));

            // Durchmesser der Kugeln verkleinern -> Effekt, dass die Kugel
            // eingezogen wird, sich wegbewegt
            if(((Ball) that).getDiameter() > this.dimension.getX() / 2)
            {
                ((Ball) that).setDiameter(((Ball) that).getDiameter() * 0.9f);
            }

            // befindet sich die Kugel im Zentrum des schwarzen Lochs?
            if(that.getCenter().equals(this.getCenter()))
            {
                // entspricht die Farbe der Kugel nicht der Farbe des schwarzen
                // Lochs

                // (Grau ist in diesem Spiel eine neutrale Farbe)
                // Graue Kugeln koennen in alle BlackHoles fallen und
                // alle Kugeln koennen in graue BlackHoles fallen (dies gibt
                // jedoch keine Punkte)
                if(this.getColor() != Color.GRAY
                        && that.getColor() != Color.GRAY
                        && that.getColor() != this.getColor())
                {
                    throw new GameOverException();
                }
                return that;
            }
        }
        return null;
    }
}
