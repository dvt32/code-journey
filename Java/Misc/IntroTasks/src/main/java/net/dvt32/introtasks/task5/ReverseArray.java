package net.dvt32.introtasks.task5;

/**
 * This program prints an input integer array in reverse order.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class ReverseArray {
	/**
	 * This method prints an array in reverse order in the format 
	 * -> "arr[arr.length-1] arr[arr.length-2] ... arr[0] "
	 * 
	 * For example, an input array [1, 2, 3, 4, 5]
	 * would output "5 4 3 2 1 "
	 * 
	 * @param arr The input integer array.
	 */
	public void printArrayInReverseOrder(int[] arr) {
		for (int i = arr.length-1; i >= 0; --i) {
			System.out.print(arr[i] + " ");
		}
	}
}