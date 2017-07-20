package net.dvt32.introtasks.task4;

/**
 * This program sorts an array of integers via the QuickSort algorithm.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class QuickSort {
	/**
	 * This method sorts (in ascending order) an integer array recursively by using QuickSort.
	 * 
	 * The divide-and-conquer strategy is used in QuickSort. Below the recursion step is described:
	 * 
	 * - 1. Choose a pivot value. 
	 * 		We take the value of the middle element as pivot value, 
	 * 		but it can be any value, which is in range of sorted values, 
	 * 		even if it doesn't present in the array.
	 * 
	 * - 2. Partition. 
	 * 		Rearrange elements in such a way, that all elements 
	 * 		which are lesser than the pivot go to the left part of the array 
	 * 		and all elements greater than the pivot, go to the right part of the array. 
	 * 		Values equal to the pivot can stay in any part of the array. 
	 * 		Notice, that array may be divided in non-equal parts.
	 * 
	 * - 3. Sort both parts. 
	 * 		Apply quicksort algorithm recursively to the left and the right parts.
	 * 
	 * Partition algorithm in detail:
	 * 
	 * There are two indices i and j and at the very beginning of the partition algorithm 
	 * i points to the first element in the array and j points to the last one. 
	 * 
	 * Then algorithm moves i forward, until an element with value greater or equal to the pivot is found. 
	 * Index j is moved backward, until an element with value lesser or equal to the pivot is found. 
	 * 
	 * If i ≤ j then they are swapped and i steps to the next position (i + 1), 
	 * j steps to the previous one (j - 1). 
	 * 
	 * Algorithm stops, when i becomes greater than j.
	 * 
	 * After partition, all values before i-th element are less or equal than the pivot 
	 * and all values after j-th element are greater or equal to the pivot.
	 * 
	 * @param arr The input integer array, which is to be sorted.
	 * @param L First valid index of the array (0)
	 * @param R	Last valid index of the array (arr.length-1)
	 */
	public void quickSort(int[] arr, int L, int R) {
		int pivotValue = arr[(L+R) / 2];
		
		int i = L;
		int j = R;
		
		// Partition array
		while (i <= j) {
			while (arr[i] < pivotValue) {
				i++;
			}
			while (arr[j] > pivotValue) {
				j--;
			}
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		
		// Recursively sort
		if (L < j) {
			// ... the left partition
			quickSort(arr, L, j);
		}
		if (i < R) {
			// ... the right partition
			quickSort(arr, i, R);
		}
	}
}