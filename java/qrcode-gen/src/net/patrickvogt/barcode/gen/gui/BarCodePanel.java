package net.patrickvogt.barcode.gen.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import net.patrickvogt.barcode.gen.logic.BarCodeUtil;

public class BarCodePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	// width of the barcode panel
	private static final int WIDTH = 800;
	// height of the barcode panel
	private static final int HEIGHT = 600;
	// the initial offset in X dimension
	private static final int INITIAL_X = 10;
	// width of a single stripe
	private static final int MODULE_UNIT_WIDTH = 10;

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

	// paints the finder pattern onto the point (x,y) [left top corner] onto the given graphics context
	private void paintFinderPattern(Graphics g, int x, int y)
	{
		g.setColor(Color.white);
		g.fillRect((x-1)*BarCodePanel.MODULE_UNIT_WIDTH, (y-1)*BarCodePanel.MODULE_UNIT_WIDTH, 9*BarCodePanel.MODULE_UNIT_WIDTH, 9*BarCodePanel.MODULE_UNIT_WIDTH);
		
		g.setColor(Color.black);
		g.fillRect(x*BarCodePanel.MODULE_UNIT_WIDTH, y*BarCodePanel.MODULE_UNIT_WIDTH, 7*BarCodePanel.MODULE_UNIT_WIDTH, 7*BarCodePanel.MODULE_UNIT_WIDTH);
		
		g.setColor(Color.white);
		g.fillRect(x*BarCodePanel.MODULE_UNIT_WIDTH+BarCodePanel.MODULE_UNIT_WIDTH, y*BarCodePanel.MODULE_UNIT_WIDTH+BarCodePanel.MODULE_UNIT_WIDTH, 5*BarCodePanel.MODULE_UNIT_WIDTH, 5*BarCodePanel.MODULE_UNIT_WIDTH);
		
		g.setColor(Color.black);
		g.fillRect(x*BarCodePanel.MODULE_UNIT_WIDTH+2*BarCodePanel.MODULE_UNIT_WIDTH, y*BarCodePanel.MODULE_UNIT_WIDTH+2*BarCodePanel.MODULE_UNIT_WIDTH, 3*BarCodePanel.MODULE_UNIT_WIDTH, 3*BarCodePanel.MODULE_UNIT_WIDTH);
		
	}
	
	// paints the finder pattern onto the point (x,y) [left top corner] onto the given graphics context
		private void paintAlignmentPattern(Graphics g, int x, int y)
		{
			g.setColor(Color.black);
			g.fillRect(x*BarCodePanel.MODULE_UNIT_WIDTH, y*BarCodePanel.MODULE_UNIT_WIDTH, 5*BarCodePanel.MODULE_UNIT_WIDTH, 5*BarCodePanel.MODULE_UNIT_WIDTH);
			
			g.setColor(Color.white);
			g.fillRect(x*BarCodePanel.MODULE_UNIT_WIDTH+BarCodePanel.MODULE_UNIT_WIDTH, y*BarCodePanel.MODULE_UNIT_WIDTH+BarCodePanel.MODULE_UNIT_WIDTH, 3*BarCodePanel.MODULE_UNIT_WIDTH, 3*BarCodePanel.MODULE_UNIT_WIDTH);
			
			g.setColor(Color.black);
			g.fillRect(x*BarCodePanel.MODULE_UNIT_WIDTH+2*BarCodePanel.MODULE_UNIT_WIDTH, y*BarCodePanel.MODULE_UNIT_WIDTH+2*BarCodePanel.MODULE_UNIT_WIDTH, 1*BarCodePanel.MODULE_UNIT_WIDTH, 1*BarCodePanel.MODULE_UNIT_WIDTH);
			
		}
	
	private void paintTiming(Graphics g)
	{
		for(int i=0; i<11; i=i+1)
		{
			g.setColor((0==i%2)?Color.black:Color.white);
			g.fillRect((6+i)*BarCodePanel.MODULE_UNIT_WIDTH, 6*BarCodePanel.MODULE_UNIT_WIDTH, BarCodePanel.MODULE_UNIT_WIDTH, BarCodePanel.MODULE_UNIT_WIDTH);
		}
		
		for(int i=0; i<11; i=i+1)
		{
			g.setColor((0==i%2)?Color.black:Color.white);
			g.fillRect(6*BarCodePanel.MODULE_UNIT_WIDTH, (6+i)*BarCodePanel.MODULE_UNIT_WIDTH, BarCodePanel.MODULE_UNIT_WIDTH, BarCodePanel.MODULE_UNIT_WIDTH);
		}
	}
	
	// paint the barcode
	@Override
	public void paintComponent(Graphics g) {
//		int length = 0;
//		int x = BarCodePanel.INITIAL_X;
//		
//		// white background for better contrast
//		g.setColor(Color.white);
//		g.fillRect(0, 0, BarCodePanel.WIDTH, BarCodePanel.HEIGHT);
//
//		// the black stripes of the barcode
//		g.setColor(Color.black);
//
//		// for every barcode digits
//		for (int i = 0; i < this.rows; i = i + 1) {
//			// get the length for this barcode digit (stored in column 0 of every row)
//			length = this.barcode[i][0];
//
//			// for every bit (every possible stripe)
//			for (int j = 1; j < (length + 1) && j < this.cols; j = j + 1) {
//				//check if a stripe should be drawn
//				if (1 == this.barcode[i][j]) {
//					// yes => draw a smal rectangle
//					g.fillRect(x, 0, BarCodePanel.BARCODE_UNIT_WIDTH, 
//							BarCodeUtil.isUPCPositionADataDigit(i) ? BarCodePanel.HEIGHT-(BarCodePanel.HEIGHT/10) : BarCodePanel.HEIGHT);
//				}
//
//				x = x + BarCodePanel.BARCODE_UNIT_WIDTH;
//			}
//		}
		
		this.paintTest(g);
		this.paintFinderPattern(g, 0, 0);
		this.paintFinderPattern(g, 0, 18);
		this.paintFinderPattern(g, 18, 0);
		this.paintAlignmentPattern(g, 16, 16);
		this.paintTiming(g);
	}

	private void paintTest(Graphics g) {
		String s = "abc";
		char c = 0;
		int bit = 0;
		
		int x=24;
		int y=21;

		for(int i=0; i<s.length(); i=i+1)
		{
			c = s.charAt(i);
			
			if(0==i%2)
			{
				//upwards
				for(int j=0; j<8; j=j+1)
				{
					bit = (c >> j) & 1;
					
					if(1==bit)
					{
						g.setColor(Color.black);
					}
					else
					{
						g.setColor(Color.white);
					}
					
					g.fillRect((x+j%2)*MODULE_UNIT_WIDTH, (y+j/2)*MODULE_UNIT_WIDTH, 1*MODULE_UNIT_WIDTH, 1*MODULE_UNIT_WIDTH);
				}
			}
			else
			{
				//downwards
				for(int j=7; j>=0; j=j-1)
				{
					bit = (c >> j) & 1;
					
					if(1==bit)
					{
						g.setColor(Color.black);
					}
					else
					{
						g.setColor(Color.white);
					}
					
					g.fillRect((x+j%2)*MODULE_UNIT_WIDTH, (y+3-j/2)*MODULE_UNIT_WIDTH, 1*MODULE_UNIT_WIDTH, 1*MODULE_UNIT_WIDTH);
				}
			}
			
			y = y-4;
		}
	}

	// return the size of the panel
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT);
	}
}
