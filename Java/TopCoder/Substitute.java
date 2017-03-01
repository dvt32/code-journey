// https://community.topcoder.com/stat?c=problem_statement&pm=1333

public class Substitute {
	public static int getValue(String key, String code) {
		StringBuilder decodedValue = new StringBuilder();
		
		for (int i = 0; i < code.length(); ++i) {
			int codeIndex = key.indexOf(code.charAt(i));
			if (codeIndex != -1) {
				if (codeIndex == 9) {
					decodedValue.append(0);
				}
				else {
					decodedValue.append(codeIndex+1);
				}
			}
		}
		
		return Integer.parseInt(decodedValue.toString());
	}
}
