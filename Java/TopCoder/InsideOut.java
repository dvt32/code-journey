// https://community.topcoder.com/stat?c=problem_statement&pm=3452

public class InsideOut {
	public static String unscramble(String line) {
		char[] unscrambledLine = new char[line.length()];

		int middleIndex = line.length() / 2 - 1;
		int j = middleIndex;
		for (int i = 0; i <= middleIndex; ++i) {
			unscrambledLine[i] = line.charAt(j);
			--j;
		}
		
		for (int i = middleIndex+1; i < line.length(); ++i) {
			if (j < 0) {
				j = line.length()-1;
			}
			unscrambledLine[i] = line.charAt(j);
			--j;
		}
		
		return String.valueOf(unscrambledLine);
	}
}
