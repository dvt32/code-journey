// https://community.topcoder.com/stat?c=problem_statement&pm=12540

public class DeerInZooDivTwo {
	public static int[] getminmax(int N, int K) {
                int x = N - K;

                if (x < 0) {
                    x = 0;
                }

                int antlersLeft = (2 * N) - K;
        
		int y = (antlersLeft / 2);
	
		return new int[] { x, y };
	}
}
