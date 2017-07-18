package net.dvt32.introtasks.task3;

/**
 * This program finds the index of the 
 * "center of gravity" (balancing point) element 
 * in an integer array and prints it.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class CenterOfGravity {
	/**
	 * This method finds the index of the "center of gravity" element in an integer array.
	 * 
	 * The "center of gravity" element is the element, which divides 
	 *  - the left part of the array (the elements before it) and
	 *  - the right part of the array (the elements after it)
	 *   
	 *  ... in a way where the difference between the two sums of the two parts in the array is MINIMUM.
	 * 
	 * @param arr The input integer array
	 * @return The index of the "center of gravity" element in the array
	 */
	public static int getCenterOfGravityIndex(int[] arr) {
		int minDifferenceBetweenSums = Integer.MAX_VALUE;
		int centerOfGravityIndex = -1;
		
		for (int i = 0; i < arr.length; ++i) {		
			// Calculate left part's sum
			int leftSum = 0;
			for (int j = 0; j < i; ++j) {
				leftSum += arr[j];
			}
			
			// Calculate right part's sum
			int rightSum = 0;
			for (int j = i+1; j < arr.length; ++j) { 
				/* 
				 * NOTE: We assume that arr[i] is the "center of gravity" element
				 * and therefore its value is not added to any of the sums  
				 */
				rightSum += arr[j];
			}
			
			// Calculate difference between 2 sums and determine index of "center of gravity" element
			int differenceBetweenSums = Math.abs(leftSum - rightSum);
			if (differenceBetweenSums < minDifferenceBetweenSums) {
				minDifferenceBetweenSums = differenceBetweenSums;
				centerOfGravityIndex = i;
			}
		}
		
		return centerOfGravityIndex;
	}
}