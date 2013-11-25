package net.patrickvogt.pinkball.vector;

public abstract class Vector
{
    public static final float FLOAT_COMPARE_DELTA = 0.01f;

    protected float x = 0.0f;
    protected float y = 0.0f;

    public Vector(final float _x, final float _y)
    {
        super();
        
        this.x = _x;
        this.y = _y;
    }

    public Vector(final Vector that)
    {
        super();
        
        this.x = that.x;
        this.y = that.y;
    }

    @Override
    public boolean equals(final Object that)
    {
        if(this == that)
        {
            return true;
        }
        else if(that instanceof Vector)
        {
            final Vector v = (Vector) that;

            return this.x > (v.x - Vector.FLOAT_COMPARE_DELTA)
                    && this.x < (v.x + Vector.FLOAT_COMPARE_DELTA)
                    && this.y > (v.y - Vector.FLOAT_COMPARE_DELTA)
                    && this.y < (v.y + Vector.FLOAT_COMPARE_DELTA);
        }
        return false;
    }
    
    public void add(Vector v)
    {
        this.x = this.x + v.x;
        this.y = this.y + v.y;
    }
    
    public void sub(Vector v)
    {
        this.x = this.x - v.x;
        this.y = this.y - v.y;
    }
    
    public float dot(Vector v)
    {
        return this.x * v.x + this.y * v.y;
    }
    
    public void mult(float scalar)
    {
        this.x = scalar * this.x;
        this.y = scalar * this.y;
    }
    
    public void normalize()
    {
        final float v_length = this.length();
        
        this.x = this.x / v_length;
        this.y = this.y / v_length;
    }
    
    public float length()
    {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer();

        sb.append("(");
        sb.append(this.x);
        sb.append(",");
        sb.append(this.y);
        sb.append(")");

        return sb.toString();
    }
}
