// https://codeforces.com/problemset/problem/604/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int[] x = { 500, 1000, 1500, 2000, 2500 };

		int[] m = new int[5];
		for (int i = 0; i < 5; ++i) {
			m[i] = read.nextInt();
		}
		
		int[] w = new int[5];
		for (int i = 0; i < 5; ++i) {
			w[i] = read.nextInt();
		}
		
		int hS = read.nextInt();
		int hU = read.nextInt();
		
		double kevinScore = hS  * 100;
		kevinScore -= hU * 50;
		for (int i = 0; i < 5; ++i) {
			kevinScore += Math.max(
				0.3 * x[i],
				(1.0 - m[i]/250.0) * x[i] - (50.0 * w[i])
			);
		}
		
		System.out.println( (int) kevinScore );
		
		// Close scanner
		read.close();
	}

}
