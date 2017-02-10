// https://community.topcoder.com/stat?c=problem_statement&pm=9822

public class TournamentJudging {
	public static int getPoints(int[] rawScores, int[] conversionFactor) {
		int overallScore = 0;
		
		for (int i = 0; i < rawScores.length; ++i) {
			overallScore += (int) Math.round( (double) rawScores[i] / conversionFactor[i] );
		}
		
		return overallScore;
	}
}
