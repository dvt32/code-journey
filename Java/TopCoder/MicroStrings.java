// https://community.topcoder.com/stat?c=problem_statement&pm=13048

public class MicroStrings {
	public static String makeMicroString(int A, int D) {
		StringBuilder microString = new StringBuilder();
		
		int result = A;
		int i = 1;
		
		while (result >= 0) {
			microString.append(result);
			result = A - i * D;
			i++;
		}
		
		return microString.toString();
	}
}
