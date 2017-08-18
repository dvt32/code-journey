package net.dvt32.exceptions.task1;

/**
 * This program calculates the sum of 2 non-negative decimal numbers, represented as Strings.
 * It does so by mimicking the way a human being would calculate the sum of the two numbers.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class Sumator {
	/**
	 * This method adds 2 non-negative decimal numbers and returns their sum as a String.
	 * It supports really large numbers as well.
	 * 
	 * The logic of the method is pretty straightforward:
	 * - We start with the rightmost digit of each number and calculate the sum of those digits.
	 * - If that sum is <= 9, we need to simply add that sum as a digit of the total sum of the 2 numbers. 
	 * - If that sum is > 9, we need to:
	 * 		- "carry 1 in our heads" (and add it to the sum of the next 2 rightmost digits.
	 * 		- add the "ones" part of the digit sum (if it's 11, we append 1; if it's 17, we append 7 etc.)
	 * 		  as a digit of the total sum of the 2 numbers.
	 * - We continue doing that until we've calculated the sum of each pair of digits.
	 * 
	 * NOTE: If one of the numbers doesn't have any more digits, we simply add 0 to the current sum of digits.
	 * 
	 * NOTE: Since we're APPENDING these "digit sum" digits, 
	 * 		 but we're performing the calculations from RIGHT TO LEFT, 
	 * 		 we need to reverse the final result before returning it.
	 * 
	 * @param firstNumber The first non-negative decimal number, represented as a String
	 * @param secondNumber The second non-negative decimal number, represented as a String
	 * @return The sum of the 2 non-negative decimal numbers, represented as a String
	 */
	public String getSumOfNumbers(String firstNumber, String secondNumber) {
		checkIfNumberIsValid(firstNumber);
		checkIfNumberIsValid(secondNumber);
		
		StringBuilder sumOfNumbers = new StringBuilder();
		
		firstNumber = getStringWithoutLeadingZeros(firstNumber);
		secondNumber = getStringWithoutLeadingZeros(secondNumber);
		
		int i = firstNumber.length()-1;
		int j = secondNumber.length()-1;
		int carry = 0;
		
		while (i >= 0 || j >= 0 || carry != 0) {
			int digitFromFirstNumber = (i < 0) ? 0 : Integer.parseInt( String.valueOf(firstNumber.charAt(i)) );
			int digitFromSecondNumber = (j < 0) ? 0 : Integer.parseInt( String.valueOf(secondNumber.charAt(j)) );
			int digitOfSum = digitFromFirstNumber + digitFromSecondNumber + carry;
			
			if (digitOfSum > 9) {
				carry = 1;
				digitOfSum -= 10;
			}
			else {
				carry = 0;
			}
			
			sumOfNumbers.append(digitOfSum);
			
			i--;
			j--;
		}
		
		return sumOfNumbers.reverse().toString();
	}
	
	/**
	 * This method returns a String without any leading zeros (zeros in the beginning of it).
	 * It will not turn a "0" string into a blank one.
	 * 
	 * The ^ anchor will make sure that the 0+ being matched is at the beginning of the input. 
	 * The (?!$) negative lookahead ensures that not the entire string will be matched.
	 * 
	 * @param str The input string
	 * @return The input string without any leading zeros
	 */
	public String getStringWithoutLeadingZeros(String str) {
		String stringWithoutLeadingZeros = str.replaceFirst("^0+(?!$)", "");
		return stringWithoutLeadingZeros;
	}
	
	/**
	 * This method checks if a passed number argument to the sum method is valid.
	 * 
	 * A valid number is:
	 * - not null
	 * - not empty
	 * - contains only digits (no letters, white spaces, punctuation marks etc. are allowed)
	 * 
	 * In case the number is invalid, an appropriate exception is thrown.
	 * 
	 * @param number The number being checked for validity
	 */
	public void checkIfNumberIsValid(String number) {
		boolean numberIsNull = ( number == null );
		if (numberIsNull) {
			throw new NullPointerException("Numbers can't be null!");
		}
		
		boolean numberIsEmpty = ( number.length() == 0 );
		if (numberIsEmpty) { 
			throw new IllegalArgumentException("Numbers can't be empty!");
		}
		
		boolean numberContainsNonDigitCharacters = ( !number.matches("[0-9]+") );
		if (numberContainsNonDigitCharacters) {
			throw new NumberFormatException("Numbers can't contain non-digit characters!");
		}
	}
}