// http://codeforces.com/problemset/problem/946/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int B = 0;
		int C = 0;
		
		for (int i = 0; i < n; ++i) {
			int number = read.nextInt();
			if (number < 0) {
				C += number;
			}
			else {
				B += number;
			}
		}
		
		System.out.println( B-C );
		
		// Close scanner
		read.close();
	}
}
