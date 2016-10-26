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
		
		int[] arx = {150,175,200,150};
		int[] ary = {100,150,100,100};
		
		g.setClip(50,50,150,80);
		
		//---J
		g.fillRect(70,40,20,80);
		g.fillArc(30,90,60,60,225,180);
		
	}
	
	public static void main(String[] args) { 
		
		GraphicsTest mainWindow = new GraphicsTest();
	}
	
}
