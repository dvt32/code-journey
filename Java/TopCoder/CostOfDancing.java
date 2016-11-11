// https://community.topcoder.com/stat?c=problem_statement&pm=13195

public class CostOfDancing {
	public int minimum(int K, int[] danceCost) {
		// Sort array via Bubble Sort - max elements is 1000, so the sorting algorithm doesn't matter
		boolean stillSwapping = true;
		while (stillSwapping) {
			stillSwapping = false;
			for (int i = 0; i < danceCost.length-1; ++i) {
				if (danceCost[i] > danceCost[i+1]) {
					int temp = danceCost[i];
					danceCost[i] = danceCost[i+1];
					danceCost[i+1] = temp;
					stillSwapping = true;
				}
			}
		}
		// Calculate smallest total cost for K courses
		int minimumCost = 0;
		for (int i = 0; i < K; ++i) {
			minimumCost += danceCost[i];
		}
		return minimumCost;
	}
}
