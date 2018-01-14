// http://codeforces.com/problemset/problem/588/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int moneyPaid = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int i = 0; i < n; ++i) {
			int a = read.nextInt();
			int p = read.nextInt();
			minPrice = Math.min(p, minPrice);
			moneyPaid += a * minPrice;
		}
		
		System.out.println(moneyPaid);
		
		// Close scanner
		read.close();
	}
	
}
