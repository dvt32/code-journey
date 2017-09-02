package net.dvt32.designpatterns.task7;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorCommandPatternTest {
	
	private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	private final String LINE_SEPARATOR = System.getProperty("line.separator");
	CalculatorUser user = new CalculatorUser();
	
	@Before
	public void setUpOutputStream() {
		System.setOut( new PrintStream(consoleOutput) );
	}
	
	@After
	public void cleanUpOutputStream() {
		System.setOut(null);
	}

	@Test
	public void shouldPrint100_then_10_then_1000_then_2000_then_200() {
		user.compute('+', 100);
		user.compute('-', 90);
		user.compute('^', 3);
		user.compute('*', 2);
		user.compute('/', 10);
		
		String expectedOutput =
			"100" + LINE_SEPARATOR +
			"10" + LINE_SEPARATOR +
			"1000" + LINE_SEPARATOR +
			"2000" + LINE_SEPARATOR +
			"200" + LINE_SEPARATOR;
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void shouldPrintMinusTen() {
		user.compute('-', new Integer(10));
		
		String expectedOutput = "-10" + LINE_SEPARATOR;
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentException() {
		user.compute(' ', 10);
	}
		
	@Test(expected = NumberFormatException.class)
	public void shouldThrowNumberFormatException() {
		user.compute('+', new Integer(null));
	}
	
	@Test(expected = ArithmeticException.class)
	public void shouldThrowArithmeticException() {
		user.compute('/', 0);
	}

}