// https://community.topcoder.com/stat?c=problem_statement&pm=13650

public class KitayutaMart2 {
	public static int numBought(int K, int T) {
		int appleCount = 0;
		
		/*
		 * K - price of one apple
		 * T - total amount of money paid for apples
		 */
		
		while (T != 0) {
			T -= K;
			appleCount++;
			K = 2*K;
		}
		
		return appleCount;
	}
}
