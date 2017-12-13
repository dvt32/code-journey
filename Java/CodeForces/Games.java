// http://codeforces.com/problemset/problem/268/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int[] h = new int[n];
		int[] a = new int[n];
		
		for (int i = 0; i < n; ++i) {
			h[i] = read.nextInt();
			a[i] = read.nextInt();
		}
		
		int numberOfGamesPlayedInGuestUniform = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (h[i] == a[j]) {
					numberOfGamesPlayedInGuestUniform++;
				}
			}
		}
		
		System.out.println( numberOfGamesPlayedInGuestUniform );
		
		// Close scanner
		read.close();
	}
	
}
