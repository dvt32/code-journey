// https://codeforces.com/problemset/problem/426/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int s = read.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		Arrays.parallelSort(a);
		
		int minSum = 0;
		for (int i = 0; i < n-1; ++i) {
			minSum += a[i];
		}
		
		System.out.println( minSum <= s ? "YES" : "NO" );

		// Close scanner
		read.close();
	}

}
