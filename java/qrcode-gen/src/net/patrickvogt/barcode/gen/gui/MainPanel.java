package net.patrickvogt.barcode.gen.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.patrickvogt.barcode.gen.logic.BarCodeUtil;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	// number of digits within the text field
	private static final int COLS = 12;
	// UPC code example
	private static final String UPC_EXAMPLE = "123456789999";
	// Button string
	private static final String BUTTON_LABEL = "Generate";
	// Not valid UPC code message
	private static final String NOT_VALID_UPC = "This is not a valid UPC code";
	// UPC code length
	private static final int UPC_CODE_LENGTH = 12;
	// barcode digits (including start, middle and end 'digit')
	private static final int UPC_BARCODE_DIGITS = 15;
	// (max bits of a barcode digit) + 1 (for the length field in the barcode matrix)
	private static final int MAX_COLS_IN_BARCODE_MATRIX = 8;

	public MainPanel() {
		// create a textfield, give an UPC code example and add to panel
		final JTextField t = new JTextField(MainPanel.COLS);
		t.setText(MainPanel.UPC_EXAMPLE);
		this.add(t);

		// create Button, add to panel and add action listener
		JButton b = new JButton(MainPanel.BUTTON_LABEL);
		this.add(b);
		b.addActionListener(new ActionListener() {

			// Callback for button click
			@Override
			public void actionPerformed(ActionEvent e) {
				// check if code length is valid
				String trimmedInput = t.getText().trim();
				
				if (MainPanel.UPC_CODE_LENGTH == trimmedInput.length()) {

					// get the barcode matrix
					int[][] barcodeMatrix = BarCodeUtil.generateUPCBarcode(trimmedInput);
					
					// and show it in a new frame as scannable barcode 
					// as second frame (can be closed without program termination)
					new MainFrame(new BarCodePanel(barcodeMatrix, MainPanel.UPC_BARCODE_DIGITS, 
							MainPanel.MAX_COLS_IN_BARCODE_MATRIX), false).setVisible(true);
				}
				else
				{
					// show that UPC code is not valid
					JOptionPane.showMessageDialog(MainPanel.this.getParent(), MainPanel.NOT_VALID_UPC);
				}
			}
		});
	}

}
