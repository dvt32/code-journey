// http://codeforces.com/problemset/problem/486/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		long n = read.nextLong();
		
		if (n % 2 == 0) {
			System.out.println( n / 2 );
		}
		else {
			System.out.println( -1 * ((n+1)/2) );
		}
		
		// Close scanner
		read.close();
	}
	
}
