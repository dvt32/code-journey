// https://community.topcoder.com/stat?c=problem_statement&pm=12469

public class SkiResortsEasy {
	public static int minCost(int[] altitude) {
		int minCost = 0;
		
		for (int i = 0; i < altitude.length-1; ++i) {
			if (altitude[i+1] > altitude[i]) {
				minCost += altitude[i+1] - altitude[i];
				altitude[i+1] = altitude[i];
			}
		}
		
		return minCost;
	}
}
