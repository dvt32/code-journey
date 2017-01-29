// https://community.topcoder.com/stat?c=problem_statement&pm=13000

public class OneDimensionalRobotEasy {
	public static int finalPosition(String commands, int A, int B) {
		int finalPosition = 0;
		
		for (int i = 0; i < commands.length(); ++i) {
			if (commands.charAt(i) == 'L' && ( ( finalPosition - 1 ) >= (-A) ) ) {
				finalPosition--;
			}
			else if ( (finalPosition+1) <= B ) {
				finalPosition++;
			}
		}
		
		return finalPosition;
	}
}
