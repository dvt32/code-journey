// https://community.topcoder.com/stat?c=problem_statement&pm=11631

import java.util.Arrays;

public class DengklekTryingToSleep {
	public static int minDucks(int[] ducks) {
		if (ducks.length <= 1) {
			return 0;
		}
		
		Arrays.sort(ducks);
		
		int numberOfMissedDucks = 0;
		for (int A = ducks[0], B = ducks[ducks.length-1]; A <= B; ++A) {
			boolean duckFound = false;
			for (int i = 0; i < ducks.length; ++i) {
				if (ducks[i] == A) {
					duckFound = true;
					break;
				}
			}
			if (!duckFound) {
				numberOfMissedDucks++;
			}
		}
		
		return numberOfMissedDucks;
	}
}
