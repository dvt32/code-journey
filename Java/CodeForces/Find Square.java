// http://codeforces.com/problemset/problem/1028/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		
		read.nextLine();

		char[][] s = new char[n][m];
		for (int i = 0; i < n; ++i) {
			s[i] = read.nextLine().toCharArray();
		}
		
		int xMin = Integer.MAX_VALUE;
		int xMax = Integer.MIN_VALUE;
		int yMin = Integer.MAX_VALUE;
		int yMax = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (s[i][j] == 'B') {
					xMin = Math.min(i, xMin);
					xMax = Math.max(i, xMax);
					yMin = Math.min(j, yMin);
					yMax = Math.max(j, yMax);
				}
 			}
		}
		
		System.out.println( 
			( (xMin+xMax)/2 + 1 )
			+ " " +
			( (yMin+yMax)/2 + 1 )
		);
		
		// Close scanner
		read.close();
	}

}
