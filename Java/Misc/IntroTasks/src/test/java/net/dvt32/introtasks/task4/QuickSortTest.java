package net.dvt32.introtasks.task4;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortTest {
	
	QuickSort qs = new QuickSort();

	@Test
	public void arrayShouldBeSortedInAscendingOrder() {
		int[] expectedOutput = new int[] { 1, 2, 3, 4, 5 };
		
		int[] actualOutput = new int[] { 1, 3, 2, 5, 4 };
		qs.quickSort(actualOutput, 0, actualOutput.length-1);
		
		assertArrayEquals(expectedOutput, actualOutput);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void shouldCauseIndexOutOfBoundsException() {
		qs.quickSort( new int[] { 1, 3, 2 }, -1, 5 );
	}

}
