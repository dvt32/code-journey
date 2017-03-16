import javax.swing.JOptionPane;

class MyClass {
	int number;
	char symbol;
}

public class UsingObjectDemo { // labeled as "UsingObjectApplication" in the book
	public static void main(String[] args) {
		MyClass object = new MyClass();
		object.number = 100;
		object.symbol = 'A';
		
		String text = "Number: " + object.number + "\n" + "Symbol: " + object.symbol;
		
		JOptionPane.showMessageDialog(null, text);
	}
}
