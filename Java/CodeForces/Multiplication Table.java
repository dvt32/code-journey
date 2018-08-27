// http://codeforces.com/problemset/problem/577/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		int x = read.nextInt();
		
		int count = 0;
		for (int i = 1; i <= n; ++i) {
			if (x % i == 0 && x / i <= n) {
				count++;
			}
		}
		
		System.out.println(count);
		
		// Close scanner
		read.close();
	}
}
