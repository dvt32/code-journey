package net.dvt32.designpatterns.task7;

/**
 * The class is the "invoker" class.
 * 
 * A CalculatorUser is the client, who has 
 * his own Calculator and uses it to execute a CalculatorCommand.
 * 
 * The CalculatorUser doesn't really execute the command. 
 * He simply says "I want to execute this command, so do it for me, Calculator!".
 * 
 * Once he specifies the command, which he wants to be executed,
 * this command gets executed by his Calculator 
 * (in case the operation is not valid, an exception is thrown).
 */
public class CalculatorUser {
	private Calculator calculator = new Calculator();
	
	/**
	 * This method allows the user to indirectly execute a certain command.
	 * 
	 * The command is executed by the CalculatorUser's Calculator object. 
	 * 
	 * Actually the CalculatorCommand executes itself, but its operation 
	 * is performed by the CalculatorUser's Calculator.
	 * 
	 * Then the result is printed (or an exception is thrown, if the operation is invalid)
	 * 
	 * @param operator The desired command's operator symbol
	 * @param operand The desired command's operand (integer)
	 */
	public void compute(char operator, int operand) {
		Command command = new CalculatorCommand(calculator, operator, operand);
		command.execute();
	}
}