package net.dvt32.introtasks.task1;

import static org.junit.Assert.*;

import org.junit.Test;

public class GreatestCommonDivisorTest {

	GreatestCommonDivisor gcd = new GreatestCommonDivisor();
	
	/*
	 * getGreatestCommonDivisor() tests
	 */
	@Test
	public void greatestCommonDivisorShouldBeOne() {
		int expectedOutput = 1;
		
		int actualOutput = gcd.getGreatestCommonDivisor(143, 277);
		assertEquals(expectedOutput, actualOutput);
		
		actualOutput = gcd.getGreatestCommonDivisor(123, 5215);
		assertEquals(expectedOutput, actualOutput);
		
		actualOutput = gcd.getGreatestCommonDivisor(1337, 31337);
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void greatestCommonDivisorShouldNotBeZero() {
		int output = gcd.getGreatestCommonDivisor(1, 2);
		assertNotEquals(0, output);
	}
	
	/*
	 * getLeastCommonMultiple() tests
	 */
	@Test
	public void leastCommonMultipleShouldBe130() {
		int expectedOutput = 130;
		int actualOutput = gcd.getLeastCommonMultiple(65, 10);
		assertEquals(expectedOutput, actualOutput);
	}
	
	public void leastCommonMultipleShouldBePositive() {
		int output = gcd.getLeastCommonMultiple(123, 456);
		assertTrue(output > 0);
	}

}
