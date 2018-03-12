// http://codeforces.com/problemset/problem/688/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		int d = read.nextInt();
		
		read.nextLine(); // clear buffer
		
		int maxConsecutiveWins = 0;
		int currentConsecutiveWins = 0;
		
		for (int i = 0; i < d; ++i) {
			String opponents = read.nextLine();
			if ( opponents.contains("0") ) {
				currentConsecutiveWins++;
			}
			else {
				if (currentConsecutiveWins > maxConsecutiveWins) {
					maxConsecutiveWins = currentConsecutiveWins;
				}
				currentConsecutiveWins = 0;
			}
		}
		
		if (currentConsecutiveWins > maxConsecutiveWins) {
			maxConsecutiveWins = currentConsecutiveWins;
		}
		
		System.out.println(maxConsecutiveWins);
		
		// Close scanner
		read.close();
	}
	
}
