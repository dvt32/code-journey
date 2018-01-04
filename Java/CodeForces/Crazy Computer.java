// http://codeforces.com/problemset/problem/716/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int c = read.nextInt();
		
		int wordCount = 1;
		int a = read.nextInt();
		for (int i = 1; i < n; ++i) {
			int b = read.nextInt();
			if ( (b - a) <= c ) {
				wordCount++;
			}
			else {
				wordCount = 1;
			}
			a = b;
		}
		
		System.out.println( wordCount );
		
		// Close scanner
		read.close();
	}
	
}
