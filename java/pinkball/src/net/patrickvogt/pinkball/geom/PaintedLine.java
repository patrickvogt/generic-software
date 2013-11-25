package net.patrickvogt.pinkball.geom;

import java.util.ArrayList;
import java.util.List;

import net.patrickvogt.pinkball.gui.Board;
import net.patrickvogt.pinkball.painter.IPainter;
import net.patrickvogt.pinkball.vector.Coordinate;
import net.patrickvogt.pinkball.vector.Speed;

public class PaintedLine extends GeometricObject
{

    /**
     * eigentliche Linie, die spaeter zum zeichnen und fuer die
     * Beruehrungsfunktion benoetigt wird
     */
    private List<Coordinate> line = new ArrayList<Coordinate>();

    // /**
    // * speichert den Beruehrpunkt zwischen Linie und Kugel
    // * (die wie vielte Position/Koordinate innerhab der Linie)
    // */
    private int lastTouchPoint;

    private Coordinate touchSegmentStart = null;
    private Coordinate touchSegmentEnd = null;

    public PaintedLine()
    {
        // PSEUDO-GeometricObject erzeugen
        super(0.0f, 0.0f, 0.0f, 0.0f);

    }

    public void getPoints(final int[] xPoints, final int[] yPoints)
    {
        int i = 0;

        for(Coordinate c : this.line)
        {
            xPoints[i] = c.getXAsInt();
            yPoints[i] = c.getYAsInt();

            i = i + 1;
        }
    }

    public void addPoint(int x, int y)
    {
        this.line.add(new Coordinate(x, y));
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
        // ist that eine Kugel= (Nur Kugeln koennen sich im Spiel bewegen)
        if(that instanceof Ball)
        {   
            for(int i = 0; i < (this.line.size() - 1); i = i + 1)
            {
                // http://stackoverflow.com/questions/1073336/circle-line-collision-detection
                Coordinate c_i = this.line.get(i);
                Coordinate c_i_1 = this.line.get(i + 1);

                float r = that.getWidth() / 2;

                float dx = c_i_1.getX() - c_i.getX();
                float dy = c_i_1.getY() - c_i.getY();
                float fx = c_i.getX() - that.getCenter().getX();
                float fy = c_i.getY() - that.getCenter().getY();

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
                        // http://mathworld.wolfram.com/Reflection.html
                        double nx = -dy;
                        double ny = dx;
                        
                        if(this.line.size() > 0 && that.hasWithin(this.line.get(0)))
                        {
                           Coordinate v = this.line.get(0);
                           Coordinate w = that.getCenter();
                           float vx = that.getSpeed().getDX();
                           float vy = that.getSpeed().getDY();
                           float that_length = that.getSpeed().length();
                           
                           Speed s = new Speed(v.getX()-w.getX(), v.getY()-w.getY());
                           
                           nx = this.line.get(1).getX()-this.line.get(0).getX();
                           ny = this.line.get(1).getY()-this.line.get(0).getY();
                           
                           double n_length = Math.sqrt(nx * nx + ny * ny);

                           nx = nx / n_length;
                           ny = ny / n_length;

                           double dot_v_n = s.getDX() * nx
                                   + s.getDY() * ny;
                           
//                           if(-0.05 < dot_v_n && dot_v_n < 0.05)
//                           {
//                               if(Math.abs(v.getX()-w.getX()) > Math.abs(v.getY()-w.getY()))
//                               {
//                                   s = new Speed(-s.getDX(), s.getDY());
//                               }
//                               else
//                               {
//                                   s = new Speed(s.getDX(), -s.getDY());
//                               }
//                           }

                           double delta_vx = 2 * dot_v_n * nx;
                           double delta_vy = 2 * dot_v_n * ny;

                           that.getSpeed().sub(s);
                           that.getSpeed().normalize();
                           that.getSpeed().mult(that_length);

                           
//                           that.setSpeed(new Speed(vx, vy));
                           ((Ball) that).move();
                           Board.destroyThat.add(this);
                           return true;
                           
                        }
                        if(this.line.size() > 0 && that.hasWithin(this.line.get(this.line.size()-1)))
                        {
                            Coordinate v = this.line.get(this.line.size()-1);
                            Coordinate w = that.getCenter();
                            float vx = that.getSpeed().getDX();
                            float vy = that.getSpeed().getDY();
                            float that_length = that.getSpeed().length();
                            
                            Speed s = new Speed(v.getX()-w.getX(), v.getY()-w.getY());
                            
                            nx = this.line.get(this.line.size()-1).getX()-this.line.get(this.line.size()-2).getX();
                            ny = this.line.get(this.line.size()-1).getY()-this.line.get(this.line.size()-2).getY();
                            
                            double n_length = Math.sqrt(nx * nx + ny * ny);

                            nx = nx / n_length;
                            ny = ny / n_length;

                            double dot_v_n = s.getDX() * nx
                                    + s.getDY() * ny;
                            
//                            if(-0.05 < dot_v_n && dot_v_n < 0.05)
//                            {
//                                if(Math.abs(v.getX()-w.getX()) > Math.abs(v.getY()-w.getY()))
//                                {
//                                    s = new Speed(-s.getDX(), s.getDY());
//                                }
//                                else
//                                {
//                                    s = new Speed(s.getDX(), -s.getDY());
//                                }
//                            }

                            double delta_vx = 2 * dot_v_n * nx;
                            double delta_vy = 2 * dot_v_n * ny;

                            that.getSpeed().sub(s);
                            that.getSpeed().normalize();
                            that.getSpeed().mult(that_length);

                            
//                            that.setSpeed(new Speed(vx, vy));
                            ((Ball) that).move();
                            Board.destroyThat.add(this);
                            return true;
                        }

                        double n_length = Math.sqrt(nx * nx + ny * ny);

                        nx = nx / n_length;
                        ny = ny / n_length;

                        double dot_v_n = that.getSpeed().getDX() * nx
                                + that.getSpeed().getDY() * ny;

                        double delta_vx = 2 * dot_v_n * nx;
                        double delta_vy = 2 * dot_v_n * ny;

                        that.setSpeed(new Speed((float) (that.getSpeed()
                                .getDX() - delta_vx), (float) (that.getSpeed()
                                .getDY() - delta_vy)));

                        ((Ball) that).move();
                        
                        Board.destroyThat.add(this);
                        
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
     * 
     * @throws DestroyThatException
     *             wenn die Linie mit einer Kugel kollidiert ist und nun die
     *             Linie vom Spielfeld geloescht werden soll
     * 
     */
    @Override
    public void handleCollision(GeometricObject that)
    {
        

    }

    public int getNumPoints()
    {
        return this.line.size();
    }
}
