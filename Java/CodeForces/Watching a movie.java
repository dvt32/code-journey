// http://codeforces.com/problemset/problem/499/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt(); // number of best moments
		int x = read.nextInt(); // number of minutes 2nd button can skip
		
		int currentMinute = 1;
		int minNumberOfMinutes = 0;
		for (int i = 0; i < n; ++i) {
			int l = read.nextInt(); // best moment start minute
			int r = read.nextInt(); // best moment end minute
			
			while ( (currentMinute + x) <= l ) {
				currentMinute += x;
			}
			
			minNumberOfMinutes += (r-currentMinute+1);
			currentMinute = r+1;
		}
		
		System.out.println(minNumberOfMinutes);
		
		// Close scanner
		read.close();
	}
}
