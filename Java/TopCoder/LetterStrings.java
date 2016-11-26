// https://community.topcoder.com/stat?c=problem_statement&pm=961

public class LetterStrings {
	public static int sum(String[] s) {
		int sum = 0;
		for (String element : s) {
			sum += element.replaceAll("-", "").length();
		}
		return sum;
	}
}
