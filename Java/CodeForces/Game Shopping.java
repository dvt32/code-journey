// https://codeforces.com/problemset/problem/1009/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		
		int[] c = new int[n]; // game prices
		for (int i = 0; i < n; ++i) {
			c[i] = read.nextInt();
		}
		
		int[] a = new int[m]; // wallet bills
		for (int i = 0; i < m; ++i) {
			a[i] = read.nextInt();
		}
		
		int numberOfBoughtGames = 0;
		for (int i = 0, j = 0; i < n && j < m; ++i) {
			if (a[j] >= c[i]) {
				numberOfBoughtGames++;
				j++;
			}
		}
		
		System.out.println(numberOfBoughtGames);
		
		// Close scanner
		read.close();
	}

}
