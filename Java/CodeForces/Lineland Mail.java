// http://codeforces.com/problemset/problem/567/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] x = new int[n];
		for (int i = 0; i < n; ++i) {
			x[i] = read.nextInt();
		}
		
		// Handle first element
		int min = Math.abs( x[0]-x[1] );
		int max = Math.abs( x[0]-x[n-1] );
		System.out.println(min + " " + max);
		
		// Handle elements in range 1..n-1
		for (int i = 1; i < n-1; ++i) {
			min = Math.min( 
				Math.abs( x[i]-x[i-1] ),
				Math.abs( x[i]-x[i+1] )
			);
			
			max = Math.max( 
				Math.abs( x[i]-x[n-1] ),
				Math.abs( x[i]-x[0] )
			);
			System.out.println(min + " " + max);
		}
		
		// Last element
		min = Math.abs( x[n-1]-x[n-2]);
		max = Math.abs( x[n-1]-x[0] );
		System.out.println(min + " " + max);
		
		// Close scanner
		read.close();
	}
	
}
