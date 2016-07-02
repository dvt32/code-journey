// http://www.codeabbey.com/index/task_view/prime-numbers-generation

// Sorry for posting this... :(

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Solution {
	
	public static final int MAX_NUMBER = 2750159; // 200000th prime number
	
	public static List<Integer> getPrimes() {
		List<Integer> primeNumbers = new ArrayList<Integer>();
		/*
		 *  Sieve of Eratosthenes implementation
		 */
		boolean[] isComposite = new boolean[MAX_NUMBER + 1]; // MAX_NUMBER + 1, so that we can mark isComposite[MAX_NUMBER]
		for (int i = 2; i <= MAX_NUMBER; ++i) {
			if (!isComposite[i]) {
				primeNumbers.add(i);
				int multiple = 2;
				while (i * multiple <= MAX_NUMBER) {
					isComposite[i*multiple] = true;
					multiple++;
				}
			}
		}
		
		return primeNumbers;
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		List<Integer> primeNumbers = getPrimes();
		
		int numberOfPrimes = read.nextInt();
		for (int i = 0; i < numberOfPrimes; ++i) {
			int index = read.nextInt();
			System.out.print(primeNumbers.get(index-1) + " ");
		}
		
		// Close scanner
		read.close();
	}
}
