// http://www.codeabbey.com/index/task_view/modular-calculator

// Sorry for posting this... :(

import java.util.Scanner;
import java.math.BigInteger;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		// Enter initial number
		BigInteger number = read.nextBigInteger();
		
		// Enter operation and stop entering when operation is '%'
		char currentSign = '\0';
		while (currentSign != '%') {
			currentSign = read.next().charAt(0);
			BigInteger currentNumber = read.nextBigInteger();
			switch (currentSign) {
				case '+': 
					number = number.add(currentNumber); 
					break;
				case '-': 
					number = number.subtract(currentNumber); 
					break;
				case '*': 
					number = number.multiply(currentNumber); 
					break;
				case '/': 
					if (currentNumber != BigInteger.ZERO) { 
						number = number.divide(currentNumber); 
					} 
					break;
				case '%': 
					number = number.mod(currentNumber); 
					break;
				default: 
					break;
			}
		}
		
		// Print end result
		System.out.println(number);
		
		// Close scanner
		read.close();
	}
}
