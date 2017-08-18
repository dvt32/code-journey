package net.dvt32.exceptions.task1;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumatorTest {

	Sumator s = new Sumator();
	
	/*
	 * getSumOfNumbers() tests
	 */
	@Test
	public void shouldReturn12345() {
		String expectedOutput = "12345";
		String actualOutput = s.getSumOfNumbers("12339", "6");
		assertEquals(expectedOutput, actualOutput);
	}

	@Test(expected = NumberFormatException.class)
	public void shouldThrowNumberFormatExceptionWithAppropriateMessage() {
		s.getSumOfNumbers("12339", "-6");
	}
	
	@Test
	public void shouldReturn0() {
		String expectedOutput = "0";
		String actualOutput = s.getSumOfNumbers("00000000000000000000000000", "00000000000000000");
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWithNoEmptyNumbersAllowedMessage() {
		String expectedOutput = "123";
		String actualOutput = s.getSumOfNumbers("", "123");
		assertEquals(expectedOutput, actualOutput);
	}
	
	/*
	 * getStringWithoutLeadingZeros() tests
	 */
	@Test
	public void shouldntReturnBlankString() {
		String output = s.getStringWithoutLeadingZeros("0");
		assertTrue( output.length() != 0 );
	}
	
	@Test(expected = NullPointerException.class) 
	public void shouldThrowNullPointerException() {
		s.getStringWithoutLeadingZeros(null);
	}

	/*
	 * checkIfNumberIsValid() tests
	 */
	@Test(expected = NullPointerException.class)
	public void shouldNullPointerExceptionWithMessage() {
		s.checkIfNumberIsValid(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentException() {
		s.checkIfNumberIsValid("");
	}
	
	@Test(expected = NumberFormatException.class)
	public void shouldThrowNumberFormatException_FirstTest() {
		s.checkIfNumberIsValid("1.0");
	}
	
	@Test(expected = NumberFormatException.class)
	public void shouldThrowNumberFormatException_SecondTest() {
		s.checkIfNumberIsValid("-1");
	}
	
	@Test(expected = NumberFormatException.class)
	public void shouldThrowNumberFormatException_ThirdTest() {
		s.checkIfNumberIsValid("1 ");
	}
	
	@Test
	public void shouldNotThrowAnyException() {
		s.checkIfNumberIsValid("1");
	}
}
