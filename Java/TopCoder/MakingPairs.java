// https://community.topcoder.com/stat?c=problem_statement&pm=14300

public class MakingPairs {
	public static int get(int[] card) {
		int maxNumberOfPairs = 0;
		
		for (int i = 0; i < card.length; ++i) {
			maxNumberOfPairs += (card[i] / 2);
		}
		
		return maxNumberOfPairs;
	}
}
