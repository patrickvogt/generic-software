package net.patrickvogt.pinkball.geom;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import net.patrickvogt.pinkball.painter.IPainter;
import net.patrickvogt.pinkball.vector.Vector;

public class PaintedLine extends GeometricObject
{

    /**
     * eigentliche Linie, die spaeter zum zeichnen und fuer die
     * Beruehrungsfunktion benoetigt wird
     */
    private List<Vector> line = new ArrayList<Vector>();

    private Vector touchSegmentStart = null;
    private Vector touchSegmentEnd = null;

    public PaintedLine(Color colour)
    {
        // PSEUDO-GeometricObject erzeugen
        super(new Vector(0.0f, 0.0f), new Vector(0.0f, 0.0f), colour);

    }

    public void getPointsAsIntArrays(final int[] xPoints, final int[] yPoints)
    {
        int i = 0;

        for(Vector c : this.line)
        {
            xPoints[i] = c.getXAsInt();
            yPoints[i] = c.getYAsInt();

            i = i + 1;
        }
    }

    public void addPoint(int x, int y)
    {
        this.line.add(new Vector(x, y));
    }

    public void paint(IPainter p)
    {
        p.paint(this);
    }

    /**
     * prueft ob sich das this-Objekt und das uebergebene Objekt beruehren
     * 
     * @param that
     *            das mit dem this-Objekt zu ueberpruefende Objekt
     * 
     * @return ob sich this- und that Objekt beruehren
     * 
     */
    @Override
    public boolean touches(GeometricObject that)
    {
        // TODO als Vektoren umschreiben

        // ist that eine Kugel= (Nur Kugeln koennen sich im Spiel bewegen)
        if(that instanceof Ball && (that.getColor()==this.getColor() || this.getColor()==Color.black))
        {   
            for(int i = 0; i < (this.line.size() - 1); i = i + 1)
            {
                // http://stackoverflow.com/questions/1073336/circle-line-collision-detection
                Vector c_i = this.line.get(i);
                Vector c_i_1 = this.line.get(i + 1);

                float r = that.getWidth() / 2;

                float dx = c_i_1.getX() - c_i.getX();
                float dy = c_i_1.getY() - c_i.getY();
                float fx = c_i.getX() - that.getCenterX();
                float fy = c_i.getY() - that.getCenterY();

                float a = dx * dx + dy * dy;
                float b = 2.0f * (fx * dx + fy * dy);
                float c = fx * fx + fy * fy - r * r;

                double discriminant = b * b - 4 * a * c;
                if(discriminant < 0)
                {
                    continue;
                }
                else
                {
                    discriminant = Math.sqrt(discriminant);

                    double t1 = (-b - discriminant) / (2 * a);
                    double t2 = (-b + discriminant) / (2 * a);

                    if((t1 >= 0 && t1 <= 1) || (t2 >= 0 && t2 <= 1))
                    {
                        touchSegmentStart = c_i;
                        touchSegmentEnd = c_i_1;

                        return true;
                    }

                }

            }

        }
        return false;
    }

    /**
     * reagiert auf eine Kollision zwischen <code>PaintedLine</code> und
     * <code>Ball</code>
     * 
     * @param that
     *            das Objekt, welches das this-Objekt (die Linie) beruehrt
     * @return
     * 
     * @throws DestroyThatException
     *             wenn die Linie mit einer Kugel kollidiert ist und nun die
     *             Linie vom Spielfeld geloescht werden soll
     * 
     */
    @Override
    public GeometricObject handleCollision(GeometricObject that)
    {
        // http://mathworld.wolfram.com/Reflection.html
        boolean endpointCollision = false;
        float that_length = that.speed.getLength();

        double nx = 0.0;
        double ny = 0.0;

        Vector s = null;
        Vector t = null;
        Vector u = null;
        Vector v = null;

        if(this.line.size() > 0 && that.hasWithin(this.line.get(0)))
        {
            endpointCollision = true;
            t = this.line.get(0);
            u = this.line.get(1);
            v = this.line.get(0);
        }
        else if(this.line.size() > 0
                && that.hasWithin(this.line.get(this.line.size() - 1)))
        {
            endpointCollision = true;
            t = this.line.get(this.line.size() - 2);
            u = this.line.get(this.line.size() - 1);
            v = this.line.get(this.line.size() - 1);
        }

        if(endpointCollision)
        {
            nx = u.getX() - t.getX();
            ny = u.getY() - t.getY();
        }
        else
        {
            nx = -(touchSegmentEnd.getY() - touchSegmentStart.getY());
            ny = touchSegmentEnd.getX() - touchSegmentStart.getX();

        }

        double n_length = Math.sqrt(nx * nx + ny * ny);

        nx = nx / n_length;
        ny = ny / n_length;

        if(endpointCollision)
        {
            Vector w = new Vector(that.getCenterX(), that.getCenterY());
            s = new Vector(v.getX() - w.getX(), v.getY() - w.getY());
        }
        else
        {
            double dot_v_n = that.speed.getX() * nx + that.speed.getY() * ny;

            double delta_vx = 2 * dot_v_n * nx;
            double delta_vy = 2 * dot_v_n * ny;

            s = new Vector((float) delta_vx, (float) delta_vy);
        }

        that.speed.sub(s);
        that.speed.normalize();
        that.speed.mult(that_length);

        ((Ball) that).move();

        return this;

    }

    public int getNumPoints()
    {
        return this.line.size();
    }
}
