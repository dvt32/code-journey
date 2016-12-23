// https://community.topcoder.com/stat?c=problem_statement&pm=1757

public class Justifier {
	public static String[] justify(String[] textIn) {
		StringBuilder textOut = new StringBuilder();
		int maxLength = 0;
		
		for (String s : textIn) {
			if (s.length() > maxLength) {
				maxLength = s.length();
			}
		}
		
		for (int i = 0; i < textIn.length; ++i) {
			if (textIn[i].length() < maxLength) {
				for (int j = 0; j < ( maxLength - textIn[i].length() ); ++j) {
					textOut.append(" ");
				}
			}
			textOut.append(textIn[i]);
			textOut.append(",");
		}
		
		return textOut.toString().split(",");
	}
}
