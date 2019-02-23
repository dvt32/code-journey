// https://codeforces.com/problemset/problem/820/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int c = read.nextInt();
		int v0 = read.nextInt();
		int v1 = read.nextInt();
		int a = read.nextInt();
		int l = read.nextInt();
		
		// first day
		int dayCount = 1;
		c -= v0;
		
		// second day and so on...
		while (c > 0) {
			v0 = Math.min(v1, v0 + a);
			c -= (v0 - l);
			dayCount++;
		}
		
		System.out.println(dayCount);
		
		// Close scanner
		read.close();
	}

}
