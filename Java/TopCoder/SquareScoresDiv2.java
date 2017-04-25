// https://community.topcoder.com/stat?c=problem_statement&pm=13700

public class SquareScoresDiv2 {
	public static int getscore(String s) {
		int score = 0;
		
		for (int i = 0; i < s.length(); ++i) {
			for (int j = i+1; j <= s.length(); ++j) {
				String currentSubstring = s.substring(i, j);
				boolean allCharactersOfSubstringAreSame = true;
				
				for (int k = 1; k < currentSubstring.length(); ++k) {
					if (currentSubstring.charAt(k) != currentSubstring.charAt(k-1)) {
						allCharactersOfSubstringAreSame = false;
						break;
					}
				}
				
				if (allCharactersOfSubstringAreSame) {
					score++;
				}
			}
		}
		
		return score;
	}
}
