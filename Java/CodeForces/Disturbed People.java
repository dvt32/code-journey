// https://codeforces.com/problemset/problem/1077/B

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		int k = 0;
		for (int i = 1; i < n-1; ++i) {
			if (a[i] == 0 && a[i-1] == 1 && a[i+1] == 1) {
				k++;
				a[i+1] = 0;
			}
		}
		
		System.out.println(k);
		
		// Close scanner
		read.close();
	}

}
