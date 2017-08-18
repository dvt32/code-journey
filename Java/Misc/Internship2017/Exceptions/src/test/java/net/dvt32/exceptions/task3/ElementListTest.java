package net.dvt32.exceptions.task3;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * NOTE: Some of the tests violate the "test only one thing at a time" principle 
 * 		(adding and printing elements at the same time, for example), but the task doesn't specify 
 * 		whether methods such as get(int elementIndex) are allowed,
 * 		so only specifically allowed methods are used (excluding getMaxListSize())
 */

public class ElementListTest {
	
	private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	
	@Before
	public void setUpOutputStream() {
		System.setOut(new PrintStream(consoleOutput));
	}
	
	@After
	public void cleanUpOutputStream() {
		System.setOut(null);
	}


	/*
	 * Constructor & getMaxListSize() tests
	 */
	@Test
	public void shouldCreateElementListWithMaxSize10() {
		ElementList el = new ElementList(10);
		assertTrue( el instanceof ElementList && el.getMaxListSize() == 10 );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentException() {
		ElementList el = new ElementList(-1);
	}
	
	@Test(expected = NumberFormatException.class)
	public void shouldThrowNumberFormatExceptionWhenTryingToGetMaxListSize() {
		ElementList el = new ElementList(new Integer(null));
		el.getMaxListSize();
	}
	
	/*
	 * add() tests
	 */
	@Test(expected = FullListException.class)
	public void shouldAddOnlyFirstThreeElementsAndThrowFullListExceptionOnLastOne() {
		ElementList el = new ElementList(3);
		
		String firstElement = "Hello";
		Integer secondElement = 1;
		Double thirdElement = 2.0d;
		Long fourthElement = 100L;
		
		el.add(firstElement);
		el.add(secondElement);
		el.add(thirdElement);
		
		el.printAllElements();
		
		el.add(fourthElement);
	}
	
	@Test
	public void shouldAddAllElementsAndPrintThem() {
		ElementList el = new ElementList(4);
		
		String firstElement = "Hello";
		Integer secondElement = 1;
		Double thirdElement = 2.0d;
		Long fourthElement = 100L;
		
		el.add(firstElement);
		el.add(secondElement);
		el.add(thirdElement);
		el.add(fourthElement);
		
		el.printAllElements();
		
		String expectedOutput = "Hello 1 2.0 100 \r\n";
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
	
	/*
	 * remove() tests
	 */
	@Test(expected = EmptyListException.class)
	public void shouldThrowEmptyListException_FirstTest() {
		ElementList el = new ElementList(123);
		el.add(1);
		el.remove();
		el.remove();
	}
	
	@Test(expected = EmptyListException.class)
	public void shouldThrowEmptyListException_SecondTest() {
		ElementList el = new ElementList(123);
		el.remove();
	}
	
	@Test
	public void shouldRemoveAllElementsAndPrintNothingExceptSpecialCharacters() {
		ElementList el = new ElementList(4);
		
		String firstElement = "Hello";
		Integer secondElement = 1;
		Double thirdElement = 2.0d;
		Long fourthElement = 100L;
		
		el.add(firstElement);
		el.add(secondElement);
		el.add(thirdElement);
		el.add(fourthElement);
		
		el.remove();
		el.remove();
		el.remove();
		el.remove();
		
		el.printAllElements();
		String expectedOutput = "\r\n";
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
	
	/*
	 * printAllElements() tests
	 */
	@Test
	public void shouldPrintNothingExceptSpecialCharacters() {
		ElementList el = new ElementList(1000);
		el.printAllElements();
		String expectedOutput = "\r\n";
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void shouldPrintElementValues() {
		ElementList el = new ElementList(3);
		el.add(1);
		el.add("2");
		
		el.printAllElements();
		String expectedOutput = "1 2 \r\n";
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);	
	}
}