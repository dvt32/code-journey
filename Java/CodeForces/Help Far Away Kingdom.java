// https://codeforces.com/problemset/problem/99/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String input = read.nextLine();
		
		int dotIndex = input.indexOf(".");
		int indexOfLastDigitOfIntegerPart = dotIndex-1;
		int indexOfFirstDigitOfFractionalPart = dotIndex+1;
		
		int lastDigitOfIntegerPart = Character.getNumericValue( input.charAt(indexOfLastDigitOfIntegerPart) );
		int firstDigitOfFractionalPart = Character.getNumericValue( input.charAt(indexOfFirstDigitOfFractionalPart) );
		
		String output = "";
		if (lastDigitOfIntegerPart != 9 && firstDigitOfFractionalPart < 5) {
			output = input.substring(0, dotIndex);
		}
		else if (lastDigitOfIntegerPart != 9 && firstDigitOfFractionalPart >= 5) {
			output = input.substring(0, indexOfLastDigitOfIntegerPart) + (lastDigitOfIntegerPart+1);
		}
		else if (lastDigitOfIntegerPart == 9) {
			output = "GOTO Vasilisa.";
		}
		
		System.out.println(output);
		
		// Close scanner
		read.close();
	}

}
