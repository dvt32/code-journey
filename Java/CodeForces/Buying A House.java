// http://codeforces.com/problemset/problem/796/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		int k = read.nextInt();
		
		int[] a = new int[n];
		int minDistance = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
			if (a[i] != 0 && a[i] <= k) {
				int distanceBetweenGirlAndBoy = Math.abs(m-1 /*girl house index*/ - i) * 10;
				if (distanceBetweenGirlAndBoy < minDistance) {
					minDistance = distanceBetweenGirlAndBoy;
				}
			}
		}
		
		System.out.println(minDistance);
		
		// Close scanner
		read.close();
	}
	
}
