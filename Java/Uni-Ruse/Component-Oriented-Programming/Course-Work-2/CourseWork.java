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
	public enum Quadrant {
		FIRST, SECOND, THIRD, FOURTH, UNDEFINED
	}
	
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
		final int WINDOW_MIN_X = getInsets().left;
		final int WINDOW_MIN_Y = getInsets().top;
		final int WINDOW_MAX_X = getSize().width - getInsets().right;
		final int WINDOW_MAX_Y = getSize().height - getInsets().bottom;

		// Draw horizontal line
		int horizontalLineStartX = WINDOW_MIN_X;
		int horizontalLineStartY = WINDOW_MAX_Y / 2;
		int horizontalLineEndX = WINDOW_MAX_X;
		int horizontalLineEndY = WINDOW_MAX_Y / 2;
		g.drawLine(horizontalLineStartX, horizontalLineStartY, horizontalLineEndX, horizontalLineEndY);
		
		// Draw vertical line
		int verticalLineStartX = WINDOW_MAX_X / 2;
		int verticalLineStartY = WINDOW_MIN_Y;
		int verticalLineEndX = WINDOW_MAX_X / 2;
		int verticalLineEndY = WINDOW_MAX_Y;
		g.drawLine(verticalLineStartX, verticalLineStartY, verticalLineEndX, verticalLineEndY);
		
		// Get quadrant boundaries
		/*
		 *        Q2	|   Q1
		 *     	  _____	| _____
		 *   		|
		 *        Q3	|   Q4
		 */
		
		int firstQuadrantMinX = WINDOW_MAX_X / 2;
		int firstQuadrantMinY = WINDOW_MIN_Y;
		int firstQuadrantMaxX = WINDOW_MAX_X;
		int firstQuadrantMaxY = WINDOW_MAX_Y / 2;
		
		int secondQuadrantMinX = WINDOW_MIN_X;
		int secondQuadrantMinY = WINDOW_MIN_Y;
		int secondQuadrantMaxX = WINDOW_MAX_X / 2;
		int secondQuadrantMaxY = WINDOW_MAX_Y / 2;
		
		int thirdQuadrantMinX = WINDOW_MIN_X;
		int thirdQuadrantMinY = WINDOW_MAX_Y / 2;
		int thirdQuadrantMaxX = WINDOW_MAX_X / 2;
		int thirdQuadrantMaxY = WINDOW_MAX_Y;
		
		int fourthQuadrantMinX = WINDOW_MAX_X / 2;
		int fourthQuadrantMinY = WINDOW_MAX_Y / 2;
		int fourthQuadrantMaxX = WINDOW_MAX_X;
		int fourthQuadrantMaxY = WINDOW_MAX_Y;
		
		// Get circle coordinates and determine the circle's quadrant
		int circleStartX = mouseX - RADIUS_OF_CIRCLE;
		int circleStartY = mouseY - RADIUS_OF_CIRCLE;
		int circleWidth = 2 * RADIUS_OF_CIRCLE;
		int circleHeight = 2 * RADIUS_OF_CIRCLE;
		int circleEndX = circleStartX + circleWidth;
		int circleEndY = circleStartY + circleHeight;
		
		boolean isInFirstQuadrant = (
		 circleStartX >= firstQuadrantMinX && 
		 circleStartY >= firstQuadrantMinY && 
		 circleEndX <= firstQuadrantMaxX && 
		 circleEndY <= firstQuadrantMaxY
		);
		boolean isInSecondQuadrant = (
		 circleStartX >= secondQuadrantMinX && 
		 circleStartY >= secondQuadrantMinY && 
		 circleEndX <= secondQuadrantMaxX && 
		 circleEndY <= secondQuadrantMaxY
		);
		boolean isInThirdQuadrant = (
		 circleStartX >= thirdQuadrantMinX && 
		 circleStartY >= thirdQuadrantMinY && 
		 circleEndX <= thirdQuadrantMaxX && 
		 circleEndY <= thirdQuadrantMaxY
		);
		boolean isInFourthQuadrant = (
		 circleStartX >= fourthQuadrantMinX && 
		 circleStartY >= fourthQuadrantMinY && 
		 circleEndX <= fourthQuadrantMaxX && 
		 circleEndY <= fourthQuadrantMaxY
		);
		
		Quadrant quadrantOfCircle;
		if (isInFirstQuadrant) {
			quadrantOfCircle = Quadrant.FIRST;
		}
		else if (isInSecondQuadrant) {
			quadrantOfCircle = Quadrant.SECOND;
		}
		else if (isInThirdQuadrant) {
			quadrantOfCircle = Quadrant.THIRD;
		}
		else if (isInFourthQuadrant) {
			quadrantOfCircle = Quadrant.FOURTH;
		}
		else {
			quadrantOfCircle = Quadrant.UNDEFINED;
		}
		
		// Draw circle with a different color, depending on its location on the screen
		Color colorOfCircle;
		switch (quadrantOfCircle) {
		case FIRST:
			colorOfCircle = Color.RED;
			g.setColor(colorOfCircle);
			g.drawOval(circleStartX, circleStartY, circleWidth, circleHeight);
			break;
		case SECOND:
			colorOfCircle = Color.GREEN;
			g.setColor(colorOfCircle);
			g.drawOval(circleStartX, circleStartY, circleWidth, circleHeight);
			break;
		case THIRD:
			colorOfCircle = Color.BLUE;
			g.setColor(colorOfCircle);
			g.drawOval(circleStartX, circleStartY, circleWidth, circleHeight);
			break;
		case FOURTH:
			colorOfCircle = Color.YELLOW;
			g.setColor(colorOfCircle);
			g.drawOval(circleStartX, circleStartY, circleWidth, circleHeight);
			break;
		default:
			break;
		}

	}
	
	public static void main(String[] args) {

		CourseWork mainWindow = new CourseWork();
	}

}
