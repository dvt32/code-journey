// http://codeforces.com/problemset/problem/915/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int k = read.nextInt();
		
		int maxDivisor = Integer.MIN_VALUE;
		for (int i = 0; i < n; ++i) {
			int a = read.nextInt();
			if (k % a == 0 && a > maxDivisor) {
				maxDivisor = a;
			}
		}
		
		System.out.println(k / maxDivisor);
		
		// Close scanner
		read.close();
	}
	
}
