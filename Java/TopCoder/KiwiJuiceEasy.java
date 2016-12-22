// https://community.topcoder.com/stat?c=problem_statement&pm=11020

public class KiwiJuiceEasy {
	public static int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
		for (int i = 0; i < fromId.length; ++i) {
			bottles[toId[i]] += bottles[fromId[i]];
			bottles[fromId[i]] -= bottles[fromId[i]];
			if (bottles[toId[i]] > capacities[toId[i]]) {
				int temp = bottles[toId[i]];
				bottles[toId[i]] = (capacities[toId[i]] - bottles[fromId[i]]);
				bottles[fromId[i]] = (temp - bottles[toId[i]]);
			}
		}
		
		return bottles;
	}
}
