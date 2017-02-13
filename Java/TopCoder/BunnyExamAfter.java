// https://community.topcoder.com/stat?c=problem_statement&pm=11012

public class BunnyExamAfter {
	public static int getMaximum(String black, String gray, String white) {
		int maxPoints = 0;
		
		for (int i = 0; i < black.length(); ++i) {
			if (black.charAt(i) != gray.charAt(i) && black.charAt(i) != white.charAt(i)) {
				if (gray.charAt(i) == white.charAt(i)) {
					maxPoints += 2;
				}
				else {
					maxPoints++;
				}
			}
			else if (black.charAt(i) != gray.charAt(i)) {
				maxPoints++;
			}
			else if (black.charAt(i) != white.charAt(i)) {
				maxPoints++;
			}
		}
		
		return maxPoints;
	}
}
