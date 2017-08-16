// https://www.codeeval.com/open_challenges/4/

public class Main {	
	public static void main(String[] args) {
		int sum = 0;
		int primeCounter = 0;
		int currentNumber = 2;
		
		while (primeCounter != 1000) {
			boolean isPrime = true;
			for (int i = 2; i <= Math.sqrt(currentNumber); ++i) {
				if (currentNumber % i == 0) {
					isPrime = false;
					break;
				}
			}
			
			if (isPrime) {
				sum += currentNumber;
				primeCounter++;
			}
			
			currentNumber++;
		}
		
		System.out.println( sum );
	}
}
