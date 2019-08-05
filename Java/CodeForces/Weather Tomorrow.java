// https://codeforces.com/problemset/problem/847/M

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] t = new int[n];
		for (int i = 0; i < n; ++i) {
			t[i] = read.nextInt();
		}
		
		boolean isArithmeticProgression = true;
		int commonDifference = t[0] - t[1];
		for (int i = 1; i < n-1; ++i) {
			int difference = t[i] - t[i+1];
			if (difference != commonDifference) {
				isArithmeticProgression = false;
				break;
			}
		}
		
		System.out.println( 
			isArithmeticProgression 
			? t[n-1] - commonDifference 
			: t[n-1]
		);
		
		// Close scanner
		read.close();
	}

}
