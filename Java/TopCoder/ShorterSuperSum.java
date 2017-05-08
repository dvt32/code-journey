// https://community.topcoder.com/stat?c=problem_statement&pm=10240

public class ShorterSuperSum {
	public static int calculate(int k, int n) {
		if (k == 0) {
			int superSum = n;
			
			return superSum;
		}
		else {
			int superSum = 0;
			
			for (int i = 1; i <= n; ++i) {
				superSum += calculate(k-1, i);
			}
			
			return superSum;
		}
	}
}
