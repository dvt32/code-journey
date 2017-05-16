// https://community.topcoder.com/stat?c=problem_statement&pm=10586

public class Archery {
	public static double expectedPoints(int N, int[] ringPoints) {
		double expectedPointValue = 0;
		int totalArea = (N+1) * (N+1); // the area of the square surrounding all the circles
		
		for (int i = 0; i <= N; ++i) {
			int sectionArea = (2*i + 1);
			double probabilityOfHittingSection = (double) sectionArea / totalArea;
			expectedPointValue += ringPoints[i] * probabilityOfHittingSection;
		}
		
		return expectedPointValue;
	}
}
