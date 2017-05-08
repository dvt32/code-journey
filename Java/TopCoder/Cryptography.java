// https://community.topcoder.com/stat?c=problem_statement&pm=10814

public class Cryptography {
	public static long encrypt(int[] numbers) {
		int minElement = numbers[0];
		int minElementIndex = 0;
		
		// Get minimum element
		for (int i = 1; i < numbers.length; ++i) {
			if (numbers[i] < minElement) {
				minElement = numbers[i];
				minElementIndex = i;
			}
		}
		
		// Calculate max product
		int incrementedElement = (minElement + 1);
		long maxProduct = incrementedElement;
		for (int i = 0; i < numbers.length; ++i) {
			if (i != minElementIndex) {
				maxProduct *= numbers[i];
			}
		}
		
		return maxProduct;
	}
}
