// https://community.topcoder.com/stat?c=problem_statement&pm=5988

import java.util.Set;
import java.util.HashSet;

public class UniqueDigits {
	public static int count(int n) {
		int count = 0;
		
		for (int i = 1; i < n; ++i) {
			String currentNumber = String.valueOf(i);
			Set<Character> currentNumberUniqueDigits = new HashSet<Character>();
			for (int j = 0; j < currentNumber.length(); ++j) {
				currentNumberUniqueDigits.add( currentNumber.charAt(j) );
			}
			if ( currentNumberUniqueDigits.size() == currentNumber.length() ) {
				count++;
			}
		}
		
		return count;
	}
}
