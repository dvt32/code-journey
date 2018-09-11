// http://codeforces.com/problemset/problem/935/B

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		// Clear buffer
		read.nextLine();
		
		String s = read.nextLine();
		
		int x = 0;
		int y = 0;
		int numberOfSilverCoins = 0;
		for (int i = 0; i < n-1; ++i) {
			char c = s.charAt(i);
			if (c == 'R') {
				x++;
			}
			else {
				y++;
			}
			if (x == y && c == s.charAt(i+1)) {
				numberOfSilverCoins++;
			}
		}
		
		System.out.println(numberOfSilverCoins);
		
		// Close scanner
		read.close();
	}

}
