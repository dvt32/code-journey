package net.dvt32.designpatterns.task7;

/**
 * This class is the "receiver" class, which 
 * executes a certain Command or 
 * more precisely, a CalculatorCommand.
 * 
 * Initially, a Calculator has a current value of 0.
 * When a certain CalculatorCommand is executed, this value changes.
 */
public class Calculator {
	private int currentValue = 0;
	
	/**
	 * This method performs an operation, which is specified by a CalculatorCommand.
	 * 
	 * When the command is executed (its specified operation has been performed), 
	 * the calculator's current value changes and the new value is printed.
	 * 
	 * In case the operation is not a valid one, an IllegalArgumentException is thrown.
	 *
	 * @param operator The CalculatorCommand's operator (symbol, representing operation type)
	 * @param operand The CalculatorCommand's operand (integer)
	 */
	public void performOperation(char operator, int operand) {
		switch (operator) {
		case '+': currentValue += operand; break;
		case '-': currentValue -= operand; break;
		case '*': currentValue *= operand; break;
		case '/': currentValue /= operand; break;
		case '^': currentValue = (int) Math.pow(currentValue, operand); break;
		default: 
			throw new IllegalArgumentException("Invalid operation.");
		}
		
		System.out.println(currentValue);
	}
}