// https://codeforces.com/problemset/problem/658/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int c = read.nextInt();
		
		int[] p = new int[n];
		for (int i = 0; i < n; ++i) {
			p[i] = read.nextInt();
		}
		
		int[] t = new int[n];
		for (int i = 0; i < n; ++i) {
			t[i] = read.nextInt();
		}
		
		int limakPoints = 0;
		int x = 0;
		for (int i = 0; i < n; ++i) {
			x += t[i];
			limakPoints += Math.max(0, p[i] - c * x);
		}
		
		int radewooshPoints = 0;
		x = 0;
		for (int i = n-1; i >= 0; --i) {
			x += t[i];
			radewooshPoints += Math.max(0, p[i] - c * x);
		}
		
		if (limakPoints > radewooshPoints) {
			System.out.println("Limak");
		}
		else if (limakPoints < radewooshPoints) {
			System.out.println("Radewoosh");
		}
		else {
			System.out.println("Tie");
		}
		
		// Close scanner
		read.close();
	}

}
