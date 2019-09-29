// https://codeforces.com/problemset/problem/631/A

// https://codeforces.com/blog/entry/43551

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		long[] a = new long[n];
		long[] b = new long[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextLong();
		}
		for (int i = 0; i < n; ++i) {
			b[i] = read.nextLong();
		}
		
		long sum1 = a[0];
		long sum2 = b[0];
		for (int i = 1; i < n; ++i) {
			sum1 |= a[i];
			sum2 |= b[i];
		}
		
		System.out.println( sum1 + sum2 );

		// Close scanner
		read.close();
	}

}
