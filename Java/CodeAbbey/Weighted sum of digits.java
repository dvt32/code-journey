// http://www.codeabbey.com/index/task_view/weighted-sum-of-digits

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	
	public static int getWeightedSumOfDigits(int number) {
		// Extract digits and add them to ArrayList
		List<Integer> digitsOfNumber = new ArrayList<Integer>();
		while (number != 0) {
			int currentDigit = number % 10;
			digitsOfNumber.add(currentDigit);
			number /= 10;
		}
		Collections.reverse(digitsOfNumber);
		
		// Calculate weighted sum
		int sum = 0;
		int digitNumber = 1;
		for (int digit : digitsOfNumber) {
			sum += digit * digitNumber;
			digitNumber++;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int numberOfTestcases = read.nextInt();
		for (int i = 0; i < numberOfTestcases; ++i) {
			int currentNumber = read.nextInt();
			int weightedSumOfDigits = getWeightedSumOfDigits(currentNumber);
			System.out.print(weightedSumOfDigits + " ");
		}

		// Close scanner
		read.close();
	}
}
