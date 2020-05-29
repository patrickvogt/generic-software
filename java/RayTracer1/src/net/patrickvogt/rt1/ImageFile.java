package net.patrickvogt.rt1;

import java.io.FileWriter;
import java.io.IOException;

import net.patrickvogt.rt1.util.Pixel;

// Hilfsklasse zum Schreiben von PPM-Bilddateien
public class ImageFile {

	// Bilddatei schreiben
	public static void writeFile(String filename, Pixel[] pix_arr, int col, int rows) throws Exception {
		// Plausibilität prüfen
		if (col * rows != pix_arr.length) {
			throw new Exception("Row/Col does not fit to elements in array");
		}

		try {
			// Datei schreiben / Kopfdaten
			FileWriter myWriter = new FileWriter(filename);
			myWriter.write("P3\n");
			myWriter.write(col + " " + rows + "\n");
			myWriter.write("255\n");

			// Nutzinhalt schreiben
			for (int i = 0; i < pix_arr.length; i++) {
				if (i > 0 && i % col == 0) {
					myWriter.write("\n");
				}
				Pixel p = pix_arr[i];
				myWriter.write(p.toString());
			}

			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred during file saving.");
			e.printStackTrace();
		}
	}
}
