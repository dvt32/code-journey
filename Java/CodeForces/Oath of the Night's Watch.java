// http://codeforces.com/problemset/problem/768/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] stewardStrengths = new int[n];
		int minStewardStrength = Integer.MAX_VALUE;
		int maxStewardStrength = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; ++i) {
			stewardStrengths[i] = read.nextInt();
			minStewardStrength = Math.min(minStewardStrength, stewardStrengths[i]);
			maxStewardStrength = Math.max(maxStewardStrength, stewardStrengths[i]);
		}
		
		int numberOfFedStewards = 0;
		for (int i = 0; i < n; ++i) {
			if (stewardStrengths[i] != minStewardStrength &&
				stewardStrengths[i] != maxStewardStrength) 
			{
				numberOfFedStewards++;
			}
		}
		
		System.out.println(numberOfFedStewards);
		
		// Close scanner
		read.close();
	}
	
}
