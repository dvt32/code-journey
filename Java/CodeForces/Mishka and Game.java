// http://codeforces.com/problemset/problem/703/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int mishkaWinCount = 0;
		int chrisWinCount = 0;
		for (int i = 0; i < n; ++i) {
			int m = read.nextInt();
			int c = read.nextInt();
			if (m > c) {
				mishkaWinCount++;
			}
			else if (c > m) {
				chrisWinCount++;
			}
		}
		
		if (mishkaWinCount > chrisWinCount) {
			System.out.println("Mishka");
		}
		else if (chrisWinCount > mishkaWinCount) {
			System.out.println("Chris");
		}
		else {
			System.out.println("Friendship is magic!^^");
		}
		
		// Close scanner
		read.close();
	}
	
}
