// https://codeforces.com/problemset/problem/821/A

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
		
		// Close scanner
		read.close();
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (a[i][j] != 1) {
					boolean foundSum = false;
					for (int k = 0; k < n; ++k) {
						for (int l = 0; l < n; ++l) {
							if ( (a[i][k] + a[l][j]) == a[i][j] ) {
								foundSum = true;
								break;
							}
						}
						if (foundSum) {
							break;
						}
					}
					if (!foundSum) {
						System.out.println("No");
						return;
					}
				}
			}
		}
		
		System.out.println("Yes");
	}

}
