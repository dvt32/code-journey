// http://codeforces.com/problemset/problem/595/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
	
		boolean[] hasLightsOn = new boolean[m*2];
		int numberOfFlatsWithLights = 0;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < (m*2); ++j) {
				hasLightsOn[j] = (read.nextInt() == 1) ? true : false;
			}
			for (int k = 0; k < hasLightsOn.length-1; k += 2) {
				if (hasLightsOn[k] || hasLightsOn[k+1]) {
					numberOfFlatsWithLights++;
				}
			}
		}
		
		System.out.println(numberOfFlatsWithLights);
		
		// Close scanner
		read.close();
	}
	
}
