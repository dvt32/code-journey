// Component-Oriented Programming, Practice 8, 02.11.2016 - dvt32

import java.awt.*;

public class GraphicsTest extends Frame {
	
	public GraphicsTest() {
		super("My first window");
		setBackground(Color.WHITE);
		setLocation(200, 100);
		setSize(600, 400);
		addWindowListener(new WindowClosingAdapter());
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] availableFonts = ge.getAvailableFontFamilyNames();
		
		for (int i = 0; i < availableFonts.length; ++i) {
			Font myFont = new Font(availableFonts[i], Font.PLAIN, 36) ;
			g.setFont(myFont) ;
			g.drawString(availableFonts[i], 10, (i+1)*(36+5));
		}
	}
	
	public static void main(String[] args) { 
		
		GraphicsTest mainWindow = new GraphicsTest();
	}
	
}
