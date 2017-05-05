// https://community.topcoder.com/stat?c=problem_statement&pm=10465

import java.util.Arrays;

public class SimpleWordGame {
	public static int points(String[] player, String[] dictionary) {
		int points = 0;
		
		for (String word : dictionary) {
			if (Arrays.asList(player).contains(word)) {
				points += word.length() * word.length();
			}
		}
		
		return points;
	}
}
