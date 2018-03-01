// http://codeforces.com/problemset/problem/454/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		char[][] arr = new char[n][n];
		
		// Fill array with '*' initially
		for (int i = 0; i < arr.length; ++i) {
			Arrays.fill(arr[i], '*');
		}
		
		// Fill first half (from first row to middle row included) with diamonds
		int startIndex = arr.length / 2;
		int endIndex = arr.length / 2;
		for (int i = 0; i <= arr.length / 2; ++i) {
			for (int j = startIndex; j <= endIndex; ++j) {
				arr[i][j] = 'D';
			}
			startIndex--;
			endIndex++;
		}
		
		// Fill second half (after middle row) with diamonds
		startIndex = 1;
		endIndex = arr.length-2;
		for (int i = (arr.length/2 + 1); i < arr.length; ++i) {
			for (int j = startIndex; j <= endIndex; ++j) {
				arr[i][j] = 'D';
			}
			startIndex++;
			endIndex--;
		}
		
		
		// Print end result
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[i].length; ++j) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		// Close scanner
		read.close();
	}
	
}
