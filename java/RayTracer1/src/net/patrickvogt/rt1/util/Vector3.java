package net.patrickvogt.rt1.util;

// reeler dreidimensionaler Vektor
public class Vector3 extends AVector3 {

	// Ursprungspvektor/"leeren" Vektor erzeugen
	public Vector3() {

	}

	// neuen Vekor (x,y,z) erzeugen
	public Vector3(double x, double y, double z) {
		super(x, y, z);
	}

	// Kopie von Vektor erzeugen
	public Vector3(Vector3 other) {
		this.x = other.x;
		this.y = other.y;
		this.z = other.z;
	}

	// x-Komponente holen
	public double getX() {
		return this.x;
	}

	// y-Komponente holen
	public double getY() {
		return this.y;
	}

	// z-Komponente holen
	public double getZ() {
		return this.z;
	}

	// Vektor negieren / Richtung drehen
	public Vector3 neg() {
		return new Vector3(-x, -y, -z);
	}

	// Vektoraddition v = v + u (Ergebnis steht im this-Vektor);
	public void add(Vector3 other) {
		this.x = this.x + other.x;
		this.y = this.y + other.y;
		this.z = this.z + other.z;
	}

	// Vektoraddition
	public Vector3 getAdd(Vector3 other) {
		return new Vector3(this.x + other.x, this.y + other.y, this.z + other.z);
	}

	// Vektorsubtraktion (als Reduktion auf Vektoraddition mit -other)
	public Vector3 getSub(Vector3 other) {
		return this.getAdd(new Vector3(other).neg());
	}

	// Multiplikation
	public Vector3 getMult(Vector3 other) {
		return new Vector3(this.x * other.x, this.y * other.y, this.z * other.z);
	}

	// Multiplikation mit Skalar (Ergebnis als Kopie)
	public Vector3 getMultScalar(double a) {
		return new Vector3(this.x * a, this.y * a, this.z * a);
	}

	// Division mit Skalar (Ergebnis als Kopie) (als Reduktion auf Multplikation mit
	// Skalar 1/a)
	public Vector3 getDivScalar(double a) {
		return this.getMultScalar(1 / a);
	}

	// Skalarprodukt
	public double getDot(Vector3 other) {
		return this.x * other.x + this.y * other.y + this.z * other.z;
	}

	// Kreuzprodukt (Ergebnis als Kopie)
	public Vector3 getCross(Vector3 other) {
		return new Vector3(this.y * other.z - this.z * other.y, this.z * other.x - this.x * other.z,
				this.x * other.y - this.y * other.x);
	}

	// Einheitsvektor aus this-Vektor machen (Ergebnis als Kopie)
	public Vector3 getUnitVector() {
		return this.getDivScalar(this.length());
	}

	// Multiplikation mit Skalar (Ergebnis steht im this-Vektor)
	public void multScalar(double a) {
		this.x = a * this.x;
		this.y = a * this.y;
		this.z = a * this.z;
	}

	// Division mit Skalar (Ergebnis steht im this-Vektor) (als Reduktion auf
	// Multiplikation mit Skalar 1/a)
	public void divScalar(double a) {
		this.multScalar(1 / a);
	}

	// gibt die Länge des Vektors zurück
	public double length() {
		return Math.sqrt(this.length_squared());
	}

	// gibt x^2 + y^2 +z^2 zurück
	public double length_squared() {
		return this.x * this.x + this.y * this.y + this.z * this.z;
	}

	// holen der Komponente über Abbildung i=0 => x, i=1 => y, i=2 => z
	public double get(int i) throws Exception {
		if (i < 0 || i > 2) {
			throw new Exception("i<0 or i>2");
		}

		switch (i) {
		case 0:
			return this.x;
		case 1:
			return this.y;
		case 2:
			return this.z;
		}
		return 0.0;
	}

	// Vektor für Ausgabe vorbereiten
	@Override
	public String toString() {
		return this.x + " " + this.y + " " + this.z + " ";
	}

}
