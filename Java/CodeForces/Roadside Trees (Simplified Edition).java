// https://codeforces.com/problemset/problem/265/B

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] h = new int[n];
		for (int i = 0; i < n; ++i) {
			h[i] = read.nextInt();
		}
		
		int currentHeight = 0;
		int minNumberOfSeconds = 0;
		
		for (int i = 0; i < n; ++i) {
			if (currentHeight <= h[i]) {
				minNumberOfSeconds += (h[i] - currentHeight); // climb up until nut is reached
			}
			else {
				minNumberOfSeconds += (currentHeight - h[i]); // climb down until nut is reached
			}
			minNumberOfSeconds++; // eat nut
			currentHeight = h[i]; // you are now at the top of the tree
			if (i+1 < n) { // if there is a next tree
				if (currentHeight > h[i+1]) {
					minNumberOfSeconds += (currentHeight - h[i+1]);
					currentHeight = h[i+1];
				}
				minNumberOfSeconds++; // jump to next tree
			}
		}
		
		System.out.println(minNumberOfSeconds);
		
		// Close scanner
		read.close();
	}

}
