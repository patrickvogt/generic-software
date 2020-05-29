package net.patrickvogt.rt1.util;

// Abstrakte Klasse für dreidimensionalen Vektor (braucht es nicht wirklich)
public abstract class AVector3 {

	protected double x = 0.0;
	protected double y = 0.0;
	protected double z = 0.0;

	public AVector3() {
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
	}

	public AVector3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

}
