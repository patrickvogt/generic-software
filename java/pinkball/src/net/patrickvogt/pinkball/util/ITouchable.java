package net.patrickvogt.pinkball.util;

import net.patrickvogt.pinkball.excpetion.GameOverException;
import net.patrickvogt.pinkball.geom.GeometricObject;

public interface ITouchable
{
    public boolean touches(final GeometricObject __that);
    public GeometricObject handleCollision(final GeometricObject __that) throws GameOverException;
}
