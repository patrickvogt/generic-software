package net.patrickvogt.pinkball.geom;

import java.awt.Color;

import net.patrickvogt.pinkball.painter.IPainter;
import net.patrickvogt.pinkball.util.IMoveable;
import net.patrickvogt.pinkball.vector.Vector;

public class Ball extends GeometricObject implements IMoveable
{

    private static final float ABS_SPEED = 0.6f;

    private boolean isInBlackHole = false;

    private Vector centerDistanceVector = null;

    public Ball(float __diameter, Color __color)
    {

        super(new Vector(0.0f, 0.0f), new Vector(__diameter, __diameter),
                __color);

        Vector v = new Vector((float) (Math.random()), (float) (Math.random()));
         v.setLength(ABS_SPEED);

        this.speed = v;
    }

    public float getDiameter()
    {
        return this.dimension.getX();
    }

    public void setDiameter(float _diameter)
    {
        this.dimension = new Vector(_diameter, _diameter);
    }

    public float getRadius()
    {
        return this.dimension.getX() / 2;
    }

    @Override
    public boolean hasWithin(Vector p)
    {
        final float xx = p.getX() - this.getCenterX();
        final float yy = p.getY() - this.getCenterY();
        final float rr = this.getRadius();

        if(super.hasWithin(p))
        {
            return xx * xx + yy * yy <= rr * rr;
        }
        return false;
    }

    public double getArea()
    {
        return (Math.PI * this.dimension.getX());
    }

    public void toggleIsInBlackHole()
    {
        this.isInBlackHole = !isInBlackHole;
    }

    public boolean getIsInBalckHole()
    {
        return this.isInBlackHole;
    }

    public void paint(IPainter p)
    {
        p.paint(this);
    }

    @Override
    public GeometricObject handleCollision(GeometricObject that)
    {
        if(that instanceof Ball)
        {
            // DANN beruehren sich die beiden Kugeln

            if(null != centerDistanceVector)
            {
                //http://www.vobarian.com/collisions/
                Vector n = new Vector(centerDistanceVector);
                n.normalize();
                
                Vector t = new Vector(-n.getY(), n.getX());
                t.normalize();
                
                float this_v_n = n.dot(this.speed);
                float this_v_t = t.dot(this.speed);
                float that_v_n = n.dot(that.speed);
                float that_v_t = t.dot(that.speed);
                
                float this_v_n_prime = that_v_n;
                float that_v_n_prime = this_v_n;
                
                Vector this_n = new Vector(n);
                Vector this_t = new Vector(t);
                
                Vector that_n = new Vector(n);
                Vector that_t = new Vector(t);
                
                this_n.mult(this_v_n_prime);
                this_t.mult(this_v_t);
                
                that_n.mult(that_v_n_prime);
                that_t.mult(that_v_t);
                
                this_n.add(this_t);
                this.speed = this_n;
                that_n.add(that_t);
                that.speed = that_n;

                this.move();
                ((Ball) that).move();

                return null;
            }
        }
        return null;
    }


    public void checkCollisionOnBorder(int BOARD_WIDTH, int BOARD_HEIGHT)
    {
        if(this.position.getX() < 0 && this.speed.getX() < 0)
        {
            this.speed.invertX();
        }
        if(this.position.getX() + this.dimension.getX() > BOARD_WIDTH
                && this.speed.getX() > 0)
        {
            this.speed.invertX();
        }
        if(this.position.getY() < 0 && this.speed.getY() < 0)
        {
            this.speed.invertY();
        }
        if(this.position.getY() + this.dimension.getY() > BOARD_HEIGHT
                && this.speed.getY() > 0)
        {
            this.speed.invertY();
        }
        this.move();
    }

    @Override
    public boolean touches(GeometricObject that)
    {
        if(that instanceof Ball)
        {
            if(super.touches(that) && !this.getIsInBalckHole()
                    && !((Ball) that).getIsInBalckHole())
            {
                float xx = that.getCenterX()-this.getCenterX();
                float yy = that.getCenterY()-this.getCenterY();
                float rr = this.getRadius()
                        + ((Ball) that).getRadius();

                if(xx*xx+yy*yy <= rr*rr)
                {
                    this.centerDistanceVector = new Vector(xx,yy);
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override
    public void move()
    {
        this.position.add(this.speed);
    }

    public float getDX()
    {
        return this.speed.getX();
    }

    public float getDY()
    {
        return this.speed.getY();
    }
}
