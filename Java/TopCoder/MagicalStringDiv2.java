// https://community.topcoder.com/stat?c=problem_statement&pm=13004

public class MagicalStringDiv2 {
	public static int minimalMoves(String S) {
		int minMovesCount = 0;
		
		for (int i = 0, j = S.length()-1; i < j; ++i, --j) {
			if (S.charAt(i) != '>') {
				minMovesCount++;
			}
			if (S.charAt(j) != '<') {
				minMovesCount++;
			}
		}
		
		return minMovesCount;
	}
}
