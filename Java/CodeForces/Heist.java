// http://codeforces.com/problemset/problem/1041/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		Arrays.sort(a);
		
		int minNumberOfStolenKeyboards = 0;
		for (int i = 1; i < n; ++i) {
			minNumberOfStolenKeyboards += (a[i] - a[i-1] - 1);
		}
		
		System.out.println(minNumberOfStolenKeyboards);

		// Close scanner
		read.close();
	}

}
