// https://codeforces.com/problemset/problem/616/B

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		
		int finalPrice = Integer.MIN_VALUE;
		int[][] c = new int[n][m];
		
		for (int i = 0; i < n; ++i) {
			int minimumPriceOnStreet = Integer.MAX_VALUE;
			for (int j = 0; j < m; ++j) {
				c[i][j] = read.nextInt();
				// Jack wants to pick the avenue on each street with the minimum price
				minimumPriceOnStreet = Math.min(minimumPriceOnStreet, c[i][j]);
			}
			// Emma knows Jack's game and picks the street with the largest minimum value.
			finalPrice = Math.max(finalPrice, minimumPriceOnStreet);
		}
		
		System.out.println(finalPrice);
		
		// Close scanner
		read.close();
	}

}
