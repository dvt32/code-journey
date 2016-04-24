// https://www.hackerrank.com/challenges/utopian-tree

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {	
		Scanner read = new Scanner(System.in);
	
		// Enter number of test cases and check if input is valid
		int T = read.nextInt();
		if (T < 1 || T > 10) {
			read.close();
			return;
		}
		
		// Enter T numbers
		for (int i = 0; i <  T; ++i) {
			int N = read.nextInt();
			// Check if input is valid
			if (N < 0 || N > 60) {
				read.close();
				return;
			}
			// Calculate height of Utopian Tree
			int heightOfUtopianTree = 1;
			for (int j = 0; j < N; ++j) {
				// If it's spring, double tree size
				if (j % 2 == 0) {
					heightOfUtopianTree *= 2;
				}
				// Otherwise it's summer, so increase tree size by 1 meter
				else {
					heightOfUtopianTree++;
				}
			}
			
			// Print end result
			System.out.println(heightOfUtopianTree);
	
		}

		// Close scanner
		read.close();
	}
}
