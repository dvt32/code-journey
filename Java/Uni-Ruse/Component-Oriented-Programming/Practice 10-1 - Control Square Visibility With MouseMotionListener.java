// Component-Oriented Programming, Practice 10, 16.11.2016 - dvt32

import java.awt.*;
import java.awt.event.*;

public class GraphicsTest extends Frame implements MouseMotionListener {
	
	int upperLeftX = 100;
	int upperLeftY = 100;
	int widthOfRectangle = 200;
	int heightOfRectangle = 200;
	int lowerRightX = widthOfRectangle + upperLeftX;
	int lowerRightY = widthOfRectangle + upperLeftY;
	
	boolean squareShouldBeVisible = true;

	public GraphicsTest() {
		super("My first window");
		setBackground(Color.lightGray);
		setLocation(200, 100);
		setSize(600, 400);
		addWindowListener(new WindowClosingAdapter());
		addMouseMotionListener(this);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		if (squareShouldBeVisible) {
			g.setColor(Color.RED);
			g.fillRect(upperLeftX, upperLeftY, widthOfRectangle, heightOfRectangle);
		}
	}
	
	public static void main(String[] args) { 
		GraphicsTest mainWindow = new GraphicsTest();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {}
	@Override
	public void mouseMoved(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		if (mouseX >= upperLeftX && mouseX <= lowerRightX && 
			mouseY >= upperLeftY && mouseY <= lowerRightY) 
		{
			squareShouldBeVisible = false;
			repaint();
		}
		else if (!squareShouldBeVisible) {
			squareShouldBeVisible = true;
			repaint();
		}
	}
  
}
