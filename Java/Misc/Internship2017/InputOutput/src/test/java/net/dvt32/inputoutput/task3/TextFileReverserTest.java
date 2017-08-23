package net.dvt32.inputoutput.task3;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TextFileReverserTest {
	
	TextFileReverser reverser = new TextFileReverser();
	final String TEST_FILE_PATH = "D:\\test.txt";
	
	/*
	 * Helper methods
	 */
	public List<String> getCurrentLinesInTestFile() 
		throws IOException 
	{
		List<String> currentLinesInFile = new ArrayList<String>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(TEST_FILE_PATH));
		String lineInFile;
		
		while ( (lineInFile = bufferedReader.readLine()) != null ) {
			currentLinesInFile.add( lineInFile );
		}
		
		bufferedReader.close();
		
		return currentLinesInFile;
	}
	
	public String reverse(String str) {
		String reversedString = (new StringBuilder(str).reverse().toString());
		return reversedString;
	}

	/*
	 * getReversedLinesFromFileWithPath() tests
	 */
	@Test
	public void shouldGetAllLinesReversed() 
		throws IOException 
	{
		List<String> lines = getCurrentLinesInTestFile();
		List<String> supposedlyReversedLines = reverser.getReversedLinesFromFileWithPath(TEST_FILE_PATH);
		
		assertTrue( lines.size() == supposedlyReversedLines.size() );
		
		for (int i = 0; i < lines.size(); ++i) {
			assertTrue(
				supposedlyReversedLines.get(i).equals( reverse(lines.get(i)) )
			);
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerException() 
		throws IOException 
	{
		reverser.getReversedLinesFromFileWithPath(null);
	}
	
	/*
	 * reverseTextInFileWithPath() tests
	 */
	@Test
	public void shouldReverseAllLinesOfTextFile() 
		throws IOException 
	{
		// Get lines of file before reversing
		List<String> linesInFileBeforeReversing = getCurrentLinesInTestFile();
		
		// Call tested method
		reverser.reverseTextInFileWithPath(TEST_FILE_PATH);
		
		// Get lines of file after reversing
		List<String> linesInFileAfterReversing = getCurrentLinesInTestFile();
		
		// Check to see if every line has been reversed
		assertTrue( linesInFileBeforeReversing.size() == linesInFileAfterReversing.size() );	
		for (int i = 0; i < linesInFileBeforeReversing.size(); ++i) {
			assertTrue(
				linesInFileAfterReversing.get(i).equals(
					reverse( linesInFileBeforeReversing.get(i) ) 
				)
			);
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void reverseFileMethodShouldThrowNullPointerException() 
		throws IOException 
	{
		reverser.reverseTextInFileWithPath(null);
	}
}