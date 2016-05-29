// https://www.hackerrank.com/challenges/java-1d-array-easy

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int numberOfNegativeSubarrays = 0;

		// Enter input
		int n = read.nextInt();
		if (n > 100) {
			throw new IllegalArgumentException("n must be less than 100.");
		}
		
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = read.nextInt();
		}
		
		// Extract each sub-array, count the sum of its elements and determine number of negative sum subarrays
		for (int i = 0; i < n; ++i) {
			int sumOfCurrenSubarray = 0;
			for (int j = i; j < n; ++j) {
				sumOfCurrentSubarray += arr[j];
				if (sumOfCurrentSubarray < 0) {
					numberOfNegativeSubarrays++;
				}
			}
		}
		
		// Print end result
		System.out.println(numberOfNegativeSubarrays);
		
		// Close scanner
		read.close();
	}
}
