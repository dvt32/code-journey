// https://community.topcoder.com/stat?c=problem_statement&pm=11741

public class PairingPawns {
	public static int savedPawnCount(int[] start) {
		boolean pairPawnValueExists = true;
		
		while (pairPawnValueExists) {
			for (int i = 1; i < start.length; ++i) {
				pairPawnValueExists = false;
				if (start[i] >= 2) {
					pairPawnValueExists = true;
					start[i] -= 2;
					start[i-1] += 1;
					break;
				}
			}
		}
		
		int maxPawnCount = start[0];
		
		return maxPawnCount;
	}
}
