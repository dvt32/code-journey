// http://www.codeabbey.com/index/task_view/fibonacci-sequence

import java.util.Scanner;
import java.math.BigInteger;

public class Solution {
	
	public static final int MAX_NUMBERS = 1000;
	
	public static int getFibonacciNumberIndex(BigInteger numberToFind) {
		if (numberToFind.equals(BigInteger.ZERO)) { return 0; }
		else if (numberToFind.equals(BigInteger.ONE)) { return 1; }
		
		BigInteger[] fibonacciNumbers = new BigInteger[MAX_NUMBERS];
		fibonacciNumbers[0] = BigInteger.ZERO;
		fibonacciNumbers[1] = BigInteger.ONE;
		
		for (int i = 2; i < MAX_NUMBERS; ++i) {
			fibonacciNumbers[i] = new BigInteger("0");
			fibonacciNumbers[i] = fibonacciNumbers[i].add(fibonacciNumbers[i-2]).add(fibonacciNumbers[i-1]);
			if (fibonacciNumbers[i].equals(numberToFind)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int numbersToProcess = read.nextInt();
		for (int i = 0; i < numbersToProcess; ++i) {
			BigInteger number = read.nextBigInteger();
			int indexOfNumber = getFibonacciNumberIndex(number);
			System.out.print(indexOfNumber + " ");
		}

		// Close scanner
		read.close();
	}
}
