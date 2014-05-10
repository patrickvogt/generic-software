package net.patrickvogt.barcode.gen.main;

import net.patrickvogt.barcode.gen.gui.MainFrame;
import net.patrickvogt.barcode.gen.gui.MainPanel;

public class Main {
	
	public static void main(String[] args) {
		// open the MainFrame with the InputPanel and the ExitOnClose flag
		new MainFrame(new MainPanel(), true).setVisible(true);
	}
	
}
