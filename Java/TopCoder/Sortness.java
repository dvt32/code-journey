// https://community.topcoder.com/stat?c=problem_statement&pm=7263

public class Sortness {
	public static double getSortness(int[] a) {
		double sortness = 0.0d;
		
		for (int i = 0; i < a.length; ++i) {
			for (int j = 0; j < i; ++j) {
				if (a[j] > a[i]) {
					sortness++;
				}
			}
			
			for (int k = i+1; k < a.length; ++k) {
				if (a[k] < a[i]) {
					sortness++;
				}
			}
		}
		
		sortness /= a.length;
		
		return sortness;
	}
}
