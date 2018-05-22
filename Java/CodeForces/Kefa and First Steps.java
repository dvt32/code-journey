// http://codeforces.com/problemset/problem/580/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		int maxSubsegmentLength = 1;
		int subsegmentLength = 1;
		for (int i = 0; i < n-1; ++i) {
			if (a[i] <= a[i+1]) {
				subsegmentLength++;
				maxSubsegmentLength = Math.max(maxSubsegmentLength, subsegmentLength);
			}
			else {
				subsegmentLength = 1;
			}
		}
		
		System.out.println(maxSubsegmentLength);
		
		// Close scanner
		read.close();
	}
	
}
