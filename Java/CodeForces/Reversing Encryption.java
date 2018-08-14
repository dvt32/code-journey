// http://codeforces.com/problemset/problem/999/B

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		read.nextLine();
		
		String t = read.nextLine();
		
		for (int d = 1; d <= n; ++d) {
			if (n % d == 0) {
				t = new StringBuilder(t.substring(0, d)).reverse().toString() + t.substring(d);
			}
		}
		
		System.out.println(t);
		
		// Close scanner
		read.close();
	}
}
