// https://codeforces.com/problemset/problem/1095/B

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		/*
		 * The solution below is correct according to the tutorial, but does not pass because of time limits
		 */
		/*
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		Arrays.sort(a);
		
		System.out.println(
			Math.min(
				a[n-2] - a[0],
				a[n-1] - a[1]
			)
		);
		*/
		
		/*
		 * Alternative solution without sorting
		 */
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int secondMin = Integer.MAX_VALUE;
		int secondMax = Integer.MIN_VALUE;
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();

			if (a[i] > max) {
				secondMax = max;
				max = a[i];
			} 
			else if (a[i] > secondMax) {
				secondMax = a[i];
			}
			
			if (a[i] < min) {
				secondMin = min;
				min = a[i];
			} 
			else if (a[i] < secondMin) {
				secondMin = a[i];
			}
		}
		
		System.out.println(
			Math.min(
				secondMax - min,
				max - secondMin
			)
		);
		
		// Close scanner
		read.close();
	}

}
