/*
 * Created by JFormDesigner on Fri Feb 08 19:38:44 EET 2019
 */

package net.dvt32.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author dvt32
 */
public class MainForm extends JFrame {
	public MainForm() {
		initComponents();
	}

	private void button1MouseClicked(MouseEvent e) {
		PropertyTableForm propertyTableForm = new PropertyTableForm();
		propertyTableForm.setVisible(true);
	}

	private void button2MouseClicked(MouseEvent e) {
		AgencyTableForm agencyTableForm = new AgencyTableForm();
		agencyTableForm.setVisible(true);
	}

	private void button3MouseClicked(MouseEvent e) {
		AgentTableForm agentTableForm = new AgentTableForm();
		agentTableForm.setVisible(true);
	}

	private void button4MouseClicked(MouseEvent e) {
		ListingTableForm listingTableForm = new ListingTableForm();
		listingTableForm.setVisible(true);
	}

	private void button5MouseClicked(MouseEvent e) {
		BuyerTableForm buyerTableForm = new BuyerTableForm();
		buyerTableForm.setVisible(true);
	}

	private void button6MouseClicked(MouseEvent e) {
		WorksWithTableForm worksWithTableForm = new WorksWithTableForm();
		worksWithTableForm.setVisible(true);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - MilenV
		label1 = new JLabel();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		button6 = new JButton();

		//======== this ========
		setTitle("Real Estate DB Manager (dvt32, 186402, \u0421\u0418)");
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0};
		((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};
		((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 0.0, 1.0E-4};

		//---- label1 ----
		label1.setText("All Tables");
		contentPane.add(label1, new GridBagConstraints(0, 0, 7, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 0, 0), 0, 0));

		//---- button1 ----
		button1.setText("Property");
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				button1MouseClicked(e);
			}
		});
		contentPane.add(button1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 0, 0));

		//---- button2 ----
		button2.setText("Agency");
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				button2MouseClicked(e);
			}
		});
		contentPane.add(button2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 0, 0));

		//---- button3 ----
		button3.setText("Agent");
		button3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				button3MouseClicked(e);
			}
		});
		contentPane.add(button3, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 0, 0));

		//---- button4 ----
		button4.setText("Listing");
		button4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				button4MouseClicked(e);
			}
		});
		contentPane.add(button4, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 0, 0));

		//---- button5 ----
		button5.setText("Buyer");
		button5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				button5MouseClicked(e);
			}
		});
		contentPane.add(button5, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 0, 0));

		//---- button6 ----
		button6.setText("Works_With");
		button6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				button6MouseClicked(e);
			}
		});
		contentPane.add(button6, new GridBagConstraints(5, 1, 2, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 0, 0));
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - MilenV
	private JLabel label1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
