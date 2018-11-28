// http://codeforces.com/problemset/problem/884/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		final int NUMBER_OF_SECONDS_IN_ONE_DAY = 86400;
		
		int n = read.nextInt();
		int t = read.nextInt();
		
		int dayCount = 0;
		for (int i = 0; i < n; ++i) {
			int a = read.nextInt();
			int freeTimeInSeconds = Math.abs(NUMBER_OF_SECONDS_IN_ONE_DAY - a);
			t -= freeTimeInSeconds;
			dayCount++;
			
			if (t <= 0) {
				break;
			}
		}
		
		System.out.println(dayCount);
		
		// Close scanner
		read.close();
	}

}
