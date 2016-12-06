import java.awt.*;
import java.awt.event.*;

public class Solution extends Frame {
	
	public static int mouseX;
	public static int mouseY;
	public static int mousePressCount = 0;
	public static int lineStartX;
	public static int lineStartY;
	public static int lineEndX;
	public static int lineEndY;
	
	public Solution() {
		super("COP - dvt32, 146518 - Lines");
		setSize(1024, 768);
		setBackground(Color.decode("#89cff0"));
		addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent we) {
	            dispose();
	         }
	     }
		);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
				mousePressCount++;
				if (mousePressCount % 2 != 0) {
					lineStartX = mouseX;
					lineStartY = mouseY;
				}
				else {
					lineEndX = mouseX;
					lineEndY = mouseY;
					repaint();
				}
			}
		});
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		if (lineStartX != lineEndX && lineStartY != lineEndY) {
			g.drawLine(lineStartX, lineStartY, lineEndX, lineEndY);
		}
	}
	
	public static void main(String[] args) {
		Solution mainWindow = new Solution();
	}

}
