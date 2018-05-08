// http://codeforces.com/problemset/problem/34/B

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		Arrays.sort(a);
		
		int maxSum = 0;
		for (int i = 0; i < m && a[i] < 0; ++i) {
			maxSum += (-a[i]);
		}
		
		System.out.println(maxSum);
		
		// Close scanner
		read.close();
	}
	
}
