package net.patrickvogt.pinkball.vector;

public final class Vector
{
    public static final float FLOAT_COMPARE_DELTA = 0.01f;

    protected float _x = 0.0f;
    protected float _y = 0.0f;

    public Vector(final float __x, final float __y)
    {
        super();

        this._x = __x;
        this._y = __y;
    }

    public Vector(final Vector __that)
    {
        super();

        this._x = __that._x;
        this._y = __that._y;
    }

    public final float getX()
    {
        return this._x;
    }
    
    public final int getXAsInt()
    {
        return (int) this._x;
    }

    public final float getY()
    {
        return this._y;
    }

    public final int getYAsInt()
    {
        return (int) this._y;
    }

    @Override
    public final boolean equals(final Object __that)
    {
        if(this == __that)
        {
            return true;
        }
        else if(__that instanceof Vector)
        {
            final Vector v = (Vector) __that;

            return this._x > (v._x - Vector.FLOAT_COMPARE_DELTA)
                    && this._x < (v._x + Vector.FLOAT_COMPARE_DELTA)
                    && this._y > (v._y - Vector.FLOAT_COMPARE_DELTA)
                    && this._y < (v._y + Vector.FLOAT_COMPARE_DELTA);
        }
        return false;
    }

    @Override
    public final String toString()
    {
        final StringBuffer sb = new StringBuffer();

        sb.append("(");
        sb.append(this._x);
        sb.append(",");
        sb.append(this._y);
        sb.append(")");

        return sb.toString();
    }

    public final float getLength()
    {
        return (float) Math.sqrt(this._x * this._x + this._y * this._y);
    }

    public final void setLength(final float __length)
    {
        this.normalize();
        this.mult(__length);
    }

    public final void normalize()
    {
        final float this_length = this.getLength();

        this._x = this._x / this_length;
        this._y = this._y / this_length;
    }
    
    public final void invertX()
    {
        this._x = -this._x;
    }
    
    public final void invertY()
    {
        this._y = -this._y;
    }
    
    public final void invertAll()
    {
        this.invertX();
        this.invertY();
    }

    public final void add(final Vector __v)
    {
        this._x = this._x + __v._x;
        this._y = this._y + __v._y;
    }

    public final void sub(Vector __v)
    {
        this._x = this._x - __v._x;
        this._y = this._y - __v._y;
    }

    public final float dot(Vector __v)
    {
        return this._x * __v._x + this._y * __v._y;
    }

    public final void mult(float __factor)
    {
        this._x = __factor * this._x;
        this._y = __factor * this._y;
    }
}
