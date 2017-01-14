// https://community.topcoder.com/stat?c=problem_statement&pm=12524

import java.util.Arrays;

public class PrimalUnlicensedCreatures {
	public static int maxWins(int initialLevel, int[] grezPower) {
		int winCount = 0;
		
		Arrays.sort(grezPower);
		int grezPowerLevel = initialLevel;
		
		for (int i = 0; i < grezPower.length; ++i) {
			if (grezPowerLevel > grezPower[i]) {
				grezPowerLevel += grezPower[i] / 2;
				winCount++;
			}
			else {
				break;
			}
		}
		
		return winCount;
	}
}
