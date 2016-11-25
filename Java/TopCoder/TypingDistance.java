// https://community.topcoder.com/stat?c=problem_statement&pm=12297

public class TypingDistance {
	public static int minDistance(String keyboard, String word) {
		int minDistance = 0;
		int currentKeyIndex = -1;
		int previousKeyIndex = -1;
		
		for (int i = 0; i < word.length(); ++i) {
			for (int j = 0; j < keyboard.length(); ++j) {
				if (keyboard.charAt(j) == word.charAt(i)) {
					currentKeyIndex = j;
					if (previousKeyIndex >= 0) {
						minDistance += Math.abs(currentKeyIndex - previousKeyIndex);
					}
					previousKeyIndex = currentKeyIndex;
					break;
				}
			}
		}
	 	
		return minDistance;
	}
}
