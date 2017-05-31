// https://community.topcoder.com/stat?c=problem_statement&pm=2341

public class ScoringEfficiency {
	public static double getPointsPerShot(String[] gameLog) {
		int totalPoints = 0;
		int fieldGoalsAttempted = 0;
		int freeThrowsAttempted = 0;
		
		for (String log : gameLog) {
			boolean madeShot = log.contains("Made");
			boolean madeTwoPointer = log.contains("2");
			boolean madeThreePointer = log.contains("3");
			
			if (madeShot) {
				if (madeTwoPointer) {
					totalPoints += 2;
				}
				else if (madeThreePointer) {
					totalPoints += 3;
				}
				else {
					totalPoints += 1;
				}
			}
			
			boolean attemptedFreeThrow = log.contains("free throw");
			if (attemptedFreeThrow) {
				freeThrowsAttempted++;
			}
			else {
				fieldGoalsAttempted++;
			}
		}
		
		double pointsPerShot = totalPoints / ( fieldGoalsAttempted + (0.5 * freeThrowsAttempted) );
		
		return pointsPerShot;
	}
}
