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
		int[] arx = {50,50,120,120,80,80,100,100,80,80};
		int[] ary = {170,40,40,70,70,100,100,130,130,170};
		
		g.setColor(Color.BLUE);
		// g.drawPolyline(arx, ary, arx.length); 		// -> 'F' not finished
		// g.drawPolygon(arx, ary, arx.length); 		// -> 'F' finished
		g.fillPolygon(arx, ary, arx.length);			// -> Filled 'F'
			
	}
	
	public static void main(String[] args) { 
		
		GraphicsTest mainWindow = new GraphicsTest();
	}
	
}
