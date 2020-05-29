package net.patrickvogt.rt1.util;

// Pixel (wir mißbrauchen einen reelen dreidimensionalen Vektor als Pixel mit ganzzahligen (r,g,b)-Tripel)
public class Pixel extends AVector3 {

	// Pixel mit (r,g,b) erzeugen
	public Pixel(int r, int g, int b) {
		super(r, g, b);
	}

	// Kopie von Vector3 als Pixel erzeugen
	public Pixel(Vector3 other) {
		super(other.getX(), other.getY(), other.getZ());
	}

	// Rotabnteil holen
	public int getR() {
		return (int) x;
	}

	// Grünanteil holen
	public int getG() {
		return (int) y;
	}

	// Blauanteil holen
	public int getB() {
		return (int) z;
	}

	// Pixel ausgeben (für PPM-Datei)
	@Override
	public String toString() {
		return (int) this.x + " " + (int) this.y + " " + (int) this.z + " ";
	}
}
