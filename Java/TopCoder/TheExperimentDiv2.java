// https://community.topcoder.com/stat?c=problem_statement&pm=12508

/*
 * Optimization ideas:
 * - use a boolean array to check whether there are any drops left to absorb from intensity[]
 * - minimize iterations in inner loop (obviously it doesn't need to loop all the way to N-1)
 */

public class TheExperimentDiv2 {
	public static int[] determineHumidity(int[] intensity, int L, int[] leftEnd) {
		int N = intensity.length;
		int M = leftEnd.length;
		
		int[] dropsAbsorbed = new int[M];
		
		for (int i = 0; i < M; ++i) {
			int spongeStartIndex = leftEnd[i];
			int spongeEndIndex = leftEnd[i] + L - 1;
			
			for (int j = 0; j < N; ++j) {
				if (j >= spongeStartIndex && j <= spongeEndIndex) {
					if (intensity[j] > 0) {
						dropsAbsorbed[i] += intensity[j];
						intensity[j] = 0;
					}
				}
			}
		}
		
		return dropsAbsorbed;
	}
}
