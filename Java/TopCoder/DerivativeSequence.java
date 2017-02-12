// https://community.topcoder.com/stat?c=problem_statement&pm=6665

public class DerivativeSequence {
	public static int[] derSeq(int[] a, int n) {
		if (n == 0) {
			return a;
		}
		
		int[] derivativeSequence = new int[a.length-1];
		
		int j = 0;
		for (int i = 1; i < a.length; ++i) {
			derivativeSequence[j] = ( a[i] - a[i-1] );
			j++;
		}
		
		return derSeq(derivativeSequence, n-1);
	}
}
