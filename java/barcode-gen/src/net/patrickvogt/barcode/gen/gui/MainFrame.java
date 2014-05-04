package net.patrickvogt.barcode.gen.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MainFrame(JPanel p, boolean exitOnClose)
	{
		super("That Farkakte Barcode Generator");
		
		this.setResizable(false);
		
		if(exitOnClose)
		{
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		this.add(p);
		
		this.pack();
	}
	

	
}
