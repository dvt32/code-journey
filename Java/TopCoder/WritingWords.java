// https://community.topcoder.com/stat?c=problem_statement&pm=13072

import java.util.Map;
import java.util.HashMap;

public class WritingWords {
	public static int write(String word) {
		int numberOfButtonTaps = 0;
		Map<Character, Integer> alphabetLetterValues = new HashMap<Character, Integer>();
		
		int letterValue = 1;
		for (char c = 'A'; c <= 'Z'; ++c) {
			alphabetLetterValues.put(c, letterValue);
			letterValue++;
		}
		
		for (int i = 0; i < word.length(); ++i) {
			numberOfButtonTaps += alphabetLetterValues.get(word.charAt(i));
		}
		
		return numberOfButtonTaps;
	}
}
