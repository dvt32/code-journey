// https://codeforces.com/problemset/problem/691/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		if (n == 1) {
			System.out.println(
				read.nextInt() == 1 ? "YES" : "NO"
			);
		}
		else {
			int zeroCount = 0;
			for (int i = 0; i < n; ++i) {
				int a = read.nextInt();
				if (a == 0) { 
					zeroCount++;
					if (zeroCount > 1) {
						break;
					}
				}
			}
			
			System.out.println(
				zeroCount == 1 ? "YES" : "NO"
			);
		}
		
		// Close scanner
		read.close();
	}

}
