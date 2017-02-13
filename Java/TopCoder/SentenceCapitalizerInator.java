// https://community.topcoder.com/stat?c=problem_statement&pm=11399

public class SentenceCapitalizerInator {
	public static String fixCaps(String paragraph) {
		StringBuilder fixedParagraph = new StringBuilder(paragraph);
		
		fixedParagraph.setCharAt(0, Character.toUpperCase(paragraph.charAt(0)));
		for (int i = 1; i < paragraph.length() - 2; ++i) {
			if (paragraph.charAt(i) == '.') {
				fixedParagraph.setCharAt(i+2, Character.toUpperCase(paragraph.charAt(i+2)));
			}
		}
		
		return fixedParagraph.toString();
	}
}
