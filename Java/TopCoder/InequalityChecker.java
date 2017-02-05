// https://community.topcoder.com/stat?c=problem_statement&pm=3560

public class InequalityChecker {
	public static int[] getDifferences(int n) {
		int s = 0;
		
		for (int i = 1; i <= (n-1); ++i) {
			s += (int) Math.pow(i, 3);
		}
		
		int S = s + ((int) Math.pow(n, 3));
		
		boolean sExpressionHasNoRemainder = ( (S+s) % 2 == 0 );
		boolean nExpressionHasNoRemainder = ( ((int) Math.pow(n, 4)) % 4 == 0 );
		
		if (sExpressionHasNoRemainder && nExpressionHasNoRemainder) {
			int sExpressionResult = (S+s) / 2;
			int nExpressionResult = (int) Math.pow(n, 4) / 4;
			int finalResult = sExpressionResult - nExpressionResult;

			return new int[] { finalResult, 1 };
		}
		else if (!sExpressionHasNoRemainder && nExpressionHasNoRemainder){
			return new int[] { (S+s) - (((int) Math.pow(n, 4)) * 2), 2 };
		}
		else if (sExpressionHasNoRemainder && !nExpressionHasNoRemainder) {
			return new int[] { ((S+s) * 4) - ((int) Math.pow(n, 4)), 4 };
		}
		else {
			return new int[] { ((S+s) * 2) - ((int) Math.pow(n, 4)), 4 };
		}
	}
}
