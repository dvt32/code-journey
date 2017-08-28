package net.dvt32.collections.task2;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class PageBeanTest {
	
	private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	@Before
	public void setUpOutputStream() {
		System.setOut( new PrintStream(consoleOutput) );
	}
	
	@After
	public void cleanUpOutputStream() {
		System.setOut( null );
	}

	/*
	 * Constructor tests
	 */
	@Test
	public void firstPageShouldHaveFourElements() {
		String userInput = LINE_SEPARATOR;
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner scanner = new Scanner(System.in);
		PageBean<Integer> pb = new PageBean<Integer>(
			4, 
			Arrays.asList( 
				1, 2, 3, 4, 
				5, 6, 7, 8, 
				9 
			),
			scanner
		);
		System.setIn(System.in);
		
		assertEquals("[1, 2, 3, 4]" + LINE_SEPARATOR, consoleOutput.toString());
	}
	
	@Test
	public void firstPageShouldHaveElementsWithValueOneAndNull() {
		String userInput = LINE_SEPARATOR;
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner scanner = new Scanner(System.in);
		PageBean<Integer> pb = new PageBean<Integer>(
			2, 
			Arrays.asList( 
				1, null
			),
			scanner
		);
		System.setIn(System.in);
		
		assertEquals("[1, null]" + LINE_SEPARATOR, consoleOutput.toString());
	}
	
	@Test
	public void shouldCreatePageBeanWithThreePages() {
		String userInput = "next" + LINE_SEPARATOR + "next" + LINE_SEPARATOR;
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner scanner = new Scanner(System.in);
		PageBean<Integer> pb = new PageBean<Integer>(
			4, 
			Arrays.asList( 
				1, 2, 3, 4, 
				5, 6, 7, 8, 
				9 
			),
			scanner
		);
		System.setIn(System.in);
		
		assertEquals(
			"[1, 2, 3, 4]" + LINE_SEPARATOR + "[5, 6, 7, 8]" + LINE_SEPARATOR + "[9]" + LINE_SEPARATOR, 
			consoleOutput.toString()
		);
	}
	
	@Test(expected = NullPointerException.class)
	public void constructorShouldThrowNullPointerException() {
		PageBean<Integer> pb = new PageBean<Integer>(
			4, 
			null,
			null
		);
	}
	
	/*
	 * next() tests
	 */
	@Test
	public void shouldReturnListWithElements5_6_7_8() {
		String userInput = LINE_SEPARATOR;
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner scanner = new Scanner(System.in);
		PageBean<Integer> pb = new PageBean<Integer>(
			4, 
			Arrays.asList( 
				1, 2, 3, 4, 
				5, 6, 7, 8, 
				9 
			),
			scanner
		);
		System.setIn(System.in);
		
		List<Integer> expectedList = Arrays.asList(5, 6, 7, 8);
		List<Integer> actualList = pb.next();
		
		assertThat(actualList, is(expectedList));
	}
	
	@Test(expected = NoSuchElementException.class)
	public void shouldThrowNoSuchElementException() {
		String userInput = LINE_SEPARATOR;
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner scanner = new Scanner(System.in);
		PageBean<Integer> pb = new PageBean<Integer>(
			4, 
			Arrays.asList( 
				1, 2, 3, 4
			),
			scanner
		);
		System.setIn(System.in);
		
		pb.next();
	}
	
	/*
	 * previous() tests
	 */
	@Test
	public void shouldReturnListWithElements1_2_3_4() {
		String userInput = "next" + LINE_SEPARATOR;
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner scanner = new Scanner(System.in);
		PageBean<Integer> pb = new PageBean<Integer>(
			4, 
			Arrays.asList( 
				1, 2, 3, 4, 
				5, 6, 7, 8, 
				9 
			),
			scanner
		);
		System.setIn(System.in);
		
		List<Integer> expectedList = Arrays.asList(1, 2, 3, 4);
		List<Integer> actualList = pb.previous();
		
		assertThat(actualList, is(expectedList));
	}
	
	@Test(expected = NoSuchElementException.class)
	public void previousMethodShouldThrowNoSuchElementException() {
		String userInput = LINE_SEPARATOR;
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner scanner = new Scanner(System.in);
		PageBean<Integer> pb = new PageBean<Integer>(
			4, 
			Arrays.asList( 
				1, 2, 3, 4
			),
			scanner
		);
		System.setIn(System.in);
		
		pb.previous();
	}
	
	/*
	 * hasNext() tests
	 */
	@Test
	public void shouldReturnTrueBecausePageBeanHasNextPage() {
		String userInput = "next" + LINE_SEPARATOR;
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner scanner = new Scanner(System.in);
		PageBean<Integer> pb = new PageBean<Integer>(
			4, 
			Arrays.asList( 
				1, 2, 3, 4, 
				5, 6, 7, 8, 
				9 
			),
			scanner
		);
		System.setIn(System.in);
		
		assertTrue( pb.hasNext() );
	}
	
	@Test
	public void shouldReturnFalseBecausePageBeanDoesNotHaveNextPage() {
		String userInput = LINE_SEPARATOR;
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner scanner = new Scanner(System.in);
		PageBean<Integer> pb = new PageBean<Integer>(
			4, 
			Arrays.asList( 
				1, 2, 3, 4
			),
			scanner
		);
		System.setIn(System.in);
		
		assertFalse( pb.hasNext() );
	}
	
	/*
	 * hasPrevious() tests
	 */
	@Test
	public void shouldReturnTrueBecausePageBeanHasPreviousPage() {
		String userInput = "next" + LINE_SEPARATOR + "next" + LINE_SEPARATOR;
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner scanner = new Scanner(System.in);
		PageBean<Integer> pb = new PageBean<Integer>(
			4, 
			Arrays.asList( 
				1, 2, 3, 4, 
				5, 6, 7, 8, 
				9 
			),
			scanner
		);
		System.setIn(System.in);
		
		assertTrue( pb.hasPrevious() );
	}
	
	@Test
	public void shouldReturnFalseBecausePageBeanHasPreviousPage() {
		String userInput = LINE_SEPARATOR;
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner scanner = new Scanner(System.in);
		PageBean<Integer> pb = new PageBean<Integer>(
			4, 
			Arrays.asList( 
				1, 2, 3, 4, 
				5, 6, 7, 8, 
				9 
			),
			scanner
		);
		System.setIn(System.in);
		
		assertFalse( pb.hasPrevious() );
	}
	
	/*
	 * firstPage() tests
	 */
	@Test
	public void shouldReturnFirstPage_FirstTest() {
		String userInput = "next" + LINE_SEPARATOR + "next" + LINE_SEPARATOR;
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner scanner = new Scanner(System.in);
		PageBean<Integer> pb = new PageBean<Integer>(
			4, 
			Arrays.asList( 
				1, 2, 3, 4, 
				5, 6, 7, 8, 
				9 
			),
			scanner
		);
		System.setIn(System.in);
		
		List<Integer> expectedList = Arrays.asList(1, 2, 3, 4);
		List<Integer> actualList = pb.firstPage();
		
		assertThat(actualList, is(expectedList));
	}
	
	@Test
	public void shouldReturnFirstPage_SecondTest() {
		String userInput = LINE_SEPARATOR;
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner scanner = new Scanner(System.in);
		PageBean<Integer> pb = new PageBean<Integer>(
			1, 
			Arrays.asList(1),
			scanner
		);
		System.setIn(System.in);
		
		List<Integer> expectedList = Arrays.asList(1);
		List<Integer> actualList = pb.firstPage();
		
		assertThat(actualList, is(expectedList));
	}
	
	/*
	 * lastPage() tests
	 */
	@Test
	public void shouldReturnLastPage_FirstTest() {
		String userInput = "next" + LINE_SEPARATOR;
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner scanner = new Scanner(System.in);
		PageBean<Integer> pb = new PageBean<Integer>(
			4, 
			Arrays.asList( 
				1, 2, 3, 4, 
				5, 6, 7, 8, 
				9 
			),
			scanner
		);
		System.setIn(System.in);
		
		List<Integer> expectedList = Arrays.asList(9);
		List<Integer> actualList = pb.lastPage();
		
		assertThat(actualList, is(expectedList));
	}
	
	@Test
	public void shouldReturnLastPage_SecondTest() {
		String userInput = LINE_SEPARATOR;
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner scanner = new Scanner(System.in);
		PageBean<Integer> pb = new PageBean<Integer>(
			1, 
			Arrays.asList(1),
			scanner
		);
		System.setIn(System.in);
		
		List<Integer> expectedList = Arrays.asList(1);
		List<Integer> actualList = pb.lastPage();
		
		assertThat(actualList, is(expectedList));
	}
	
	/*
	 * readMethodNamesFromConsoleWithScanner() tests
	 */
	@Test
	public void shouldPrintFirstTwoPages() {
		String userInput = LINE_SEPARATOR;
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner scanner = new Scanner(System.in);
		PageBean<Integer> pb = new PageBean<Integer>(
			4, 
			Arrays.asList( 
				1, 2, 3, 4, 
				5, 6, 7, 8, 
				9 
			),
			scanner
		);
		System.setIn(System.in);
		
		System.setIn( new ByteArrayInputStream( ("next" + LINE_SEPARATOR).getBytes()) );
		scanner = new Scanner(System.in);
		pb.readMethodNamesFromConsoleWithScanner(scanner);
		System.setIn(System.in);
		
		assertEquals(
			"[1, 2, 3, 4]" + LINE_SEPARATOR + "[5, 6, 7, 8]" + LINE_SEPARATOR, 
			consoleOutput.toString()
		);
	}
	
	@Test
	public void shouldPrintFirstTwoPagesAndThenFirstPageAgain() {
		String userInput = LINE_SEPARATOR;
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		Scanner scanner = new Scanner(System.in);
		PageBean<Integer> pb = new PageBean<Integer>(
			4, 
			Arrays.asList( 
				1, 2, 3, 4, 
				5, 6, 7, 8, 
				9 
			),
			scanner
		);
		System.setIn(System.in);
		
		System.setIn( new ByteArrayInputStream( ("next" + LINE_SEPARATOR + "previous" + LINE_SEPARATOR).getBytes()) );
		scanner = new Scanner(System.in);
		pb.readMethodNamesFromConsoleWithScanner(scanner);
		System.setIn(System.in);
		
		assertEquals(
			"[1, 2, 3, 4]" + LINE_SEPARATOR + "[5, 6, 7, 8]" + LINE_SEPARATOR + "[1, 2, 3, 4]" + LINE_SEPARATOR, 
			consoleOutput.toString()
		);
	}
}