// https://community.topcoder.com/stat?c=problem_statement&pm=14295

import java.util.Deque;
import java.util.ArrayDeque;

public class PriorityQueue {
	public static int findAnnoyance(String S, int[] a) {
		Deque<Integer> canteenQueue = new ArrayDeque<Integer>();
		int totalDispleasure = 0;
		
		for (int i = 0; i < S.length(); ++i) {
			char currentChar = S.charAt(i);
			
			if (currentChar == 'b') {
				for (Integer cutoffChildIndex : canteenQueue) {
					totalDispleasure += a[cutoffChildIndex];
				}
				canteenQueue.addFirst(i);
			}
			else { // currentChar == 'e'
				canteenQueue.addLast(i);
			}
		}
		
		return totalDispleasure;
	}
}
