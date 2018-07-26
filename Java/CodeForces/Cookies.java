// https://codeforces.com/problemset/problem/129/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		int[] a = new int[n];
		int sum = 0;
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
			sum += a[i];
		}
		
		int numberOfWays = 0;
		for (int i = 0; i < n; ++i) {
			if ( (sum - a[i]) % 2 == 0 ) {
				numberOfWays++;
			}
		}
		
		System.out.println(numberOfWays);
		
		// Close scanner
		read.close();
	}
}
