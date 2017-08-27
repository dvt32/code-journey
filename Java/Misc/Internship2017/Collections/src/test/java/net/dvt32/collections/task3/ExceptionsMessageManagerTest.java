package net.dvt32.collections.task3;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;

public class ExceptionsMessageManagerTest {
	
	final String[] ALLOWED_EXCEPTION_MESSAGES = new String[] {
		"Message 1",
		"Message 2",
		"Message 3"
	};
	final String SEPARATOR = ", ";
	
	/*
	 * addExceptionMessage() tests
	 */
	@Test
	public void shouldReturnConcatenatedVersionOfAddedExceptionMessages() {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(ALLOWED_EXCEPTION_MESSAGES, SEPARATOR);
		
		manager.addExceptionMessage("Message 1");
		manager.addExceptionMessage("Message 2");
		
		String expectedResult = "Message 1, Message 2";
		String actualResult = manager.getMessage();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void shouldThrowNoSuchElementException() {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(ALLOWED_EXCEPTION_MESSAGES, SEPARATOR);
		manager.addExceptionMessage("Message 1337");
	}
	
	/*
	 * addExceptionMessageUsingCode()
	 */
	@Test
	public void shouldReturnConcatenatedVersionOfAddedExceptionMessageUsingCode() {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(ALLOWED_EXCEPTION_MESSAGES, SEPARATOR);
		
		manager.addExceptionMessageUsingCode("1");
		manager.addExceptionMessageUsingCode("2");
		
		String expectedResult = "Message 1, Message 2";
		String actualResult = manager.getMessage();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void addExceptionMessageUsingCodeMethodShouldThrowNoSuchElementException() {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(ALLOWED_EXCEPTION_MESSAGES, SEPARATOR);
		manager.addExceptionMessageUsingCode("1337");
	}
	
	/*
	 * getMessages() test
	 */
	@Test
	public void shouldReturnAllAddedExceptionsAsList() {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(ALLOWED_EXCEPTION_MESSAGES, SEPARATOR);
		
		manager.addExceptionMessage("Message 1");
		manager.addExceptionMessage("Message 2");
		
		Collection<String> messages = manager.getMessages(manager.getMessage());
		assertTrue(messages instanceof Collection && messages instanceof List);
		
		String expectedResult = "[Message 1, Message 2]";
		String actualResult = String.valueOf(messages);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void shouldReturnEmptyList() {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(ALLOWED_EXCEPTION_MESSAGES, SEPARATOR);
		
		Collection<String> messages = manager.getMessages(manager.getMessage());
		assertTrue(messages instanceof Collection && messages instanceof List);
		assertTrue( messages.isEmpty() );
	}
	
}