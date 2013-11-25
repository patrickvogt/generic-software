package net.patrickvogt.pinkball.util;

import net.patrickvogt.pinkball.geom.GeometricObject;

public interface Touchable {

	public boolean touches(final GeometricObject that);
}
