package net.patrickvogt.barcode.gen.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import net.patrickvogt.barcode.gen.logic.BarCodeUtil;

public class BarCodePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	// width of the barcode panel
	private static final int WIDTH = 210;
	// height of the barcode panel
	private static final int HEIGHT = 120;
	// the initial offset in X dimension
	private static final int INITIAL_X = 10;
	// width of a single stripe
	private static final int BARCODE_UNIT_WIDTH = 2;

	// the acutal barcode matrix
	private int[][] barcode = null;
	// the number of rows ('barcode digits' with start middle and end)
	private int rows = 0;
	// number of columns (max bits of barcode digits + 1 (for length field)
	private int cols = 0;

	public BarCodePanel(int[][] barcode, int rows, int cols) {
		this.barcode = barcode;
		this.rows = rows;
		this.cols = cols;
	}

	// paint the barcode
	@Override
	public void paintComponent(Graphics g) {
		int length = 0;
		int x = BarCodePanel.INITIAL_X;
		
		// white background for better contrast
		g.setColor(Color.white);
		g.fillRect(0, 0, BarCodePanel.WIDTH, BarCodePanel.HEIGHT);

		// the black stripes of the barcode
		g.setColor(Color.black);

		// for every barcode digits
		for (int i = 0; i < this.rows; i = i + 1) {
			// get the length for this barcode digit (stored in column 0 of every row)
			length = this.barcode[i][0];

			// for every bit (every possible stripe)
			for (int j = 1; j < (length + 1) && j < this.cols; j = j + 1) {
				//check if a stripe should be drawn
				if (1 == this.barcode[i][j]) {
					// yes => draw a smal rectangle
					g.fillRect(x, 0, BarCodePanel.BARCODE_UNIT_WIDTH, 
							BarCodeUtil.isUPCPositionADataDigit(i) ? BarCodePanel.HEIGHT-(BarCodePanel.HEIGHT/10) : BarCodePanel.HEIGHT);
				}

				x = x + BarCodePanel.BARCODE_UNIT_WIDTH;
			}
		}
	}

	// return the size of the panel
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT);
	}
}
