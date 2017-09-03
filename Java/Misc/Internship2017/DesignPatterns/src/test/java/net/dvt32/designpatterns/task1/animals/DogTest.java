package net.dvt32.designpatterns.task1.animals;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DogTest {

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
	public void shouldCreateDogWithAgeZero() {
		Dog dog = new Dog();
		assertTrue( dog.getAge() == 0 );
	}
	
	@Test
	public void shouldCreateDogWithAgeFive() {
		Dog dog = new Dog(5);
		assertTrue( dog.getAge() == 5 );
	}
	
	@Test(expected = NumberFormatException.class)
	public void shouldThrowNumberFormatException() {
		Dog dog = new Dog(new Integer(null));
	}
	
	@Test
	public void shouldSetDogAgeTo10() {
		Dog dog = new Dog(-1);
		dog.setAge(10);
		assertTrue( dog.getAge() == 10 );
	}
	
	/*
	 * speak() tests
	 */
	public void shouldPrintWoof() {
		Dog dog = new Dog();
		dog.speak();
		
		String expectedOutput = "Woof!" + LINE_SEPARATOR;
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}

}