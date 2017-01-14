// https://community.topcoder.com/stat?c=problem_statement&pm=8707

public class AverageCandyLifetime {
	public static double getAverage(int[] eatenCandies) {
		double average = 0.0d;
		int candyLifetime = 0;
		int numberOfCandies = 0;
		
		int[] monthLength = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		
		for (int i = 0; i < eatenCandies.length; ++i) {
			if (eatenCandies[i] > 0) {
				for (int j = 0; j <= i; ++j) {
					candyLifetime += monthLength[j] * eatenCandies[i];
					
				}
				numberOfCandies += eatenCandies[i];
			}
			
		}
		
		average = (double) candyLifetime / numberOfCandies;
		
		return average;
	}
}
