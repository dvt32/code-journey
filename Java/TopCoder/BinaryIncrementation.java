// https://community.topcoder.com/stat?c=problem_statement&pm=7385

public class BinaryIncrementation {
	public static String plusOne(String x) {
		StringBuilder plusOne = new StringBuilder(x);
		
		for (int i = x.length()-1; i >= 0; --i) {
			if (x.charAt(i) == '0') {
				plusOne.setCharAt(i, '1');
				break;
			}
			else if (i == 0) {
				plusOne.setCharAt(i, '0');
				plusOne.insert(i, '1');
			}
			else {
				plusOne.setCharAt(i, '0');
			}
		}
		
		return plusOne.toString();
	}
}
