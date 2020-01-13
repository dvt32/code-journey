// https://codeforces.com/problemset/problem/1162/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt(); // spot count
		int h = read.nextInt(); // max height
		int m = read.nextInt(); // restriction count
		
		int[] l = new int[m];
		int[] r = new int[m];
		int[] x = new int[m];
		for (int i = 0; i < m; ++i) {
			l[i] = read.nextInt();
			r[i] = read.nextInt();
			x[i] = read.nextInt();
		}
		
		int result = 0;
		for (int i = 0; i < n; ++i) {
			int currentSpotIndex = i+1;
			int maxAllowedHeightForCurrentSpot = h;
			for (int j = 0; j < m; ++j) {
				if (currentSpotIndex >= l[j] && currentSpotIndex <= r[j]) {
					maxAllowedHeightForCurrentSpot = Math.min(maxAllowedHeightForCurrentSpot, x[j]);
				}
			}
			result += Math.pow(maxAllowedHeightForCurrentSpot, 2);
		}
		
		System.out.println(result);
		
		// Close scanner
		read.close();
	}

}
