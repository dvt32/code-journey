// https://community.topcoder.com/stat?c=problem_statement&pm=6635

public class RosePetals {
	public static int getScore(int[] dice) {
		int petalsCount = 0;
		
		for (int i = 0; i < dice.length; ++i) {
			switch (dice[i]) {
			case 3:
				petalsCount += 2;
				break;
			case 5:
				petalsCount += 4;
				break;
			default: break;
			}
		}
		
		return petalsCount;
	}
}
