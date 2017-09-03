package net.dvt32.designpatterns.task1.humans;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WomanTest {

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
	public void shouldCreateWomanWithNameJaneDoe() {
		Woman woman = new Woman();
		assertTrue( woman.getName().equals("Jane Doe"));
	}
	
	@Test
	public void shouldCreateWomanWithNameHillaryClinton() {
		Woman woman = new Woman("Hillary Clinton");
		assertTrue( woman.getName().equals("Hillary Clinton") );
	}
	
	@Test
	public void shouldSetNameToMotherTheresa() {
		Woman woman = new Woman();
		woman.setName("Mother Theresa");
		assertTrue( woman.getName().equals("Mother Theresa") );
	}
	
	/*
	 * sayOwnName() tests
	 */
	@Test
	public void shouldPrintJaneDoeGreeting() {
		Woman woman = new Woman();
		woman.sayOwnName();
		
		String expectedOutput = "My name is Jane Doe and I'm a woman!" + LINE_SEPARATOR;
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void shouldPrintHillaryClintonGreeting() {
		Woman woman = new Woman("Hillary Clinton");
		woman.sayOwnName();
		
		String expectedOutput = "My name is Hillary Clinton and I'm a woman!" + LINE_SEPARATOR;
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void shouldPrintNullGreeting() {
		Woman woman = new Woman(null);
		woman.sayOwnName();
		
		String expectedOutput = "My name is null and I'm a woman!" + LINE_SEPARATOR;
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}

}