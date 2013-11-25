package net.patrickvogt.pinkball.vector;

public final class Coordinate extends Vector
{
    public Coordinate(final float _x, final float _y)
    {
        super(_x, _y);
    }

    public Coordinate(final Vector that)
    {
        super(that);
    }

    public final float getX()
    {
        return this.x;
    }

    public final int getXAsInt()
    {
        return (int) this.x;
    }

    public final void setX(final float _x)
    {
        this.x = _x;
    }

    public final float getY()
    {
        return this.y;
    }

    public final int getYAsInt()
    {
        return (int) this.y;
    }

    public final void setY(final float _y)
    {
        this.y = _y;
    }

    public final void move(final Coordinate that)
    {
        this.x = this.x + that.x;
        this.y = this.y + that.y;
    }

    public final Coordinate moveAsCopy(final Coordinate that)
    {
        return new Coordinate(this.x + that.x, this.y + that.y);
    }

    @Override
    public final boolean equals(final Object that)
    {
        if(this == that)
        {
            return true;
        }
        else if(that instanceof Coordinate)
        {
            return super.equals(that);
        }
        return false;
    }

    @Override
    public final String toString()
    {
        final StringBuffer sb = new StringBuffer();

        sb.append("c");
        sb.append(super.toString());

        return sb.toString();
    }

}
