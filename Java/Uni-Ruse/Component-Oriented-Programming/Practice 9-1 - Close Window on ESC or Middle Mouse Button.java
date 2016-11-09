// Component-Oriented Programming, Practice 9, 09.11.2016 - dvt32

import java.awt.*;
import java.awt.event.*;

public class GraphicsTest extends Frame implements KeyListener {
	
	public GraphicsTest() {
		super("My first window");
		setBackground(Color.lightGray);
		setLocation(200, 100);
		setSize(600, 400);
		addWindowListener(new WindowClosingAdapter());
		addKeyListener(this);
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON2) {
					setVisible(false);
					dispose();
					System.exit(0);
				}
			}
		});
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.drawString("Press ESC to quit.", 50, 50);
	}
	
	public static void main(String[] args) { 
		
		GraphicsTest mainWindow = new GraphicsTest();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {}
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public void keyTyped(KeyEvent arg0) {}
	
}
