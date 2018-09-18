// http://codeforces.com/problemset/problem/439/A
// With help from http://codeforces.com/blog/entry/12545

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int d = read.nextInt();
		
		int sum = 0;
		for (int i = 0; i < n; ++i) {
			int t = read.nextInt();
			sum += t;
		}
		
		int minDuration = sum  + (n-1) * 10;
		if (minDuration <= d) {
			int maxJokes = (d - sum) / 5;
			System.out.println(maxJokes);
		}
		else {
			System.out.println("-1");
		}
		
		
		// Close scanner
		read.close();
	}

}
