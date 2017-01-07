// https://community.topcoder.com/stat?c=problem_statement&pm=11336

public class GogoXBallsAndBinsEasy {
	public static int solve(int[] T) {
		int movesCount = 0;
		
		// The trick here - how many balls would you move to sort the array in descending order?
		
		/*
		 * 	For example:
		 * 	  T[] = { 1, 2, 3, 4, 5, 6, 7, 8 }
		 * 
		 * 	When sorted in descending order, it would look like this:
		 * 	  T_sorted[] = { 8, 7, 6, 5, 4, 3, 2, 1 }
		 * 
		 * 	T[] is sorted in ascending order, so to switch to descending order, simply switch first element with last element
		 * 		1 with 8, 
		 * 		2 with 7 etc.
		 * 
		 *  When doing this, simply count how many balls have actually been moved (that is - the difference between the larger element and the smaller one)
		 *  For example: when switching 1 with 8, you need the difference between 8 and 1, which is 7 
		 *  (since you added 7 balls to the first bin and removed 7 from the last one)
		 *  
		 *  Store these differences in a variable.
		 *  This is your end result.
		 * 
		 */
		
		int lastBallIndex = T.length - 1;
		for (int i = 0; i < (T.length / 2); ++i) {
			movesCount += T[lastBallIndex-i] - T[i];
 		}
		
		return movesCount;
	}
}
