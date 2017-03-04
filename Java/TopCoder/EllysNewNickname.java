// https://community.topcoder.com/stat?c=problem_statement&pm=12459

public class EllysNewNickname {
	public static int getLength(String nickname) {
		final String VOWELS = "aeiouy";
		
		int nickLength = 0;
		int consecutiveVowelCount = 0;
		
		for (int i = 0; i < nickname.length(); ++i) {
			boolean currentCharIsVowel = ( VOWELS.indexOf(nickname.charAt(i)) != -1 );
			
			if ( !currentCharIsVowel ) {
				nickLength++;
				consecutiveVowelCount = 0;
			}
			else if (currentCharIsVowel) {
				consecutiveVowelCount++;
				if (consecutiveVowelCount < 2) {
					nickLength++;
				}
			}
		}
		
		return nickLength;
	}
}
