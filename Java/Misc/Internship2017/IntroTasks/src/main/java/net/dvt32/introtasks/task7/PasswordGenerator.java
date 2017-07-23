package net.dvt32.introtasks.task7;

import java.util.Random;

/**
 * This program generates a random password with a specified length.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class PasswordGenerator {
	public enum PasswordCharacterType {
		UPPERCASE_LETTER,
		LOWERCASE_LETTER,
		DIGIT
	}
	
	/**
	 * This method generates a random password with a specified length. 
	 * The password can only contain uppercase letters, lowercase letters and digits.
	 * 
	 * @param passwordLength The length of the password to be generated
	 * @return The generated password
	 */
	public String generateStringPassword(int passwordLength) {
		StringBuilder password = new StringBuilder();
		Random randomNumberGenerator = new Random();
		PasswordCharacterType[] passwordCharacterTypes = PasswordCharacterType.values();
		
		final int UPPERCASE_LETTERS_ASCII_CODE_RANGE_START = 65;
		final int UPPERCASE_LETTERS_ASCII_CODE_RANGE_END = 90;
		final int LOWERCASE_LETTERS_ASCII_CODE_RANGE_START = 97;
		final int LOWERCASE_LETTERS_ASCII_CODE_RANGE_END = 122;
		final int DIGITS_ASCII_CODE_RANGE_START = 48;
		final int DIGITS_ASCII_CODE_RANGE_END = 57;
		
		for (int i = 0; i < passwordLength; ++i) {
			int characterTypeIndex = randomNumberGenerator.nextInt( passwordCharacterTypes.length );
			PasswordCharacterType characterType = passwordCharacterTypes[characterTypeIndex];
			
			switch (characterType) {
			case UPPERCASE_LETTER: 
				char randomUppercaseLetter = (char) generateAsciiCodeInRange(
					UPPERCASE_LETTERS_ASCII_CODE_RANGE_START,
					UPPERCASE_LETTERS_ASCII_CODE_RANGE_END,
					randomNumberGenerator
				);
				password.append(randomUppercaseLetter);
				break;
			case LOWERCASE_LETTER:
				char randomLowercaseLetter = (char) generateAsciiCodeInRange(
					LOWERCASE_LETTERS_ASCII_CODE_RANGE_START,
					LOWERCASE_LETTERS_ASCII_CODE_RANGE_END,
					randomNumberGenerator
				);
				password.append(randomLowercaseLetter);
				break;
			case DIGIT:
				char randomDigit = (char) generateAsciiCodeInRange(
					DIGITS_ASCII_CODE_RANGE_START,
					DIGITS_ASCII_CODE_RANGE_END,
					randomNumberGenerator
				);
				password.append(randomDigit);
				break;
			default:
				break;
			}
		}
		
		return password.toString();
	}
	
	/**
	 * This method generates a random ASCII code in the range from 'minCodeNumber' to 'maxCodeNumber' inclusive.
	 * 
	 * @param minCodeNumber The lower bound of the ASCII code range (must be smaller than 'maxCodeNumber')
	 * @param maxCodeNumber The higher bound of the ASCII code range (must be greater than 'minCodeNumber')
	 * @param randomNumberGenerator A Random object, which generates a random ASCII code
	 * @return A random ASCII code in the range [minCodeNumber, maxCodeNumber]
	 */
	public int generateAsciiCodeInRange(int minCodeNumber, int maxCodeNumber, Random randomNumberGenerator) {
		int randomAsciiCode = randomNumberGenerator.nextInt((maxCodeNumber - minCodeNumber) + 1) + minCodeNumber;
		return randomAsciiCode;
	}
}
