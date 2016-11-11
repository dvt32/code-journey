// https://community.topcoder.com/stat?c=problem_statement&pm=1650

public class Soccer {
	public int maxPoints(int[] wins, int[] ties) {
		int maxPoints = 0;
		for (int i = 0; i < wins.length /* or ties.length */; ++i) {
			int pointsOfCurrentTeam = wins[i] * 3 + ties[i] * 1;
			if (pointsOfCurrentTeam > maxPoints) {
				maxPoints = pointsOfCurrentTeam;
			}
		}
		return maxPoints;
	}
}
