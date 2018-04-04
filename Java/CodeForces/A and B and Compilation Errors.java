// http://codeforces.com/problemset/problem/519/B

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		long a = 0;
		for (int i = 0; i < n; ++i) {
			a += read.nextInt();
		}
		
		long b = 0;
		for (int i = 0; i < n-1; ++i) {
			b += read.nextInt();
		}
		
		long c = 0;
		for (int i = 0; i < n-2; ++i) {
			c += read.nextInt();
		}
		
		System.out.println( a-b );
		System.out.println( b-c );
		
		// Close scanner
		read.close();
	}
	
}
