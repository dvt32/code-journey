// https://community.topcoder.com/stat?c=problem_statement&pm=10505

public class SoccerLeagues {
	public static int[] points(String[] matches) {
		int[] points = new int[matches.length];
		
		// NOTE: By default, array values are initialized to 0 in Java
		
		for (int i = 0; i < points.length; ++i) {
			for (int j = 0; j < matches[i].length(); ++j) {
				char currentChar = matches[i].charAt(j);
				if (currentChar == 'W') {
					points[i] += 3;
				}
				else if (currentChar == 'D') {
					points[i] += 1;
					points[j] += 1;
				}
				else if (currentChar == 'L') {
					points[j] += 3;
				}
			}
		}
		
		return points;
	}
}
