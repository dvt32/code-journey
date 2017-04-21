// https://community.topcoder.com/stat?c=problem_statement&pm=11628

public class CheatingQuiz {
	public static int[] howMany(String answers) {
		int optionCount = 0;
		
		/*
		 * Number of frequencies of the letter 
		 * - 'A' (index 0), 
		 * - 'B' (index 1), 
		 * - 'C' (index 2) 
		 * in "answers"
		 */
		int[] letterFrequencies = new int[3];
		for (int i = 0; i < answers.length(); ++i) {
			int letterIndex = answers.charAt(i) - 'A';
			boolean isFirstOccurrenceOfLetter = (letterFrequencies[letterIndex] == 0);
			if (isFirstOccurrenceOfLetter) {
				optionCount++;
			}
			letterFrequencies[letterIndex]++;
		}
		
		int[] numberOfOptions = new int[ answers.length() ];
		for (int i = 0; i < numberOfOptions.length; ++i) {
			numberOfOptions[i] = optionCount;
			int letterIndex = answers.charAt(i) - 'A';
			letterFrequencies[letterIndex]--;
			boolean isLastOccurrenceOfLetter = (letterFrequencies[letterIndex] == 0);
			if (isLastOccurrenceOfLetter) {
				optionCount--;
			}
		}
		
		return numberOfOptions;
	}
}
