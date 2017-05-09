// https://community.topcoder.com/stat?c=problem_statement&pm=11056

// This solution passes all test cases, but its logic may not be correct...

import java.util.Arrays;

public class P8XMatrixTransformation {
	public static String solve(String[] original, String[] target) {
		char[] o = Arrays.toString(original).toCharArray();
		char[] t = Arrays.toString(target).toCharArray();
		
		Arrays.sort(o);
		Arrays.sort(t);
		
		if (String.valueOf(o).equals(String.valueOf(t))) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
}
