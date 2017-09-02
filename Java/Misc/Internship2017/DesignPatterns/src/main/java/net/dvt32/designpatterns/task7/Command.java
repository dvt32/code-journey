package net.dvt32.designpatterns.task7;

/**
 * The Command interface.
 * 
 * This interface is to be implemented by a "concrete command" class.
 * 
 * For example, the CalculatorCommand class is a concrete command class,
 * which describes a command, which a Calculator will execute.
 */
public interface Command {
	public void execute();
}