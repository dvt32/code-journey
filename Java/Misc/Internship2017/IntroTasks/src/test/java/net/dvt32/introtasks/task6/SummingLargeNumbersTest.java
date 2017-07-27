package net.dvt32.introtasks.task6;

import static org.junit.Assert.*;

import org.junit.Test;

public class SummingLargeNumbersTest {
	
	SummingLargeNumbers sln = new SummingLargeNumbers();
	
	/*
	 * getSumOfNumbers() tests
	 */
	@Test
	public void shouldReturn12345() {
		String expectedOutput = "12345";
		String actualOutput = sln.getSumOfNumbers("12339", "6");
		assertEquals(expectedOutput, actualOutput);
	}

	@Test(expected = NumberFormatException.class)
	public void shouldThrowNumberFormatException() {
		sln.getSumOfNumbers("12339", "-6");
	}
	
	@Test
	public void shouldReturn0() {
		String expectedOutput = "0";
		String actualOutput = sln.getSumOfNumbers("00000000000000000000000000", "00000000000000000");
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void shouldReturn123() {
		String expectedOutput = "123";
		String actualOutput = sln.getSumOfNumbers("", "123");
		assertEquals(expectedOutput, actualOutput);
	}
	
	/*
	 * getStringWithoutLeadingZeros() tests
	 */
	@Test
	public void shouldntReturnBlankString() {
		String output = sln.getStringWithoutLeadingZeros("0");
		assertTrue( output.length() != 0 );
	}
	
	@Test(expected = NullPointerException.class) 
	public void shouldThrowNullPointerException() {
		sln.getStringWithoutLeadingZeros(null);
	}
}
