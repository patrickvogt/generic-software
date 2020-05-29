package net.patrickvogt.rt1;

import net.patrickvogt.rt1.util.Pixel;
import net.patrickvogt.rt1.util.Ray;
import net.patrickvogt.rt1.util.Vector3;

public class Main {

	private static double isSphereHitted(Vector3 center, double radius, Ray r) {
		Vector3 oc = r.getOrigin().getSub(center);
		double a = r.getDirection().length_squared();
		double half_b = oc.getDot(r.getDirection());
		double c = oc.length_squared() - radius * radius;
		double discriminant = half_b * half_b - a * c;
		if (discriminant < 0) {
			return -1.0; // Hintergrund, kein Treffer
		} else {
			return (-half_b - Math.sqrt(discriminant)) / a; // Treffer
		}
	}

	// Farbe für Punkt auf Gerade bestimmen
	private static Vector3 getRayColor(Ray r) {
		// wenn Kugel getroffen wird, dann Farbe der Kugel (hier: je nach Richtung der Normale an dem Punkt) zurückgeben
		double t = Main.isSphereHitted(new Vector3(0.0, 0.0, -1.0), 0.5, r);
		if (t > 0.0) {
			Vector3 N = r.getAt(t).getSub(new Vector3(0.0, 0.0, -1.0)).getUnitVector();
			return new Vector3(N.getX() + 1, N.getY() + 1, N.getZ() + 1).getMultScalar(127.0);
		}

		Vector3 unitDirection = r.getDirection().getUnitVector();
		t = 0.5 * (unitDirection.getY() + 1.0);

		Vector3 white = new Vector3(255.0, 255.0, 255.0);
		Vector3 blueish = new Vector3(127.0, 178.0, 255.0);
		// (1-t)-Prozent an Weiß + t-Prozent an Bläulich
		Vector3 color = white.getMultScalar(1.0 - t).getAdd(blueish.getMultScalar(t));
		return color;
	}

	// Hier geht's los
	public static void main(String[] args) {

		// Seitenverhältnis
		double aspect_ratio = 16.0 / 9.0;
		// Breite fix
		int image_width = 384;
		// Höhe berechnen anhand Breite und Seitenverhältnis
		int image_height = (int) (image_width / aspect_ratio);

		// Array mit Bildpixeln
		Pixel[] pa = new Pixel[image_height * image_width];

		// Bestimmt den Kameraausschnitt (je größer dieser Wert desto mehr können wir
		// nach oben (und unten schauen)
		double viewport_height = 2.0;
		// Breite des Kameraausschnits bestimmen
		double viewport_width = aspect_ratio * viewport_height;
		// Brennweite
		double focal_length = 1.0;

		// Wir liegen parallel zu/auf der Z-Achse und schauen in Richtung -Z
		Vector3 origin = new Vector3(0.0, 0.0, 0.0);
		Vector3 horizontal = new Vector3(viewport_width, 0.0, 0.0);
		Vector3 vertical = new Vector3(0.0, viewport_height, 0.0);

		// Linke untere Ecke vom Kamerausschnitt / der Porjektionsebene bestimmen
		Vector3 lower_left_corner = origin.getSub(horizontal.getDivScalar(2.0)).getSub(vertical.getDivScalar(2.0))
				.getSub(new Vector3(0.0, 0.0, focal_length));
		// Einzelne Schritte, um diese zu verdeutlichen
//	    Vector3 left_edge  = origin.getSub(horizontal.getDivScalar(2.0));
//	    Vector3 left_bottom_point = v1.getSub(vertical.getDivScalar(2.0));
//	    Vector3 lower_left_corner = v2.getSub(new Vector3(0.0,0.0,focal_length));

		// Bild erzeugen (für jedes Pixel einen Strahl "schießen")
		// Beispiel geht mit der y-Achse rückwärts, um die Anzahl der übrigen Bildzeilen
		// auszugeben
		// Damit wir im Ergebnis / Bildarray trotzdem von oben nach unten gehen, müssen
		// wir den Index in der Schleife drehen
		for (int j = image_height - 1; j >= 0; --j) {
			System.out.println("\rScanlines remaining: " + j + " ");
			// Zeile von links nach rechts
			for (int i = 0; i < image_width; ++i) {
				// Gerade für Pixel (u,v) bestimmen
				double u = (double) (i) / (image_width - 1);
				double v = (double) (j) / (image_height - 1);
				// (u=0, v=0) is links unten, (u=1, v=1) is rechts oben, (u=0, v=1) ist links
				// oben, (u=1, v=0) ist rechts unten
				Ray r = new Ray(origin, lower_left_corner
						.getAdd(horizontal.getMultScalar(u).getAdd(vertical.getMultScalar(v).getSub(origin))));
				// Farbe an Pixel holen
				Vector3 pixelColor = Main.getRayColor(r);
				// Pixel merken (für spätere Ausgabe) in PPM-Bilddatei
				pa[((image_height - 1) - j) * image_width + i] = new Pixel(pixelColor);
			}
		}

		try {
			// Bild schreiben
			ImageFile.writeFile("out.ppm", pa, image_width, image_height);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
