// http://codeforces.com/problemset/problem/509/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; ++i) {
			arr[0][i] = 1;
			arr[i][0] = 1;
		}
		
		for (int i = 1; i < n; ++i) {
			for (int j = 1; j < n; ++j) {
				arr[i][j] =  (arr[i][j-1] + arr[i-1][j]);
			}
		}
		
		int maxElement = arr[n-1][n-1];
		System.out.println(maxElement);
		
		// Close scanner
		read.close();
	}
	
}
