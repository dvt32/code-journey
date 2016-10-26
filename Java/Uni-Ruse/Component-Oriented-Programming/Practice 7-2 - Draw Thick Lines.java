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
		g.setColor(Color.RED);
		g.drawString("I'm writing Strings like a pro!", 100, 50);
		g.setColor(Color.GREEN);
		g.drawString("And check out the green!", 50, 50);
		
		// Draw a line and make it thick
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		g2.setStroke(new BasicStroke(3));
		g2.drawLine(100, 100, 200, 200);
		
		// Alternative achieve the same effect by drawing a few parallel lines
		for (int i = 0; i < 5; ++i) {
			g.drawLine(250+(i+1), 150, 350+(i+1), 400);
		}
	}
	
	public static void main(String[] args) { 
		
		GraphicsTest mainWindow = new GraphicsTest();
	}
	
}
