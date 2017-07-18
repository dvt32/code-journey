package net.dvt32.introtasks.task2;

import java.util.Arrays;

/**
 * This program can find:
 * - the index of the minimum element in an integer array
 * - the sum of all elements in an integer array
 * 
 * It can also generate a String representation of the array.
 * 
 * @author Dimitar Trifonov (dvt32)
 *
 */
public class ArrayProcessing {
	/**
	 * This method finds the smallest element in an integer array and returns its index.
	 * 
	 * @param array An integer array, in which to find the smallest element's index
	 * @return The index of the smallest element in the array. Returns -1 if the array is empty.
	 */
	public static int getMinElementIndex(int[] array) {
		if (array.length == 0) {
			return -1;
		}
		int minElementValue = array[0];
		int minElementIndex = 0;
		
		for (int i = 1; i < array.length; ++i) {
			if (array[i] < minElementValue) {
				minElementValue = array[i];
				minElementIndex = i;
			}
		}
		
		return minElementIndex;
	}
	
	/**
	 * This method calculates the sum of all elements in an integer array.
	 * 
	 * @param array The input integer array, whose elements' values will be added to the sum.
	 * @return The sum of all elements in the array. If the array is empty, the sum will be 0.
	 */
	public static int sum(int[] array) {
		int sum = 0;
		
		for (int elementValue : array) {
			sum += elementValue;
		}
		
		return sum;
	}
	
	/**
	 * This method generates a String representation of an integer array
	 * in the form of "[array[0], array[1], ..., array[array.length-1]]"
	 * by using the Arrays class' static method toString().
	 * 
	 * @param array The input integer array
	 * @return A string representation of the array  
	 */
	public static String convertToString(int [] array) {
		return Arrays.toString(array);
	}
}
