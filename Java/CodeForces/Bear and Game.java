// https://codeforces.com/problemset/problem/673/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] t = new int[n+1];
		t[0] = 0;
		int numberOfWatchedMinutes = 0;
		
		for (int i = 1; i < t.length; ++i) {
			t[i] = read.nextInt();
			int difference = (t[i] - t[i-1]);
			if (difference <= 15) {
				numberOfWatchedMinutes = t[i];
			}
			else {
				numberOfWatchedMinutes += 15;
				break;
			}
		}
		
		if (numberOfWatchedMinutes == t[n]) {
			if ( (90 - t[n]) <= 15 ) {
				numberOfWatchedMinutes += (90 - t[n]);
			}
			else {
				numberOfWatchedMinutes += 15;
			}
		}
		
		System.out.println(numberOfWatchedMinutes);
		
		// Close scanner
		read.close();
	}

}
