import javax.swing.*;

public class UsingIfDemo {
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog(
			null, // dialog parent
			"Enter integer", // dialog label	
			"Check if number is odd or even", // dialog window title
			JOptionPane.QUESTION_MESSAGE // icon type
		);
		
		if (input == null) {
			JOptionPane.showMessageDialog(
				null,
				"You didn't enter a number!",
				"Input error",
				JOptionPane.ERROR_MESSAGE
			);
			System.exit(0);
		}
		
		int number = Integer.parseInt(input);
		ImageIcon imageIcon = null;
		String labelText = null;
		String titleText = null;
		
		if (number % 2 == 0) {
			imageIcon = new ImageIcon("H:\\even.png");
			labelText = "The number is even!";
			titleText = "Even number";
		}
		else {
			imageIcon = new ImageIcon("H:\\odd.png");
			labelText = "The number is odd!";
			titleText = "Odd number";
		}
		
		JOptionPane.showMessageDialog(
			null,
			labelText,
			titleText,
			JOptionPane.PLAIN_MESSAGE,
			imageIcon
		);
	}
}
