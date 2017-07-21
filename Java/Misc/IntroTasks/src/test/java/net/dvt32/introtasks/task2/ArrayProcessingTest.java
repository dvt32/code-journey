package net.dvt32.introtasks.task2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayProcessingTest {
	
	ArrayProcessing ap = new ArrayProcessing();

	/*
	 *  getMinElementIndex() tests
	 */
	@Test
	public void minElementIndexShouldBeThree() {
		int expectedOutput = 3;
		
		int actualOutput = ap.getMinElementIndex( new int[] {1, 2, -3, -4, 5} );
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void minElementIndexShouldBeMinusOne() {
		int expectedOutput = -1;
		
		int actualOutput = ap.getMinElementIndex( new int[] { } );
		assertEquals(expectedOutput, actualOutput);
	}

	/*
	 * sum() tests
	 */
	@Test
	public void sumShouldBeFifteen() {
		int expectedOutput = 15;
		int actualOutput = ap.sum( new int[] { 1, 2, 3, 4, 5 } );
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void sumShouldBeZero() {
		int expectedOutput = 0;
		int actualOutput = ap.sum( new int[] { } );
		assertEquals(expectedOutput, actualOutput);
	}
	
	/*
	 * convertToString() tests
	 */
	public void stringRepresentationOfArrayShouldBeOnlyBrackets() {
		String expectedOutput = "[]";
		String actualOutput = ap.convertToString( new int[] { } );
		assertEquals(expectedOutput, actualOutput);
	}
	
	public void stringRepresentationOfArrayShouldBeInTheFormat_OpeningBracket_ArrayElementsSeparatedByComma_EndingBracket() {
		String expectedOutput = "[1, 2, 3]";
		String actualOutput = ap.convertToString( new int[] { 1, 2, 3 } );
		assertEquals(expectedOutput, actualOutput);
	}
}
