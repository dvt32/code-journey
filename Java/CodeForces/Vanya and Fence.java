// http://codeforces.com/problemset/problem/677/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		int h = read.nextInt();
		
		int sum = 0;
		for (int i = 0; i < n; ++i) {
			int a = read.nextInt();
			if (a > h) {
				sum += 2;
			}
			else {
				sum++;
			}
		}
		
		System.out.println(sum);
		
		// Close scanner
		read.close();
	}
}
