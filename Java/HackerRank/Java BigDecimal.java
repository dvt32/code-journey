// https://www.hackerrank.com/challenges/java-bigdecimal

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		// Enter & validate input
		int n = read.nextInt();
		if (n > 200) {
			throw new IllegalArgumentException("n must be <= 200");
		}
		String[] inputValues = new String[n];
		
		// Enter values
		for (int i = 0; i < n; ++i) {
			inputValues[i] = read.next();
		}
		
		// Sort array in descending order and use custom comparator implementation to avoid losing leading zeros
		Arrays.sort(inputValues, Collections.reverseOrder(new Comparator<String>() {
			@Override
			public int compare(String first, String second) {
				BigDecimal firstNumber = new BigDecimal(first);
				BigDecimal secondNumber = new BigDecimal(second);
				int resultOfComparison = firstNumber.compareTo(secondNumber);
				return resultOfComparison;
			}
		}));
		
		// Print end result
		for (int i = 0; i < n; ++i) {
			System.out.println(inputValues[i]);
		}
		
		// Close scanner
		read.close();
	}
}
