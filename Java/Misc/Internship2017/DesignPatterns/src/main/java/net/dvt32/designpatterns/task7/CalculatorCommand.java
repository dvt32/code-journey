package net.dvt32.designpatterns.task7;

/**
 * A concrete command class, which implements the Command interface.
 * 
 * This class describes what it means 
 * for a Calculator to "execute" a CalculatorCommand.
 */
public class CalculatorCommand
	implements Command
{	
	private Calculator calculator;
	private char operator;
	private int operand;
	
	/**
	 * Constructor, which sets:
	 * - the command's calculator (which Calculator object will execute the command)
	 * - the command's operator (what operation are we performing - adding, dividing etc.)
	 * - the command's operand (how much are we adding/substracting, by how much are we multiplying etc.)
	 * 
	 * @param calculator The Calculator object, which executes the command
	 * @param operator The operator symbol, representing the type of operation to be performed
	 * @param operand A number, which states "how much" we're adding/substracting/dividing by etc
	 */
	public CalculatorCommand(Calculator calculator, char operator, int operand) {
		this.calculator = calculator;
		this.operator = operator;
		this.operand = operand;
	}

	/**
	 * This method describes how a CalculatorCommand is executed internally.
	 * The command's Calculator object uses its performOperation() 
	 * method with the command's operator and operand values.
	 */
	@Override
	public void execute() {
		calculator.performOperation(operator, operand);
	}
}