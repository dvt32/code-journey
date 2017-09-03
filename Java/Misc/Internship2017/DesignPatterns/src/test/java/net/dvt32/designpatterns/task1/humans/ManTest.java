package net.dvt32.designpatterns.task1.humans;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManTest {

	private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	private final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	@Before
	public void setUpOutputStream() {
		System.setOut( new PrintStream(consoleOutput) );
	}
	
	@After
	public void cleanUpOutputStream() {
		System.setOut(null);
	}
	
	/*
	 * Constructor + getter/setter tests
	 */
	@Test
	public void shouldCreateManWithNameJohnDoe() {
		Man man = new Man();
		assertTrue( man.getName().equals("John Doe") );
	}
	
	@Test
	public void shouldCreateManWithNameThomasEdison() {
		Man man = new Man("Thomas Edison");
		assertTrue( man.getName().equals("Thomas Edison") );
	}
	
	@Test
	public void shouldSetNameToJohnnyBravo() {
		Man man = new Man();
		man.setName("Johnny Bravo");
		assertTrue( man.getName().equals("Johnny Bravo") );
	}
	
	/*
	 * sayOwnName() tests
	 */
	@Test
	public void shouldPrintJohnDoeGreeting() {
		Man man = new Man();
		man.sayOwnName();
		
		String expectedOutput = "My name is John Doe and I'm a man!" + LINE_SEPARATOR;
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void shouldPrintThomasEdisonGreeting() {
		Man man = new Man("Thomas Edison");
		man.sayOwnName();
		
		String expectedOutput = "My name is Thomas Edison and I'm a man!" + LINE_SEPARATOR;
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void shouldPrintNullGreeting() {
		Man man = new Man(null);
		man.sayOwnName();
		
		String expectedOutput = "My name is null and I'm a man!" + LINE_SEPARATOR;
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}

}