// http://codeforces.com/problemset/problem/918/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		StringBuilder name = new StringBuilder();
		for (int i = 1; i <= n; ++i) {
			if (isFibonacciNumber(i)) {
				name.append("O");
			}
			else {
				name.append("o");
			}
		}
		
		System.out.println(name);
		
		// Close scanner
		read.close();
	}

	private static boolean isFibonacciNumber(int i) {
		return isPerfectSquare(5*i*i + 4) || isPerfectSquare(5*i*i - 4);
	}
	
	private static boolean isPerfectSquare(int number) {
		int sqrt = (int) Math.sqrt(number);
		return ( number == (sqrt*sqrt) );
	}
	
}
