// http://codeforces.com/problemset/problem/672/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		StringBuilder digits = new StringBuilder();
		for (int i = 1; i <= n; ++i) {
			digits.append(String.valueOf(i));
		}
		
		System.out.println( digits.charAt(n-1) );
		
		// Close scanner
		read.close();
	}
	
}
