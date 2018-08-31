// http://codeforces.com/problemset/problem/581/B

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		int[] h = new int[n];
		for (int i = 0; i < n; ++i) {
			h[i] = read.nextInt();
		}
		
		int[] maxToTheRightOf = new int[n];
		int max = 0;
		for (int i = n-1; i >= 0; --i) {
			maxToTheRightOf[i] = max;
			if (h[i] > max) {
				max = h[i];
			}
		}
		
		for (int i = 0; i < n; ++i) {
			int numberOfAddedFloors = (h[i] <= maxToTheRightOf[i]) ? (maxToTheRightOf[i] - h[i] + 1) : 0;
			System.out.print(numberOfAddedFloors + " ");
		}
		
		// Close scanner
		read.close();
	}
	
}
