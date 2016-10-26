// Component-Oriented Programming, Practice 7, 26.10.2016 - dvt32

import java.awt.*;

public class GraphicsTest extends Frame {
	
	public GraphicsTest() {
		super("My first window");
		setBackground(Color.lightGray);
		setLocation(200, 100);
		setSize(600, 400);
		addWindowListener(new WindowClosingAdapter());
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		//g.setColor(Color.YELLOW);
		//g.drawRoundRect(50, 50, 100, 100, 50, 50);
		
		g.setColor(Color.RED);
		g.fillRect(50, 50, 100, 100);
		g.setColor(Color.YELLOW);
		g.fillRect(55, 55, 90, 90);
			
	}
	
	public static void main(String[] args) { 
		
		GraphicsTest mainWindow = new GraphicsTest();
	}
	
}
