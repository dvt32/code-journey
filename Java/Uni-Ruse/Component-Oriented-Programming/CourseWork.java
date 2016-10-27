/*
 * 2.3. Да се състави Applet или Application на Java, имащ следната функционалност
 * 
 * - дава възможност за поставяне на точки с помощта на мишката 
 * 		(щракване с левия бутон, точката е окръжност с радиус 5 пиксела).
 * - точките трябва да могат да се поставят 
 *   	САМО ако въпросната малка окръжност (точката) се съдържа изцяло в някой от четирите квадранта. 
 * 
 *  Във всеки квадрант точката се изчертава с отделен цвят.
 *  
 */

import java.awt.*;
import java.awt.event.*;

public class CourseWork extends Frame {
	
	public static final int RADIUS_OF_CIRCLE = 5;
	public static int mouseX;
	public static int mouseY;
	
	public CourseWork() {
		super("COP Course Work #2 - dvt32, 146518 - 2.3 Circles");
		setSize(1024, 768);
		setBackground(Color.decode("#89cff0"));
		addWindowListener(new WindowClosingAdapter());
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
				repaint();
			}
		});
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		int circleStartX = mouseX - RADIUS_OF_CIRCLE;
		int circleStartY = mouseY - RADIUS_OF_CIRCLE;
		int circleWidth = 2 * RADIUS_OF_CIRCLE;
		int circleHeight = 2 * RADIUS_OF_CIRCLE;
		int circleEndX = circleStartX + circleWidth;
		int circleEndY = circleStartY + circleHeight;

		int minX = getInsets().left;
		int minY = getInsets().top;
		int maxX = getSize().width - getInsets().right;
		int maxY = getSize().height - getInsets().bottom;
		
		// TO-DO: Implement color detection, based on point location
		
		g.setColor(Color.RED);
		
		if (circleStartX >= minX && 
			circleStartY >= minY && 
			circleEndX <= maxX &&
			circleEndY <= maxY) 
		{
			g.drawOval(circleStartX, circleStartY, circleWidth, circleHeight);
		}
	}
	
	public static void main(String[] args) {

		CourseWork mainWindow = new CourseWork();
	}

}
