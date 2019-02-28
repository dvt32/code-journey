package net.dvt32;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import net.dvt32.gui.MainForm;

public class Application {

	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	MainForm frame = new MainForm();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setVisible(true);
            }
        });
	}

}