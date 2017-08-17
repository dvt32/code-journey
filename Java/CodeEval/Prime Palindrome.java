// https://www.codeeval.com/open_challenges/3/

public class Main {	
	public static void main(String[] args) {
		int maxPalindrome = 0;
		int currentNumber = 2;
		
		while (currentNumber != 1000) {
			boolean isPrime = true;
			for (int i = 2; i <= Math.sqrt(currentNumber); ++i) {
				if (currentNumber % i == 0) {
					isPrime = false;
					break;
				}
			}
			
			if (isPrime) {
				boolean isPalindrome = 
					String.valueOf(currentNumber)
					.equals( new StringBuilder( String.valueOf(currentNumber) ).reverse().toString() );
				
				if (isPalindrome) {
					maxPalindrome = currentNumber;
				}
			}
			
			currentNumber++;
		}
		
		System.out.println( maxPalindrome );
	}
}
