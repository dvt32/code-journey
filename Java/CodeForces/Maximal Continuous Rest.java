// https://codeforces.com/problemset/problem/1141/B

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		int maxLength = 0;
		int currentLength = 0;
		
		for (int i = 0; i < n; ++i) {
			if (a[i] == 1) {
				currentLength++;
				maxLength = Math.max(maxLength, currentLength);
			}
			else {
				currentLength = 0;
			}
		}
		
		if (currentLength != 0) {
			for (int i = 0; i < n; ++i) {
				if (a[i] == 1) {
					currentLength++;
					maxLength = Math.max(maxLength, currentLength);
				}
				else {
					currentLength = 0;
				}
			}
		}
		
		System.out.println(maxLength);
		
		// Close scanner
		read.close();
	}

}
