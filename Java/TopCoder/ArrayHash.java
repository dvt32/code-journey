// https://community.topcoder.com/stat?c=problem_statement&pm=4503

public class ArrayHash {
	public static int getHash(String[] input) {
		int hash = 0;
		
		for (int i = 0; i < input.length; ++i) {
			for (int j = 0; j < input[i].length(); ++j) {
				int alphabetPosition = ((int) input[i].charAt(j)) - 65; // 65 - ASCII code of 'A'
				hash += alphabetPosition + i + j;
			}
		}
		
		return hash;
	}
}
