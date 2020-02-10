// https://codeforces.com/problemset/problem/794/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int a = read.nextInt(); // Oleg position
		int b = read.nextInt(); // 1st guard position (left of Oleg)
		int c = read.nextInt(); // 2nd guard position (right of Oleg)
		
		int n = read.nextInt();
		
		int maxBanknotes = 0;
		for (int i = 0; i < n; ++i) {
			int x = read.nextInt();
			if (x > b && x < c) {
				maxBanknotes++;
			}
		}
		
		System.out.println(maxBanknotes);
		
		// Close scanner
		read.close();
	}

}
