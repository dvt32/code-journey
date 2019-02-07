// https://codeforces.com/problemset/problem/408/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] k = new int[n];
		for (int i = 0; i < n; ++i) {
			k[i] = read.nextInt();
		}
		
		int minTimeNeeded = Integer.MAX_VALUE;
		for (int i = 0; i < n; ++i) {
			int currentTimeNeeded = 0;
			for (int j = 0; j < k[i]; ++j) {
				int m = read.nextInt();
				currentTimeNeeded += m * 5 + 15;
			}
			minTimeNeeded = Math.min(currentTimeNeeded, minTimeNeeded);
		}
		
		System.out.println(minTimeNeeded);
		
		// Close scanner
		read.close();
	}

}
