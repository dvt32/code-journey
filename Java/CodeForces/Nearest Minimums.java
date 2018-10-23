// http://codeforces.com/problemset/problem/911/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();

		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
			if (a[i] < min) {
				min = a[i];
				minIndex = i;
			}
		}
		
		int minDifference = Integer.MAX_VALUE;
		for (int i = minIndex+1; i < n; ++i) {
			if (a[i] == min) {
				int difference = Math.abs(i - minIndex);
				if (difference < minDifference) {
					minDifference = difference;
				}
				minIndex = i;
			}
		}
		
		System.out.println(minDifference);
		
		// Close scanner
		read.close();
	}

}
