// https://codeforces.com/problemset/problem/278/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] d = new int[n];
		for (int i = 0; i < n; ++i) {
			d[i] = read.nextInt();
		}
		
		int s = read.nextInt();
		int t = read.nextInt();
		
		int forwardPathLength = 0;
		int backwardPathLength = 0;
		
		if (s < t) {
			// Go forward
			for (int i = s-1; i < t-1; ++i) {
				forwardPathLength += d[i];
			}
			// Go backward
			for (int i = s-2; i >= 0; --i) {
				backwardPathLength += d[i];
			}
			for (int i = n-1; i >= t-1; --i) {
				backwardPathLength += d[i];
			}
		}
		else if (s > t) {
			// Go backward
			for (int i = s-2; i >= t-1; --i) {
				backwardPathLength += d[i];
			}
			// Go forward
			for (int i = s-1; i < n; ++i) {
				forwardPathLength += d[i];
			}
			for (int i = 0; i < t-1; ++i) {
				forwardPathLength += d[i];
			}
		}
		
		System.out.println(
			Math.min(forwardPathLength, backwardPathLength)
		);
		
		// Close scanner
		read.close();
	}

}
