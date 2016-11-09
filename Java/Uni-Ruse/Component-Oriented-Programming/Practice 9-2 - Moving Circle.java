// Component-Oriented Programming, Practice 9, 09.11.2016 - dvt32

import java.awt.*;
import java.awt.event.*;

public class GraphicsTest extends Frame implements KeyListener {
	
	public static int x = 100, y = 100;
	
	public GraphicsTest() {
		super("My first window");
		setBackground(Color.lightGray);
		setLocation(200, 100);
		setSize(600, 400);
		addWindowListener(new WindowClosingAdapter());
		addKeyListener(this);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.drawString("Press ESC to quit.", 50, 50);
		g.fillOval(x, y, 50, 50);
	}
	
	public static void main(String[] args) { 
		GraphicsTest mainWindow = new GraphicsTest();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			y -= 10;
			break;
		case KeyEvent.VK_DOWN:
			y += 10;
			break;
		case KeyEvent.VK_LEFT:
			x -= 10;
			break;
		case KeyEvent.VK_RIGHT:
			x += 10;
			break;
		default:
			break;
		}
		repaint();
	}
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public void keyTyped(KeyEvent arg0) {}
	
}
