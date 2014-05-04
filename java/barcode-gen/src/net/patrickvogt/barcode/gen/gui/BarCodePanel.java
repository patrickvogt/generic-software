package net.patrickvogt.barcode.gen.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BarCodePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 200;
	private static final int HEIGHT = 120;
	
	private int[][] barcode = null;
	private int rows = 0;
	private int cols = 0;

	public BarCodePanel(int[][] barcode, int rows, int cols) {
		this.barcode = barcode;
		this.rows = rows;
		this.cols = cols;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		int length = 0;
		int x = 0;

		for(int i=0; i<rows; i=i+1)
		{
			length = barcode[i][0];
			
			for(int j=1; j<(length+1) && j<cols; j=j+1)
			{
				if(1==barcode[i][j])
				{
					g.fillRect(x, 0, 2, (i==0 || i==7 || i==14) ? HEIGHT : HEIGHT-20);
				}
					
			    x = x + 2;
			}
		}
	}
	
	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(WIDTH, HEIGHT);
	}
}
