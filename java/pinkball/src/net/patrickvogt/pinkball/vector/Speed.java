package net.patrickvogt.pinkball.vector;

public final class Speed extends Vector
{
    public Speed(final float _dX, final float _dY)
    {
        super(_dX, _dY);
    }

    public Speed(final Vector that)
    {
        super(that);
    }

    public final float getDX()
    {
        return this.x;
    }

    public final void setDX(final float _dX)
    {
        this.x = _dX;
    }

    public final float getDY()
    {
        return this.y;
    }

    public final void setDY(final float _dY)
    {
        this.y = _dY;
    }

    @Override
    public final boolean equals(final Object that)
    {
        if(this == that)
        {
            return true;
        }
        else if(that instanceof Speed)
        {
            return super.equals(that);
        }
        return false;
    }

    @Override
    public final String toString()
    {
        final StringBuffer sb = new StringBuffer();

        sb.append("s");
        sb.append(super.toString());

        return sb.toString();
    }
}
