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
	private static final int COLS = 14;

	public MainPanel() {
		final JTextField t = new JTextField(MainPanel.COLS);
		t.setText("123456789999");

		this.add(t);

		JButton b = new JButton("Generate");

		this.add(b);

		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (12 == t.getText().trim().length()) {

					int[][] test = BarCodeUtil.generateUPCBarcode(t.getText()
							.trim());

					new MainFrame(new BarCodePanel(test, 15, 8), false)
							.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(MainPanel.this.getParent(), "This is not a valid UPC code");
				}
			}
		});
	}

}
