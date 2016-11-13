// https://community.topcoder.com/stat?c=problem_statement&pm=13505

public class GreaterGameDiv2 {
	public static int calc(int[] snuke, int[] sothe) {
		int pointsOfSnuke = 0;
		for (int i = 0; i < snuke.length; ++i) {
			if (snuke[i] > sothe[i]) {
				pointsOfSnuke++;
			}
		}
		return pointsOfSnuke;
	}
}
