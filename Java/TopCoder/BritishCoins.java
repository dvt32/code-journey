// https://community.topcoder.com/stat?c=problem_statement&pm=1862

public class BritishCoins {
	public static int[] coins(int pence) {
		final int PENNIES_IN_SHILLING = 12;
		final int SHILLINGS_IN_POUND = 20;
		final int PENNIES_IN_POUND = PENNIES_IN_SHILLING * SHILLINGS_IN_POUND;
		
		int pennyCount = 0;
		int shillingCount = 0;
		int poundCount = 0;
		
		// Get pound count
		while (pence >= PENNIES_IN_POUND) {
			pence -= PENNIES_IN_POUND;
			poundCount++;
		}
		
		// Get shilling count
		while (pence >= PENNIES_IN_SHILLING) {
			pence -= PENNIES_IN_SHILLING;
			shillingCount++;
		}
		
		// Get penny count (equal to whatever is left in 'pence')
		pennyCount = pence;
		
		return new int[] { poundCount, shillingCount, pennyCount }; 
	}
}
