package net.dvt32.exceptions.task2;

/**
 * This class represents a custom exception,
 * which is triggered whenever a user enters 
 * a number that is lower than 0 or higher than 100.
 * 
 * The exception is unchecked and does not allow the client to recover from it.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class NumberOutOfRangeException
	extends RuntimeException
{
	/**
	 * This constructor allows the exception to contain a specific message,
	 * which informs the client what the problem is.
	 * 
	 * Internally, the RuntimeException class constructor is used to pass the message.
	 * 
	 * @message The error message, which is shown to the client
	 */
	public NumberOutOfRangeException(String message) {
		super(message);
	}
}