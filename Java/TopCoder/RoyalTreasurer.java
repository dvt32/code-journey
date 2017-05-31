// https://community.topcoder.com/stat?c=problem_statement&pm=10007

import java.util.Arrays;

public class RoyalTreasurer {
	public static int minimalArrangement(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		
		int i = 0;
		int j = B.length-1;
		int minSum = 0;
		
		while (i < A.length) {
			minSum += A[i] * B[j];
			i++;
			j--;
		}
		
		return minSum;
	}
}
