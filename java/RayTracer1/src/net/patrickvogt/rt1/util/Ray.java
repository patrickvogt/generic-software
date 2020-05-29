package net.patrickvogt.rt1.util;

// Gerade
public class Ray {

	// Ortsvektor
	protected Vector3 origin = null;
	// Richtungsvektor
	protected Vector3 direction = null;

	// "Leere" Gerade erzeugen
	public Ray() {
		this.origin = new Vector3();
		this.direction = new Vector3();
	}

	// Gerade erzeugen
	public Ray(Vector3 origin, Vector3 direction) {
		this.origin = origin;
		this.direction = direction;
	}

	// Ortsvektor holen
	public Vector3 getOrigin() {
		return this.origin;
	}

	// Richtungsvektor holen
	public Vector3 getDirection() {
		return this.direction;
	}

	// Punkt v auf Gerade mit Parameter a (v = Ortsvektor + a*Richtungsvektor)
	public Vector3 getAt(double a) {
		return this.origin.getAdd(direction.getMultScalar(a));
	}
}
