package net.dvt32.generictypesclassesandobjects.task1;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * This program can calculate the sum of two numbers. The numbers can be represented as:
 * - integers (int)
 * - floating-point numbers (double)
 * - Strings (only non-negative integers)
 * - Objects (BigInteger or BigDecimal)
 * 
 * The Summator class makes use of method overloading, 
 * which allows us to have multiple methods with the same name, 
 * but with a different signature.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class Summator {
	/**
	 * This method calculates the sum of two integers.
	 * 
	 * @param first The first integer.
	 * @param second The second integer
	 * @return The sum of the two integers.
	 */
	public int sum(int first, int second) {
		int sumOfNumbers = first + second;
		return sumOfNumbers;
	}
	
	/**
	 * This method calculates the sum of two floating-point numbers.
	 * 
	 * @param first The first floating-point number
	 * @param second The second floating-point number
	 * @return The sum of the two floating-point numbers.
	 */
	public double sum(double first, double second) {
		double sumOfNumbers = first + second;
		return sumOfNumbers;
	}
	
	/**
	 * This method calculates the sum of two non-negative decimal numbers 
	 * and returns their sum as a String.
	 * 
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
	 * @param first The first non-negative decimal number, represented as a String
	 * @param second The second non-negative decimal number, represented as a String
	 * @return The sum of the 2 non-negative decimal numbers, represented as a String
	 */
	public String sum(String first, String second) {
		StringBuilder sumOfNumbers = new StringBuilder();
		
		first = first.replaceFirst("^0+(?!$)", "");
		second = second.replaceFirst("^0+(?!$)", "");
		
		int i = first.length()-1;
		int j = second.length()-1;
		int carry = 0;
		
		while (i >= 0 || j >= 0 || carry != 0) {
			int digitFromFirstNumber = (i < 0) ? 0 : Integer.parseInt( String.valueOf(first.charAt(i)) );
			int digitFromSecondNumber = (j < 0) ? 0 : Integer.parseInt( String.valueOf(second.charAt(j)) );
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
	 * Returns the sum of two BigInteger numbers.
	 * 
	 * @param first The first BigInteger number
	 * @param second The second BigInteger number
	 * @return The sum of the two BigInteger numbers
	 */
	public BigInteger sum(BigInteger first, BigInteger second) {
		BigInteger sumOfNumbers = new BigInteger( String.valueOf(first) );
		sumOfNumbers = sumOfNumbers.add(second);
		return sumOfNumbers;
	}
	
	/**
	 * Returns the sum of two BigDecimal numbers.
	 * 
	 * @param first The first BigDecimal number
	 * @param second The second BigDecimal number
	 * @return The sum of the two BigDecimal numbers
	 */
	public BigDecimal sum(BigDecimal first, BigDecimal second) {
		BigDecimal sumOfNumbers = new BigDecimal( String.valueOf(first) );
		sumOfNumbers = sumOfNumbers.add(second);
		return sumOfNumbers;
	}
}