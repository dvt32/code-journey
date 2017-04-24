// https://community.topcoder.com/stat?c=problem_statement&pm=10295

public class GroupedWordChecker {
	public static int howMany(String[] words) {
		int groupedWordCount = 0;
		
		for (String word : words) {
			boolean wordIsGrouped = true;
			boolean[] letterIsUsed = new boolean[26];
			
			for (int i = 0; i < word.length(); ++i) {
				char currentLetter = word.charAt(i);
				int currentLetterIndex = (currentLetter - 'a'); // 0 - 'a', 25 - 'z'
				
				if (letterIsUsed[currentLetterIndex] && 
					i > 0 && 
					currentLetter != word.charAt(i-1))
				{
					wordIsGrouped = false;
					break;
				}
				else {
					letterIsUsed[currentLetterIndex] = true;
				}
			}
			
			if (wordIsGrouped) {
				groupedWordCount++;
			}
		}
		
		return groupedWordCount;
	}
}
