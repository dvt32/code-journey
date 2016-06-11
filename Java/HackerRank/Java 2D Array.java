// https://www.hackerrank.com/challenges/java-2d-array

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int[][] a = new int[6][6];
		int maxHourglassSum = Integer.MIN_VALUE;
		
		// Enter elements
		for (int i = 0; i < a.length; ++i) {
			for (int j = 0; j < a.length; ++j) {
				a[i][j] = read.nextInt();
			}
		}
		
		// Calculate max hour glass sum
		for (int i = 0; i < a.length - 2; ++i) {
			int currentHourglassSum = 0;
			for (int j = 0; j < a.length - 2; ++j) {
				currentHourglassSum = 
						a[i][j] + a[i][j+1] + a[i][j+2] +
						a[i+1][j+1] +
						a[i+2][j] + a[i+2][j+1] + a[i+2][j+2];
				if (currentHourglassSum > maxHourglassSum) {
					maxHourglassSum = currentHourglassSum;
				}
			}
		}
		
		// Print end result
		System.out.println(maxHourglassSum);
		
		// Close scanner
		read.close();
	}
}
