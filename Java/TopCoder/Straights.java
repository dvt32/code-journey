// https://community.topcoder.com/stat?c=problem_statement&pm=4561

public class Straights {
	public static int howMany(int[] hand, int k) {
		int straightCount = 0;
	
		for (int sequenceStartIndex = 0; (sequenceStartIndex+k) <= hand.length; ++sequenceStartIndex) 
		{
			int product = 1;
			
			for (int sequenceElementIndex = 0; sequenceElementIndex < k; ++sequenceElementIndex) {
				product *= hand[sequenceStartIndex + sequenceElementIndex];
			}
			
			straightCount += product;
		}
		
		return straightCount;
	}
}
