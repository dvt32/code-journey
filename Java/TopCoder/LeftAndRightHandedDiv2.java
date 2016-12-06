// https://community.topcoder.com/stat?c=problem_statement&pm=13043

public class LeftAndRightHandedDiv2 {
	public static int count(String S) {
		int elbowCollisionsCount = 0;
		
		for (int i = 0; i < S.length()-1; ++i) {
			if (S.charAt(i) == 'R' && S.charAt(i+1) == 'L') {
				elbowCollisionsCount++;
			}
		}
		
		return elbowCollisionsCount;
	}
}
