package net.patrickvogt.pinkball.vector;

public final class Dimension2D extends Vector
{
    public Dimension2D(final float _width, final float _height)
    {
        super(_width, _height);
    }

    public Dimension2D(final Vector that)
    {
        super(that);
    }

    public final float getWidth()
    {
        return this.x;
    }

    public final int getWidthAsInt()
    {
        return (int) this.x;
    }

    public final void setWidth(final float _width)
    {
        this.x = _width;
    }

    public final float getHeight()
    {
        return this.y;
    }

    public final int getHeightAsInt()
    {
        return (int) this.y;
    }

    public final void setHeight(final float _height)
    {
        this.y = _height;
    }

    @Override
    public final boolean equals(final Object that)
    {
        if(this == that)
        {
            return true;
        }
        else if(that instanceof Dimension2D)
        {
            return super.equals(that);
        }
        return false;
    }

    @Override
    public final String toString()
    {
        final StringBuffer sb = new StringBuffer();

        sb.append("d");
        sb.append(super.toString());

        return sb.toString();
    }

}
