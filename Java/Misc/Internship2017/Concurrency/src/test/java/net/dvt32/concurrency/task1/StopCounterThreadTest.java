package net.dvt32.concurrency.task1;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StopCounterThreadTest {

	final String LINE_SEPARATOR = System.getProperty("line.separator");
	private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	
	@Before
	public void setUpOutputStream() {
		System.setOut( new PrintStream(consoleOutput) );
	}
	
	@After
	public void cleanUpOutputStream() {
		System.setOut(null);
	}
	
	/*
	 * Constructor tests
	 */
	@Test
	public void shouldCreateObjectWithZeroElapsedSecondsAndFourTargetSeconds() {
		StopCounterThread sct = new StopCounterThread(4);
		assertEquals(0, sct.getElapsedSeconds());
		assertEquals(4, sct.getTargetSeconds());
	}
	
	@Test
	public void shouldCreateStopCounterThreadObjectWithInitializedInternalThread() {
		StopCounterThread sct = new StopCounterThread(4);
		assertTrue( sct.getCounterThread() instanceof Thread );
	}
	
	@Test(expected = NumberFormatException.class)
	public void shouldThrowNumberFormatException() {
		StopCounterThread sct = new StopCounterThread( new Integer(null) );
	}
	
	/*
	 * run() tests
	 */
	@Test
	public void shouldInterruptThreadOnThirdSecond() 
		throws InterruptedException
	{
		StopCounterThread sct = new StopCounterThread(5);
		sct.getCounterThread().start();
		
		Thread.sleep(3000);
		
		String userInput = "hello" + LINE_SEPARATOR;
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		sct.readLineAndPrintElapsedSeconds( new Scanner(System.in) );
		System.setIn(System.in);
		
		String expectedOutput = "3" + LINE_SEPARATOR;
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void shouldLetThreadExecuteAndPrintFive() 
		throws InterruptedException
	{
		StopCounterThread sct = new StopCounterThread(5);
		sct.getCounterThread().start();
		sct.getCounterThread().join();
		
    	String userInput = "hello" + LINE_SEPARATOR;
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		sct.readLineAndPrintElapsedSeconds( new Scanner(System.in) );
		System.setIn(System.in);
	
		String expectedOutput = "5" + LINE_SEPARATOR;
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
}