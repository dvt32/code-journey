// PAA 3.1 First N Prime Numbers - dvt32

/*

Генериране на първите N прости числа (N<100).

Чрез функция bool isPrime(int x) която проверява 
дали x има прости делители по-малки от sqrt(x).

*/

import java.util.Scanner;

public class Solution {
	
	static boolean isPrime(int number) {
		if (number == 2 || number == 3) {
			return true;
		}
		if (number % 2 == 0) {
			return false;
		}
		
		int sqrtOfNumber = (int) Math.sqrt(number);		
		for (int i = 2; i <= sqrtOfNumber; ++i) {
			if (number % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int numberOfPrimes = 0;
		int i = 2;
		do {
			if (isPrime(i)) {
				numberOfPrimes++;
				System.out.print(i + " ");
			}
			i++;
		} while (numberOfPrimes != n);
		
		// Close scanner
		read.close();
	}
}
