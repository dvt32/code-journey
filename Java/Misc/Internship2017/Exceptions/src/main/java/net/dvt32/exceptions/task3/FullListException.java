package net.dvt32.exceptions.task3;

/**
 * This class represents a custom unchecked exception,
 * which is triggered when a client tries 
 * to add an element to a full list.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class FullListException 
	extends RuntimeException
{
	/**
	 * Constructor, which allows the exception to show an informative error message to the user.
	 * Internally, the RuntimeException parameterized constructor is used.
	 * 
	 * @param message The error message displayed
	 */
	public FullListException(String message) {
		super(message);
	}
}
