// https://community.topcoder.com/stat?c=problem_statement&pm=11954

public class GreatFairyWar {
	public static int minHP(int[] dps, int[] hp) {
		int damageTaken = 0;
		
		for (int i = 0; i < hp.length; ++i) {
			while (hp[i] != 0) {
				for (int j = 0; j < dps.length; ++j) {
					if (hp[j] > 0) {
						damageTaken += dps[j];
					}
				}
				hp[i]--;
			}
		}
		
		return damageTaken;
	}
}
