// https://www.hackerrank.com/challenges/find-digits

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {	
		Scanner read = new Scanner(System.in);
	
		// Enter number of test cases and check if input is valid
		int T = read.nextInt();
		if (T < 1 || T > 15) {
			read.close();
			return;
		}
		
		// Enter T numbers
		for (int i = 0; i <  T; ++i) {
			int N = read.nextInt();
			// Check if input is valid
			if (N <= 0 || N > Math.pow(10, 9)) {
				read.close();
				return;
			}
			// Make a copy of N to safely extract each digit
			int N_copy = N;
			// Extract digits and count number of digits that evenly divide N
			int numberOfDigitsThatEvenlyDivideN = 0;
			while (N_copy != 0) {
				int currentDigit = N_copy % 10;
				// Make sure digit is not 0 to avoid ArithmeticException
				if (currentDigit != 0 && N % currentDigit == 0) {
					numberOfDigitsThatEvenlyDivideN++;
				}
				N_copy /= 10;
			}
			// Print end result
			System.out.println(numberOfDigitsThatEvenlyDivideN);
		}

		// Close scanner
		read.close();
	}
}
