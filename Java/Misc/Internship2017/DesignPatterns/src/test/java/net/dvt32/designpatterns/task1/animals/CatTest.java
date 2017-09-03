package net.dvt32.designpatterns.task1.animals;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CatTest {

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
	public void shouldCreateCatWithAgeZero() {
		Cat cat = new Cat();
		assertTrue( cat.getAge() == 0 );
	}
	
	@Test
	public void shouldCreateCatWithAgeFive() {
		Cat cat = new Cat(5);
		assertTrue( cat.getAge() == 5 );
	}
	
	@Test(expected = NumberFormatException.class)
	public void shouldThrowNumberFormatException() {
		Cat cat = new Cat(new Integer(null));
	}
	
	@Test
	public void shouldSetCatAgeTo10() {
		Cat cat = new Cat(-1);
		cat.setAge(10);
		assertTrue( cat.getAge() == 10 );
	}
	
	/*
	 * speak() tests
	 */
	public void shouldPrintMeow() {
		Cat cat = new Cat();
		cat.speak();
		
		String expectedOutput = "Meow!" + LINE_SEPARATOR;
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
}