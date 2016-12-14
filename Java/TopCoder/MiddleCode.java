// https://community.topcoder.com/stat?c=problem_statement&pm=12940

public class MiddleCode {
	public static String encode(String s) {
		StringBuilder copyOfS = new StringBuilder(s);
		StringBuilder t = new StringBuilder();
		
		while (true) {
			int lengthOfS = copyOfS.length();
			if (lengthOfS % 2 == 1) {
				char middleChar = copyOfS.charAt(lengthOfS / 2);
				t.append(middleChar);
				copyOfS.deleteCharAt(lengthOfS / 2);
				if (copyOfS.length() == 0) {
					break;
				}
			}
			else {
				char firstMiddleChar = copyOfS.charAt(lengthOfS / 2);
				char secondMiddleChar = copyOfS.charAt((lengthOfS / 2) - 1);
				char minChar = (char) Math.min(firstMiddleChar, secondMiddleChar);
				t.append(minChar);
				int minCharIndex = (minChar == firstMiddleChar) ? (lengthOfS / 2) : ((lengthOfS / 2) - 1);
				copyOfS.deleteCharAt(minCharIndex);
				if (copyOfS.length() == 0) {
					break;
				}
			}
		}
		
		return t.toString();
	}
}
