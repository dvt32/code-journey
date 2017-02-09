// https://community.topcoder.com/stat?c=problem_statement&pm=7774

public class Thimbles {
	public static int thimbleWithBall(String[] swaps) {

		boolean[] hasBall = new boolean[3];
		int ballIndex = 0;
		hasBall[ballIndex] = true;
		
		for (String swap : swaps) {
			int firstThimbleIndex = Character.getNumericValue(swap.charAt(0)) - 1;
			int secondThimbleIndex = Character.getNumericValue(swap.charAt(2)) - 1;
			if (hasBall[firstThimbleIndex]) {
				hasBall[firstThimbleIndex] = false;
				hasBall[secondThimbleIndex] = true;
				ballIndex = secondThimbleIndex;
			}
			else if (hasBall[secondThimbleIndex]) {
				hasBall[secondThimbleIndex] = false;
				hasBall[firstThimbleIndex] = true;
				ballIndex = firstThimbleIndex;
			}
		}
    
		return ballIndex + 1;
	}
}
