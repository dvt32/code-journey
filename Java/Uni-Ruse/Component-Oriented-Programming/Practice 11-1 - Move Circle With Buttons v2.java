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
		
		setLayout(new BorderLayout());
		
		Panel panel = new Panel();
		panel.setBackground(Color.DARK_GRAY.brighter());
		panel.setLayout(new GridLayout(4, 1, 1, 10));
		
		moveUpButton = new Button("Up");
		moveUpButton.addActionListener(this);
		panel.add(moveUpButton);
		
		moveDownButton = new Button("Down");
		moveDownButton.addActionListener(this);
		panel.add(moveDownButton);
		
		moveLeftButton = new Button("Left");
		moveLeftButton.addActionListener(this);
		panel.add(moveLeftButton);
		
		moveRightButton = new Button("Right");
		moveRightButton.addActionListener(this);
		panel.add(moveRightButton);
		
		add(panel, BorderLayout.EAST);
		
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
