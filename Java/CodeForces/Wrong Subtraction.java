// http://codeforces.com/problemset/problem/977/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int k = read.nextInt();
		
		for (int i = 0; i < k; ++i) {
			int lastDigit = n % 10;
			if (lastDigit != 0) {
				n--;
			}
			else {
				n /= 10;
			}
		}
		
		System.out.println(n);
		
		// Close scanner
		read.close();
	}
	
}
