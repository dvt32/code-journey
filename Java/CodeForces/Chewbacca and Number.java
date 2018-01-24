// http://codeforces.com/problemset/problem/514/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String x = read.nextLine();
		
		int digit = Character.getNumericValue( x.charAt(0) );
		int invertedDigit = (9 - digit);
		int minDigit = Math.min(digit, invertedDigit);
		
		StringBuilder minNumber;
		if (minDigit != 0) {
			minNumber = new StringBuilder(String.valueOf(minDigit));
		}
		else {
			minNumber = new StringBuilder(String.valueOf(digit));
		}
		
		for (int i = 1; i < x.length(); ++i) {
			digit = Character.getNumericValue( x.charAt(i) );
			invertedDigit = (9 - digit);
			minDigit = Math.min(digit, invertedDigit);
			minNumber.append(String.valueOf(minDigit));
		}
		
		long decimalMinNumber = Long.valueOf(minNumber.toString());
		System.out.println( decimalMinNumber );
		
		// Close scanner
		read.close();
	}
	
}
