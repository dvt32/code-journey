// https://community.topcoder.com/stat?c=problem_statement&pm=12387

// Optimization idea: count number of negative numbers and return sign, based on whether that number is odd or even.

public class EasyHomework {
	public static String determineSign(int[] A) {
		String sign = "POSITIVE";
		
		for (int number : A) {
			if (number == 0) {
				return "ZERO";
			}
			
			if (number < 0) {
				sign = (sign.equals("POSITIVE")) ? "NEGATIVE" : "POSITIVE";
			}
		}
		
		return sign;
	}
}
