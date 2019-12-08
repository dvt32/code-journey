// https://codeforces.com/problemset/problem/1206/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] a = new int[n];
		int aMax = Integer.MIN_VALUE;
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
			aMax = Math.max(aMax, a[i]);
		}
		
		int m = read.nextInt();
		
		int[] b = new int[m];
		int bMax = Integer.MIN_VALUE;
		for (int i = 0; i < m; ++i) {
			b[i] = read.nextInt();
			bMax = Math.max(bMax, b[i]);
		}
		
		System.out.println(aMax + " " + bMax);
		
		// Close scanner
		read.close();
	}

}
