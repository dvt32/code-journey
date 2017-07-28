package net.dvt32.introtasks.task8;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HangmanGameTest {
	
	private final ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();
	HangmanGame hg = new HangmanGame();
	
	@Before
	public void setUpOutputStream() {
		System.setOut(new PrintStream(consoleContent));
	}
	
	@After
	public void cleanUpOutputStream() {
		System.setOut(null);
	}

	@Test
	public void shouldPrintNothingAfterInputWordHasBeenEntered() {
		String userInput = "TURBO";
		
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner read = new Scanner(System.in);
		hg.playHangman(-1, read);
		System.setIn(System.in);
		
		String expectedOutput = "Enter word: \r\n";
		String actualOutput = consoleContent.toString();
		assertEquals(expectedOutput, actualOutput);	
	}
	
	@Test(expected = NoSuchElementException.class)
	public void shouldThrowNoSuchElementException() {
		String userInput = "TURBO";
		
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner read = new Scanner(System.in);
		
		try {
			hg.playHangman(2, read);
		}
		finally {
			System.setIn(System.in);	
		}
	}
	
	@Test
	public void shouldWinTheHangmanGame() {
		String userInput = 
			"TURBO\n" +
			"t\n" +
			"u\n" +
			"r\n" +
			"b\n" +
			"o\n";
		
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner read = new Scanner(System.in);
		hg.playHangman(3, read);
		System.setIn(System.in);
		
		String output = consoleContent.toString();
		assertTrue( output.endsWith("You got it right! The word was TURBO.\r\n") );
	}
	
	@Test
	public void shouldLoseTheHangmanGame() {
		String userInput = 
			"TURBO\n" +
			"t\n" + // correct
			"u\n" + // correct
			"r\n" + // correct
			"d\n" + // WRONG 1 of 5 tries
			"z\n" + // WRONG 2 of 5 tries
			"q\n" + // WRONG 3 of 5 tries
			"b\n" + // correct
			"a\n" + // WRONG 4 of 5 tries
			"x\n";  // WRONG 5 of 5 tries = GAME OVER
			
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner read = new Scanner(System.in);
		hg.playHangman(5, read);
		System.setIn(System.in);
		
		String output = consoleContent.toString();
		assertTrue( output.endsWith("Sorry! You ran out of lives. The word was TURBO.\r\n") );
	}
	
	@Test
	public void shouldNotAcceptInputWord() {
		String userInput = " ";
		
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner read = new Scanner(System.in);
		hg.playHangman(5, read);
		System.setIn(System.in);
		
		String output = consoleContent.toString();
		assertTrue( output.endsWith("Sorry, but we can't play without a word!\r\n") );
	}
}
