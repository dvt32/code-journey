// https://codeforces.com/problemset/problem/34/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		int minDifference = Math.abs(a[0] - a[n-1]);
		String minDifferencePositions = "1" + " " + n;
		
		for (int i = 0; i < n-1; ++i) {
			int difference = Math.abs(a[i] - a[i+1]);
			if (difference < minDifference) {
				minDifference = difference;
				minDifferencePositions = (i+1) + " " + (i+2);
			}
		}
		
		System.out.println(minDifferencePositions);
		
		// Close scanner
		read.close();
	}

}
