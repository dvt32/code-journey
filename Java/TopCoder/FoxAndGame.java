// https://community.topcoder.com/stat?c=problem_statement&pm=12438

public class FoxAndGame {
	public static int countStars(String[] result) {
		int numberOfStars = 0;
		
		for (String currentResult : result) {
			numberOfStars += currentResult.replaceAll("-", "").length();
		}
		
		return numberOfStars;
	}
}
