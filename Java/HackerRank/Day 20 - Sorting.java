// https://www.hackerrank.com/challenges/30-sorting

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		// Enter 'n'
		int n = read.nextInt();
		
		// Enter array values
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		// Implement Bubble Sort & count swaps
		int totalSwaps = 0;
		for (int i = 0; i < n; ++i) {
			int numberOfSwaps = 0;
			for (int j = 0; j < n-1; ++j) {
				if (a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					numberOfSwaps++;
					totalSwaps++;
				}
			}
			if (numberOfSwaps == 0) {
				break;
			}
		}
		
		// Print end result
		System.out.println("Array is sorted in " + totalSwaps + " swaps.");
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[n-1]);
		
		// Close scanner
		read.close();
	}
}
