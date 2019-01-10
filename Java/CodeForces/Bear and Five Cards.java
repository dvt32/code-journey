// https://codeforces.com/problemset/problem/680/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int[] t = new int[5];
		int totalSum = 0;
		
		for (int i = 0; i < 5; ++i) {
			t[i] = read.nextInt();
			totalSum += t[i];
		}
		
		int minSum = totalSum;
		
		for (int i = 0; i < 5; ++i) {
			for (int j = i+1; j < 5; ++j) {
				if (t[i] == t[j]) {
					minSum = Math.min(minSum, totalSum - 2*t[i]);
				}
			}
		}
		
		for (int i = 0; i < 5; ++i) {
			for (int j = i+1; j < 5; ++j) {
				for (int k = j+1; k < 5; ++k) {
					if (t[i] == t[j] && t[i] == t[k]) {
						minSum = Math.min(minSum, totalSum - 3*t[i]);
					}
				}
				
			}
		}
		
		System.out.println(minSum);
		
		// Close scanner
		read.close();
	}

}
