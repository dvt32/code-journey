/* https://www.hackerrank.com/contests/25-years-nbu/challenges/binary-palindromes-1
 * 
 * A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward. Write a program that determines whether a number written in binary number system is a palindrome.
 
 *The standard input consists of a number of positive integers with dividers between the numbers a space or a new line.
 *
 *All numbers are positive and less than 18446744073709551616.
 *
 *For any number of inputs, on a separate line, the program should print out "true", if the number is a binary palindrome or "false" - if it is not.
 
 */

import java.math.BigInteger;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Solution {

	public static void main(String[] args) {	
		Scanner read = new Scanner(System.in);
		
		while (true) {
			try {
				// Enter number
				BigInteger number = new BigInteger("0");
				number = number.add(read.nextBigInteger());
				// Convert it to binary
				String numberToBinary = number.toString(2);
				// Check if it's a palindrome
				boolean isPalindrome = true;
				int n = numberToBinary.length() - 1;
				for (int i = 0; i < n; ++i, --n) {
					if (numberToBinary.charAt(i) != numberToBinary.charAt(n)) {
						isPalindrome = false;
					}
				}
				// Print end result
				System.out.println(isPalindrome);
			}
			catch (InputMismatchException e) {
				break;
			}
		}
		
		
		// Close scanner
		read.close();

	}
}
