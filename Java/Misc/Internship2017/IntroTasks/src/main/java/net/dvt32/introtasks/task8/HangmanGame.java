package net.dvt32.introtasks.task8;

import java.util.Scanner;

/**
 * This program is a simple implementation of the game Hangman.
 * One player picks a word and another player has to find out what it is by guessing its letters.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class HangmanGame {
	/**
	 * This method starts a game of Hangman. 
	 * 
	 * One player enters a word and another player has to guess it. 
	 * 
	 * The word is automatically converted to uppercase and blank spaces are removed.
	 * Blank words are not allowed.
	 * 
	 * It doesn't matter if the second player enters a character in lowercase/uppercase.
	 * As long as the guessed letter is present in the word, it counts as correct.
	 * 
	 * If the second player guesses a letter correctly, 
	 * this does not count towards his number of tries (only wrong ones do).
	 * 
	 * If the second player doesn't guess the word correctly within 
	 * 'numberOfAllowedWrongGuesses' tries, the game is over.
	 * 
	 * @param numberOfAllowedWrongGuesses The max number of allowed tries/guesses.
	 */
	public static void playHangman(int numberOfAllowedWrongGuesses) {
		// Enter a word
		Scanner read = new Scanner(System.in);
		System.out.println("Enter word: ");
		String wordToGuess = read.nextLine().toUpperCase().replaceAll(" ", "");
		
		// Check if the word is valid. If it's blank, then it is not considered valid.
		if (wordToGuess.length() == 0) {
			System.out.println("Sorry, but we can't play without a word!");
			read.close();
			return;
		}
		
		// Encrypt word and proceed to ask the second player to start making letter guesses
		StringBuilder encryptedWord = new StringBuilder( wordToGuess.replaceAll(".", "*") );
		int numberOfWrongGuessesMade = 0;
		boolean wordHasBeenGuessed = false;	
		
		while (numberOfWrongGuessesMade < numberOfAllowedWrongGuesses && !wordHasBeenGuessed) {
			int numberOfGuessesLeft = numberOfAllowedWrongGuesses - numberOfWrongGuessesMade;
			
			System.out.println("Enter character (" + numberOfGuessesLeft + " tries left): ");
			char characterGuess = read.nextLine().toUpperCase().charAt(0);
			
			if (wordToGuess.contains( String.valueOf(characterGuess) )) {
				for (int i = 0; i < wordToGuess.length(); ++i) {
					if (wordToGuess.charAt(i) == characterGuess) {
						encryptedWord.setCharAt(i, characterGuess);
					}
				}
				/* We need to convert StringBuilder to String, 
				 * because StringBuilder doesn't override Object's equals() method. */
				if ( encryptedWord.toString().equals(wordToGuess) ) { 
					wordHasBeenGuessed = true;
					System.out.println("You got it right! The word was " + wordToGuess + ".");
				}
				else {
					System.out.println(encryptedWord);
				}	
			}
			else {
				numberOfWrongGuessesMade++;
				if (numberOfWrongGuessesMade == numberOfAllowedWrongGuesses) {
					System.out.println("Sorry! You ran out of lives. The word was: " + wordToGuess);
				}
			}
		}
		
		// Close scanner
		read.close();
	}
	
	public static void main(String[] args) {
		playHangman(5);
	}
}
