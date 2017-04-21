// https://community.topcoder.com/stat?c=problem_statement&pm=11194

public class TheBoredomDivTwo {
	public static int find(int n, int m, int j, int b) {
		boolean[] isBored = new boolean[n+m];
		for (int i = 0; i < n; ++i) {
			isBored[i] = true;
		}
		
		if (!isBored[j-1]) {
			isBored[j-1] = true;
		}
		if (!isBored[b-1]) {
			isBored[b-1] = true;
		}
		
		int numberOfBoredPeople = 0;
		for (int i = 0; i < isBored.length; ++i) {
			if (isBored[i]) {
				numberOfBoredPeople++;
			}
		}
		
		return numberOfBoredPeople;
	}
}
