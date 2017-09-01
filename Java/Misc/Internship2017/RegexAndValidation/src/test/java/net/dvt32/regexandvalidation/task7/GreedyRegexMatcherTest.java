package net.dvt32.regexandvalidation.task7;

import static org.junit.Assert.*;

import org.junit.Test;

public class GreedyRegexMatcherTest {

	GreedyRegexMatcher grm = new GreedyRegexMatcher();
	private final String EXAMPLE_INPUT =
		"<x><b></b><x>Hello world</x>\r\n" + 
		"<b>sdfsdf</b><x>Good \r\n" + 
		"morning</x><x>69</x><x>sdfsdfsdf</x>\r\n" + 
		"</x>\r\n";
	
	@Test
	public void shouldReplaceAllNestedTagsWithinMainXTag() {
		String expectedResult =
			"<x><b></b><x/>\r\n" + 
			"<b>sdfsdf</b><x/><x/><x/>\r\n" + 
			"</x>\r\n";
		String actualResult = grm.getStringWithXTagsReplaced(EXAMPLE_INPUT);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerException() {
		grm.getStringWithXTagsReplaced(null);
	}
	
	@Test
	public void shouldReplaceOnlyValidXTags() {
		String input = 
			"<x><b>\r\n" // should NOT replace (there are nested tags within X tag)
			+ "<x></x>\r\n" // should replace
			+ "<x>!!!_ aSDFFFHello ZING zxasXworld</x>\r\n" // should replace
			+ "</x>\r\n" // should NOT replace (the opening tag on line 1 was not valid)
			+ "<x></x>\r\n" // should replace
			+ "<X>asd</x>\r\n" // should NOT replace (first tag has a capitalized X)
			+ "<x>a></x>\r\n" // should NOT replace (there are '>' and '<' between X tags)
			+ "<x>Good \r\nmorning</x>\r\n"; // should replace
		
		String expectedResult =
			"<x><b>\r\n"
			+ "<x/>\r\n"
			+ "<x/>\r\n"
			+ "</x>\r\n"
			+ "<x/>\r\n"
			+ "<X>asd</x>\r\n"
			+ "<x>a></x>\r\n"
			+ "<x/>\r\n";
		String actualResult = grm.getStringWithXTagsReplaced(input);
		assertEquals(expectedResult, actualResult);
	}

}
