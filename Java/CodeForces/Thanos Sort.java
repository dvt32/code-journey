// https://codeforces.com/problemset/problem/1145/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length-1; ++i) {
	        if (arr[i] > arr[i+1])
	            return false;
	    }
	    return true;
	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int[] a = new int[n];
		
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		if ( isSorted(a) ) {
			System.out.println(n);
		}
		else {
			int[] firstHalfSubArray = Arrays.copyOfRange(a, 0, n/2);
			while ( !isSorted(firstHalfSubArray) ) {
				firstHalfSubArray = Arrays.copyOfRange(firstHalfSubArray, 0, firstHalfSubArray.length/2);
			}
			
			int[] secondHalfSubArray = Arrays.copyOfRange(a, n/2, n);
			while ( !isSorted(secondHalfSubArray) ) {
				secondHalfSubArray = Arrays.copyOfRange(secondHalfSubArray, 0, secondHalfSubArray.length/2);
			}
			
			System.out.println( Math.max(firstHalfSubArray.length, secondHalfSubArray.length) );
		}

		// Close scanner
		read.close();
	}

}
