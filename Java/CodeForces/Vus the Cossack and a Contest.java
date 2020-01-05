// https://codeforces.com/problemset/problem/1186/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		int k = read.nextInt();
		
		System.out.println( 
			(m >= n && k >= n) 
			? "Yes" 
			: "No" 
		);
	
		// Close scanner
		read.close();
	}

}
