/*
 * Даден е текст. Напишете програма, която променя регистъра на буквите на всички места в текста, заградени с таговете <upcase> и </upcase>. Таговете не могат да бъдат вложени.
 */

public class Solution {
        public static void main(String[] args) {
		String input =
			"We are living in a <upcase>yellow submarine</upcase>. We don't have <upcase>anything</upcase> else.";
		
		final String UPCASE_OPEN_TAG = "<upcase>";
		final String UPCASE_END_TAG = "</upcase>";
		
		int upcaseStartIndex = input.indexOf(UPCASE_OPEN_TAG);
		int upcaseEndIndex = input.indexOf(UPCASE_END_TAG) + UPCASE_END_TAG.length() - 1;
		
		while (upcaseStartIndex != -1) {
			int substringBetweenTagsStartIndex = upcaseStartIndex + UPCASE_OPEN_TAG.length();
			int substringBetweenTagsEndIndex = input.indexOf(UPCASE_END_TAG, substringBetweenTagsStartIndex) - 1;
			
			input = input.replace(
				input.substring( upcaseStartIndex, upcaseEndIndex + 1),
				input.substring( substringBetweenTagsStartIndex, substringBetweenTagsEndIndex + 1 ).toUpperCase()
			);
					
			upcaseStartIndex = input.indexOf(UPCASE_OPEN_TAG);
			upcaseEndIndex = input.indexOf(UPCASE_END_TAG) + UPCASE_END_TAG.length() - 1;
		}
		
		System.out.println( input );
	}
}
