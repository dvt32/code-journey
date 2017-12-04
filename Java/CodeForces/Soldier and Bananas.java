// http://codeforces.com/problemset/problem/546/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int k = read.nextInt();
		int n = read.nextInt();
		int w = read.nextInt();
		
		int moneyNeeded = 0;
		for (int i = 1; i <= w; ++i) {
			moneyNeeded += (k*i);
		}
		
		if (n >= moneyNeeded) {
			System.out.println("0");
		}
		else {
			int borrowedMoney = Math.abs(n - moneyNeeded);
			System.out.println(borrowedMoney);
		}
		
		// Close scanner
		read.close();
	}
	
}
