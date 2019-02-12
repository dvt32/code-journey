// https://codeforces.com/problemset/problem/276/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int k = read.nextInt();
		
		int maxJoy = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; ++i) {
			int f = read.nextInt();
			int t = read.nextInt();
			int joy = 0;
			if (t > k) {
				joy = f - (t - k);
			}
			else {
				joy = f;
			}
			maxJoy = Math.max(maxJoy, joy);
		}
		
		System.out.println(maxJoy);
		
		// Close scanner
		read.close();
	}

}
