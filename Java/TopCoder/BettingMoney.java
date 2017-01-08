// https://community.topcoder.com/stat?c=problem_statement&pm=2297

public class BettingMoney {
	public static int moneyMade(int[] amounts, int[] centsPerDollar, int finalResult) {
		int moneyMade = 0;
		
		for (int margin = 0; margin < amounts.length; ++margin) {
			if (margin == finalResult) {
				moneyMade -= amounts[margin] * centsPerDollar[margin];
			}
			else {
				moneyMade += amounts[margin] * 100;
			}
		}
		
		return moneyMade;
	}
}
