package net.dvt32.exceptions.task2;

import java.util.Scanner;

/**
 * This program prompts the user to enter a series of integers
 * and throws a custom unchecked exception (NumberOutOfRangeException)
 * when the number is lower than 0 or higher than 100.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class ReadNumber {
	/**
	 * This method accomplishes the program's main objective (described above).
	 * 
	 * @param read A Scanner object, which contains the program's input.
	 */
	public void readNumber(Scanner read) {
		read = new Scanner(System.in);
		
		while (true) {
			int number = read.nextInt();
			if (number < 0 || number > 100) {
				read.close();
				throw new NumberOutOfRangeException("Number must be in range [0, 100].");
			}
		}
	}
}