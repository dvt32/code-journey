// http://codeforces.com/problemset/problem/177/A1

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[][] a = new int[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				a[i][j] = read.nextInt();
			}
		}
		
		int sum = 0;
		
		// Main diagonal
		for (int i = 0, j = 0; 
			 i < n && j < n; 
			 ++i, ++j) 
		{
			sum += a[i][j];
		}
		
		// Secondary diagonal
		for (int i = 0, j = n-1; 
			 i < n && j >= 0; 
			 ++i, --j) 
		{
			sum += a[i][j];
		}
		
		// Middle row
		for (int i = n/2, j = 0; j < n; ++j) {
			sum += a[i][j];
		}
		
		// Middle column
		for (int i = 0, j = n/2; i < n; ++i) {
			sum += a[i][j];
		}
		
		// Subtract middle element of matrix 3 times,
		// because it was added to the sum while traversing the main diagonal
		sum -= a[n/2][n/2] * 3;
		
		System.out.println(sum);
		
		// Close scanner
		read.close();
	}

}
