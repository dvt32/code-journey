package net.dvt32.collections.task3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * This program concatenates
 * a series of exception messages (with a pre-specified separator symbol),
 * but only if the current exception message 
 * is present inside the class' internal Map as a value.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class ExceptionsMessageManager {
	private Map<String, String> exceptions;
	private StringJoiner message;
	final String SEPARATOR;
	
	/**
	 * Constructor, which initializes the map with allowed exception messages.
	 * 
	 * The key for each exception message in the map is its CODE, 
	 * which is equal to the message's index in the allowed messages array + 1.
	 * 
	 * @param allowedExceptionsMessages A String array, containing all allowed exception messages
	 * @param separator The separator used in the end message to distinguish each exception message
	 */
	public ExceptionsMessageManager(String[] exceptionMessages, String separator) {
		exceptions = new HashMap<String, String>();
		for (int i = 0; i < exceptionMessages.length; ++i) {
			String messageCode = String.valueOf(i+1);
			exceptions.put(messageCode, exceptionMessages[i]);
		}
		
		SEPARATOR = separator;
		message = new StringJoiner(SEPARATOR);
	}
	
	/**
	 * This method tries to concatenate a certain exception message
	 * to the end message string, if its value is present in the internal class map.
	 * 
	 * If the passed message is not present in the map, an exception is thrown,
	 * informing the caller that the message was not found in the map.
	 * 
	 * @param message The exception message to be concatenated to the end message
	 */
	public void addExceptionMessage(String message) {
		if ( exceptions.containsValue(message) ) {
			this.message.add(message);
		}
		else {
			throw new NoSuchElementException("The provided message does not exist!");
		}
	}
	
	/**
	 * This method tries to concatenate a certain exception message
	 * to the end message string, if there is an element with a key equal
	 * to the passed message code argument.
	 * 
	 * If there is such an element, its map value 
	 * is concatenated to the end message string.
	 * 
	 * Otherwise, an exception is thrown, informing the caller 
	 * that there is no element with such a key.
	 * 
	 * @param messageCode The message code of the message to be concatenated to the end message
	 */
	public void addExceptionMessageUsingCode(String messageCode) {
		String exceptionMessage = exceptions.get(messageCode);
		if ( exceptionMessage != null ) {
			message.add( exceptionMessage );
		}
		else {
			throw new NoSuchElementException("The provided message code does not exist!");
		}
	}
	
	/**
	 * This method returns the end message in the form of a String.
	 * 
	 * @return The end message as a String
	 */
	public String getMessage() {
		return message.toString();
	}
	
	/**
	 * This method returns the messages which compose the end message,
	 * in the form of a Collection (more specifically, a List).
	 * 
	 * If the input String is empty, an empty immutable list will be returned.
	 * 
	 * @param messagesCombination The end message, which is to be examined
	 * @return A Collection of messages, which form the end message
	 */
	public Collection<String> getMessages(String messagesCombination) {
		if (messagesCombination.length() == 0) {
			return Collections.emptyList();
		}
		
		Collection<String> messages = Arrays.asList( messagesCombination.split(SEPARATOR) );
		return messages;
	}
}