// https://codeforces.com/problemset/problem/1271/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int a = read.nextInt(); // tie count
		int b = read.nextInt(); // scarf count
		int c = read.nextInt(); // vest count
		int d = read.nextInt(); // jacket count
		
		int e = read.nextInt(); // 1st type suit (1 tie + 1 jacket) price
		int f = read.nextInt(); // 2nd type suit (1 scarf + 1 vest + 1 jacket) price
		
		int maxCost = 0;
		int numberOfFirstTypeSuits = 0;
		int numberOfSecondTypeSuits = 0;
		
		if (e > f) {
			int min = Math.min(a, d);
			numberOfFirstTypeSuits = min;
			d -= min;
			numberOfSecondTypeSuits = Math.min(b, Math.min(c, d));
		}
		else {
			int min = Math.min(b, Math.min(c, d));
			numberOfSecondTypeSuits = min;
			d -= min;
			numberOfFirstTypeSuits = Math.min(a, d);
		}
		
		maxCost = numberOfFirstTypeSuits * e + numberOfSecondTypeSuits * f;
		System.out.println(maxCost);
		
		// Close scanner
		read.close();
	}

}
