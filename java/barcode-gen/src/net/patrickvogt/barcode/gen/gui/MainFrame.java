package net.patrickvogt.barcode.gen.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	// the title of the frame
	private static final String TITLE = "That Farkakte Barcode Generator";
	
	public MainFrame(JPanel p, boolean exitOnClose)
	{
		super(MainFrame.TITLE);

		// not resizable
		this.setResizable(false);
		
		// set close operation if needed
		if(exitOnClose)
		{
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		// add the panel
		this.add(p);
		
		// and adjust the size of the frame (based on the contents [here: the given panel])
		this.pack();
	}
	
}
