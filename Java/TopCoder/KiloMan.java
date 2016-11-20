// https://community.topcoder.com/stat?c=problem_statement&pm=2268

public class KiloMan {
	public static int hitsTaken(int[] pattern, String jumps) {
		int hitsCount = 0;
		
		for (int i = 0; i < pattern.length; ++i) {
			int currentHeight = pattern[i];
			char currentKiloManAction = jumps.charAt(i);
			if (currentKiloManAction == 'S' && (currentHeight == 1 || currentHeight == 2)) {
				hitsCount++;
			}
			else if (currentKiloManAction == 'J' && currentHeight > 2) {
				hitsCount++;
			}
		}
		
		return hitsCount;
	}
}
