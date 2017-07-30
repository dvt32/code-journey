package net.dvt32.generictypesclassesandobjects.task1;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

public class SummatorTest {
	
	Summator s = new Summator();

	/*
	 *  int sum() method tests
	 */
	@Test
	public void intSumMethodShouldReturn3() {
		int expectedResult = 3;
		int actualResult = s.sum(1, 2);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void intSumMethodShouldReturnIntegerMaxValue() {
		int expectedResult = Integer.MAX_VALUE;
		int actualResult = s.sum(Integer.MAX_VALUE - 1, 1);
		assertEquals(expectedResult, actualResult);
	}
	
	/*
	 * 	double sum() method tests
	 */
	@Test
	public void doubleSumMethodShouldReturn3Point3() {
		double expectedResult = 3.3d;
		double actualResult = s.sum(1.0, 2.3);
		assertEquals(expectedResult, actualResult, 0.01);
	}
	
	@Test
	public void doubleSumMethodShouldReturn123Point45() {
		double expectedResult = 123.45d;
		double actualResult = s.sum(123, 0.45);
		assertEquals(expectedResult, actualResult, 0.01);
	}

	/*
	 * 	String sum() method tests
	 */
	@Test
	public void stringSumMethodShouldReturn246() {
		String expectedResult = "246";
		String actualResult = s.sum("123", "123");
		assertEquals(expectedResult, actualResult);
	}
	
	@Test(expected = NullPointerException.class)
	public void stringSumMethodShouldThrowNullPointerException() {
		s.sum("123", null);
	}
	
	@Test(expected = NumberFormatException.class)
	public void stringSumMethodShouldThrowNumberFormatException() {
		s.sum("123", "-2");
	}
	
	/*
	 *	BigInteger sum() method tests
	 */
	@Test
	public void bigIntegerSumMethodShouldReturn246() {
		BigInteger expectedResult = new BigInteger("246");
		BigInteger actualResult = s.sum( new BigInteger("123"), new BigInteger("123") );
		assertEquals(expectedResult, actualResult);
	}
	
	@Test(expected = NumberFormatException.class)
	public void bigIntegerSumMethodShouldThrowNumberFormatException() {
		s.sum( new BigInteger("23.0"), new BigInteger("123") );
	}
	
	/*
	 * 	BigDecimal sum() method tests
	 */
	@Test
	public void bigDecimalSumMethodShouldReturn246Point33() {
		BigDecimal expectedResult = new BigDecimal("246.33");
		BigDecimal actualResult = s.sum( new BigDecimal("123.11"), new BigDecimal("123.22") );
		assertEquals(expectedResult, actualResult);
	}

	@Test(expected = NumberFormatException.class)
	public void bigDecimalSumMethodShouldThrowNumberFormatException() {
		s.sum( new BigDecimal("123.12"), new BigDecimal("456,2") );
	}
}
