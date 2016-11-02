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
		Font myFont = new Font("Calibri", Font.BOLD + Font.ITALIC, 32);
		g.setFont(myFont);
		
		g.setColor(Color.lightGray);
		g.drawString("Hello World", 103, 103);
		g.setColor(Color.BLACK);
		g.drawString("Hello World", 100, 100);
	}
	
	public static void main(String[] args) { 
		
		GraphicsTest mainWindow = new GraphicsTest();
	}
	
}
