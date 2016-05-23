// https://www.hackerrank.com/challenges/maximum-draws

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		// Enter & validate input
		int T = read.nextInt();
		if (T < 1 || T > 1000) {
			read.close();
			return;
		}
		
		// Get max number of draws to get a matching pair of socks and print end result
		
		/*
		 * Explanation:
		 * 	Max number of draws for a match is always N + 1.
		 *  
		 *  Let's say that N = 4.
		 *  
		 *  Then we have these socks in the basket (P1 means Pair 1 and we have 2, because each pair has 2 socks):
		 *  
		 *  P1, P2, P3, P4,
		 *  P1, P2, P3, P4.
		 *  
		 *  Let's declare a variable that keeps track of the number of draws we've made so far.
		 *  
		 *  D = 0
		 *  
		 *  Now let's draw a sock. Let's say we get a P1 sock => D = 1.
		 *  In the best case scenario, we'll get a P1 sock right after,
		 *  but in the worst case - we'll get a sock from all the other pairs first.
		 *  We have 4 pairs and we already have one from the 1st pair, so to get a sock from all the other pairs
		 *  we need to draw 3 more times (for P2, P3, P4 respectively). 
		 *  
		 *  Now D = 4.
		 *  
		 *  We have a sock from each pair at this point, so all it takes is one more sock for us to have a matching pair at this time.
		 *  
		 *  Hence D = 5 and we have our max number of draws (worst case scenario) to get matching socks.
		 *  
		 *  Yay!
		 */
		
		for (int i = 0; i < T; ++i) {
			int N = read.nextInt();
			if (N <= 0 || N >= Math.pow(10, 6)) {
				read.close();
				return;
			}
			int maxNumberOfDraws = N+1;
			System.out.println(maxNumberOfDraws);
		}
		
		// Close scanner
		read.close();
	}
}
