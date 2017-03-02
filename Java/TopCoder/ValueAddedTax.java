// https://community.topcoder.com/stat?c=problem_statement&pm=7894

public class ValueAddedTax {
	public static double calculateFinalPrice(String product, int price, String[] food) {
		double finalPrice = 0.0d;
		
		for (String foodProduct : food) {
			if (foodProduct.equals(product)) {
				finalPrice = price + (price * 0.1); // 10 percent is 10/100 => 1/10 => 0.1
				return finalPrice;
			}
		}
		
		finalPrice = price + (price * 0.18); // 18 percent is 18/100 => 9/50 => 0.18
		
		return finalPrice;
	}
}
