// https://community.topcoder.com/stat?c=problem_statement&pm=818

public class Average {
	public static int belowAvg(int[] math, int[] verbal) {
		// Get composite average score
		double compositeAverageScore = 0.0;
		for (int i = 0; i < math.length; ++i) {
			compositeAverageScore += math[i];
			compositeAverageScore += verbal[i];
		}
		compositeAverageScore /= math.length;
		
		// Get number of children with score below the composite average score
		int belowAverageChildCount = 0;
		for (int i = 0; i < math.length; ++i) {
			double currentChildScore = (math[i] + verbal[i]);
			if (currentChildScore < compositeAverageScore) {
				belowAverageChildCount++;
			}
		}
		
		return belowAverageChildCount;
	}
}
