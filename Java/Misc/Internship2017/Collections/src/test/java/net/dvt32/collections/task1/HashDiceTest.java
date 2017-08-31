package net.dvt32.collections.task1;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HashDiceTest {
	
	private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	private final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	@Before
	public void setUpOutputStream() {
		System.setOut( new PrintStream(consoleOutput) );
	}
	
	@After
	public void cleanUpOutputStream() {
		System.setOut(null);
	}

	/*
	 * rollDice() tests
	 */
	@Test
	public void shouldRollSixSidedDiceFiveTimes() {
		HashDice hd = new HashDice(6, 5);
		
		hd.rollDice();
		hd.printStats();
		
		String output = consoleOutput.toString();
		String[] outputLines = output.split(LINE_SEPARATOR);
		
		// Check if every roll number is used
		for (int i = 0; i < 5; ++i) {
			assertTrue(output.contains(String.valueOf(i)));
		}
		
		// Check to see if every roll combination has exactly 2 numbers & they are within range
		for (String outputLine : outputLines) {
			String combination = outputLine.substring(1, outputLine.indexOf("]"));
			int[] numbers = Arrays.stream( combination.split(", ") )
				.mapToInt(Integer::parseInt)
				.toArray();
			
			assertTrue( numbers.length == 2);
			
			boolean firstNumberInRange = (numbers[0] >= 1 && numbers[0] <= 6);
			boolean secondNumberInRange = (numbers[1] >= 1 && numbers[1] <= 6);
			assertTrue( firstNumberInRange && secondNumberInRange );
		}
	}
	
	@Test(expected = NumberFormatException.class)
	public void shouldThrowNumberFormatException() {
		HashDice hd = new HashDice(new Integer(null), 6);
		hd.rollDice();
	}
	
	@Test
	public void shouldNotPrintAnything() {
		HashDice hd = new HashDice(6, -1);
		
		hd.rollDice();
		hd.printStats();
		
		String output = consoleOutput.toString();
		assertTrue( output.isEmpty() );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentException() {
		HashDice hd = new HashDice(-1, 5);	
		hd.rollDice();
	}

}