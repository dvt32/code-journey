// Component-Oriented Programming, Practice 11, 23.11.2016 - dvt32

import java.awt.*;
import java.awt.event.*;

public class GraphicsTest extends Frame implements ActionListener{

	Button moveUpButton;
	Button moveDownButton;
	Button moveLeftButton;
	Button moveRightButton;
	int circleX = 100;
	int circleY = 100;
	
	public GraphicsTest() {
		super("Component-Oriented Programming - dvt32, 146518");
		setBackground(Color.lightGray);
		setLocation(200, 100);
		setSize(600, 400);
		addWindowListener(new WindowClosingAdapter());
		
		setLayout(null);
		
		moveUpButton = new Button("Up");
		moveUpButton.setBounds(500, 50, 100, 50);
		moveUpButton.addActionListener(this);
		add(moveUpButton);
		
		moveDownButton = new Button("Down");
		moveDownButton.setBounds(500, 100, 100, 50);
		moveDownButton.addActionListener(this);
		add(moveDownButton);
		
		moveLeftButton = new Button("Left");
		moveLeftButton.setBounds(500, 150, 100, 50);
		moveLeftButton.addActionListener(this);
		add(moveLeftButton);
		
		moveRightButton = new Button("Right");
		moveRightButton.setBounds(500, 200, 100, 50);
		moveRightButton.addActionListener(this);
		add(moveRightButton);
		
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(circleX, circleY, 100, 100);
	}
	
	public static void main(String[] args) { 
		GraphicsTest mainWindow = new GraphicsTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonLabel = e.getActionCommand();
		switch (buttonLabel) {
		case "Up":
			circleY -= 10;
			break;
		case "Down":
			circleY += 10;
			break;
		case "Left":
			circleX -= 10;
			break;
		case "Right":
			circleX += 10;
			break;
		default: break;
		}
		repaint();
	}

}
