package net.dvt32.introtasks.task5;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReverseArrayTest {

	private final ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();
	ReverseArray ra = new ReverseArray();
	
	@Before
	public void setUpOutputStream() {
		System.setOut(new PrintStream(consoleContent));
	}
	
	@After
	public void cleanUpOutputStream() {
		System.setOut(null);
	}
	
	@Test
	public void shouldPrintArrayInReverseOrder() {
		String expectedOutput = "5 4 3 2 1 ";
		ra.printArrayInReverseOrder( new int[] { 1, 2, 3, 4, 5 } );
		assertEquals(expectedOutput, consoleContent.toString());
	}
	
	@Test
	public void shouldntPrintAnything() {
		String expectedOutput = "";
		ra.printArrayInReverseOrder( new int[] { } );
		assertEquals(expectedOutput, consoleContent.toString());
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerException() {
		ra.printArrayInReverseOrder(null);
	}

}
