// Component-Oriented Programming, Practice 7, 26.10.2016 - dvt32

// AWT Frame

import java.awt.*;

public class Solution {
	
	public static void main(String[] args) { 
		
		Frame mainWindow = new Frame("My first window");
		mainWindow.setBackground(Color.yellow);
		mainWindow.setSize(300, 400);
		mainWindow.addWindowListener(new WindowClosingAdapter());
		mainWindow.setVisible(true);
		
		Frame secondWindow = new Frame("My second window");
		secondWindow.setBackground(Color.lightGray);
		secondWindow.setSize(400, 200);
		secondWindow.addWindowListener(new WindowClosingAdapter());
		secondWindow.setLocation(200, 100);
		secondWindow.setVisible(true);
	}
	
}
