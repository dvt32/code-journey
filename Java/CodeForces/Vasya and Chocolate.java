// https://codeforces.com/problemset/problem/1065/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int t = read.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int s = read.nextInt(); // number of roubles Vasya has
			int a = read.nextInt(); // number of chocolate bars you need to buy to get special offer
			int b = read.nextInt(); // number of bars you get for free
			int c = read.nextInt(); // cost of one bar
			
			long maxNumberOfBoughtBars = s / c;
			long numberOfFreeBarsAcquired = (long) (maxNumberOfBoughtBars / a) * b;
			long result = maxNumberOfBoughtBars + numberOfFreeBarsAcquired;
			
			System.out.println(result);
		}
		
		// Close scanner
		read.close();
	}

}
