// https://community.topcoder.com/stat?c=problem_statement&pm=11307

public class CarrotBoxesEasy {
	public static int theIndex(int[] carrots, int K) {
		int lastIndex = 0;
		
		while (K != 0) {
			// Get max carrots element & remember index of that element
			int maxCarrots = 0;
			for (int i = 0; i < carrots.length; ++i) {
				if (carrots[i] > maxCarrots) {
					maxCarrots = carrots[i];
					lastIndex = i;
				}
			}
			// Remove a carrot from the max carrots element
			carrots[lastIndex]--;
			
			K--;
		}
		
		return lastIndex;
	}
}
