// https://community.topcoder.com/stat?c=problem_statement&pm=11800

public class BinaryPolynomialDivTwo {
	public static int countRoots(int[] a) {
		int P0 = a[0]; // 0^0 = 1 (according to problem statement)
		int P1 = a[0]; 
		
		for (int i = 1; i < a.length; ++i) {
			P1 += a[i]; 
			// NOTE 1: no need to add to P(0), as we're always multiplying a[i] by 0, since 0^1 = 0, 0^2 = 0 etc.
			// NOTE 2: also no need to write explicitly that in P(1) we multiply a[i] by 1, since 1^1 = 1, 1^2 = 1 etc.
		}
	
		// Get number of roots
		int rootCount = 0;

		if (P0 % 2 == 0) {
			rootCount++;
		}
		if (P1 % 2 == 0) {
			rootCount++;
		}
		
		return rootCount;
	}
}
