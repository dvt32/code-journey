// https://community.topcoder.com/stat?c=problem_statement&pm=13678

public class ValueOfString {
	public static int findValue(String s) {
		int stringValue = 0;
		
		for (int i = 0; i < s.length(); ++i) {
			int currentCharValue = ((int) s.charAt(i)) - 96; // 'a' has an ASCII code of 97
			for (int j = 0; j < s.length(); ++j) {
				int charValue = ((int) s.charAt(j)) - 96;
				if (charValue <= currentCharValue) {
					stringValue += currentCharValue;
				}
			}
		}
		
		return stringValue;
	}
}
