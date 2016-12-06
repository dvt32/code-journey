// https://community.topcoder.com/stat?c=problem_statement&pm=10233

import java.util.Set;
import java.util.HashSet;

public class TheBeauty {
	public static int find(int n) {
		Set<Integer> distinctDigitsInNumber = new HashSet<Integer>();
		
		while (n != 0) {
			distinctDigitsInNumber.add(n % 10);
			n /= 10;
		}
		
		return distinctDigitsInNumber.size();
	}
}
