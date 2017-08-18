package net.dvt32.exceptions.task2;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.After;
import org.junit.Test;

public class ReadNumberTest {

	ReadNumber rn = new ReadNumber();
	
	@After
	public void restoreSystemInputStream() {
		System.setIn(System.in);
	}
	
	/*
	 * readNumber() tests
	 */
	@Test(expected = NumberOutOfRangeException.class)
	public void shouldThrowNumberOutOfRangeException() {
		String userInput = 
				"4\n" +
				"3\n" +
				"2\n" +
				"1\n" +
				"0\n" +
				"-1\n";
			
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner read = new Scanner(System.in);
		rn.readNumber(read);
	}
	
	@Test(expected = InputMismatchException.class)
	public void shouldThrowInputMismatchException() {
		String userInput = "abcd";
			
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner read = new Scanner(System.in);
		rn.readNumber(read);
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerException() {
		String userInput = null;
			
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner read = new Scanner(System.in);
		rn.readNumber(read);
	}
}