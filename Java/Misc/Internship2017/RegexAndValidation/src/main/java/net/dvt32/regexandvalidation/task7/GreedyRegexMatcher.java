package net.dvt32.regexandvalidation.task7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This program finds text that is surrounded by <x></x> tags
 * and replaces it with "<x/>" (the tags themselves are also part of the text to be replaced)
 * 
 * The text between the tags must NOT contain the characters '<' or '>'.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class GreedyRegexMatcher {
	/**
	 * This method accomplishes the program's main task (described above).
	 * 
	 * @param inputString The input string
	 * @return the input string with replaced <x>text</x> segments
	 */
	public String getStringWithXTagsReplaced(String inputString) {
		Matcher m = Pattern.compile(
			// Starts with <x>
			"<x>"
			// Is then followed by a sequence of characters (0 or more) that are not '<' or '>'
			+ "[^<>]*"
			// Ends with </x>
			+ "<\\/x>"
		).matcher(inputString);
		
		while ( m.find() ) {
			String segmentToReplace = m.group();
			inputString = inputString.replace(segmentToReplace, "<x/>");
		}
		
		return inputString;
	}
}