// http://codeforces.com/problemset/problem/758/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int maxBurles = 0;
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
			maxBurles = Math.max(maxBurles, a[i]);
		}
		
		int burlesToSpend = 0;
		for (int i = 0; i < n; ++i) {
			burlesToSpend += Math.abs(maxBurles - a[i]);
		}
		
		System.out.println(burlesToSpend);
		
		// Close scanner
		read.close();
	}
	
}
