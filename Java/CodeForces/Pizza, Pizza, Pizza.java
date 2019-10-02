// https://codeforces.com/problemset/problem/979/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		long n = read.nextLong();
		
		if (n == 0) { 
			System.out.println("0"); 
		}
		else {
			System.out.println(
				(n+1) % 2 == 0
				? (n+1)/2
				: n+1
			);
		}
		
		// Close scanner
		read.close();
	}

}
