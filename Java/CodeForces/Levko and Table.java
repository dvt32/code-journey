// https://codeforces.com/problemset/problem/361/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int k = read.nextInt();
		
		int[][] board = new int[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				board[i][j] = 0;
			}
		}
		
		for (int i = 0, j = 0; 
			 i < n && j < n; 
			 ++i, ++j) 
		{
			board[i][j] = k;
		}
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		// Close scanner
		read.close();
	}

}
