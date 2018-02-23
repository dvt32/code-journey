// http://codeforces.com/problemset/problem/214/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		int m = read.nextInt();
		
		final int MAX_A_VALUE = 31; // 32^2 = 1024, so equation can't be met
		final int MAX_B_VALUE = 31; // 32^2 = 1024, so equation can't be met

		int answerCount = 0;
		for (int a = 0; a <= MAX_A_VALUE; ++a) {
			for (int b = 0; b <= MAX_B_VALUE; ++b) {
				int firstEquation = (a*a + b);
				int secondEquation = (a + b*b);
				if (firstEquation == n && secondEquation == m) {
					answerCount++;
				}
			}
		}
		
		System.out.println(answerCount);
		
		// Close scanner
		read.close();
	}
	
}
