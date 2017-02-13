// https://community.topcoder.com/stat?c=problem_statement&pm=6090

public class VowelLatin {
	public static String translate(String word) {
		StringBuilder consonants = new StringBuilder();
		StringBuilder vowels = new StringBuilder();
		
		for (int i = 0; i < word.length(); ++i) {
			char currentChar = word.charAt(i);
			switch (Character.toLowerCase(currentChar)) {
			case 'a': case 'e': case 'i': case 'o': case 'u':
				vowels.append(currentChar);
				break;
			default: 
				consonants.append(currentChar);
				break;
			}
		}
		
		return consonants.toString() + vowels.toString();
	}
}
