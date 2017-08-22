package net.dvt32.inputoutput.task2;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class FileSaverTest {
	
	private FileSaver fs = new FileSaver();
	private final String OUTPUT_FILE_PATH = "D://output.txt";
	private final String SECOND_OUTPUT_FILE_PATH = "D://output2.txt";
	private final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	String userInput =
		"hello" + LINE_SEPARATOR +
		"world" + LINE_SEPARATOR +
		".";
	
	@Test
	public void shouldSaveInputToFile() 
		throws IOException 
	{
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		fs.readLinesUntilDotEnteredAndSaveToFile(OUTPUT_FILE_PATH);
		System.setIn( System.in );
	
		StringBuilder actualTextInFile = new StringBuilder();	
		BufferedReader bufferedReader = new BufferedReader(new FileReader(OUTPUT_FILE_PATH));
		String lineInFile;
		while ( (lineInFile = bufferedReader.readLine()) != null ) {
			actualTextInFile.append( lineInFile );
			actualTextInFile.append(LINE_SEPARATOR);
		}
		bufferedReader.close();
		
		String expectedTextInFile = userInput.substring(0, userInput.length()-1);
		assertEquals( expectedTextInFile, actualTextInFile.toString() );
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerException() 
		throws IOException 
	{
		fs.readLinesUntilDotEnteredAndSaveToFile(null);
	}
	
	@Test
	public void shouldSaveInputToTwoFiles() 
		throws IOException 
	{
		String expectedTextInFile = userInput.substring(0, userInput.length()-1);
		
		// Check first file
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		fs.readLinesUntilDotEnteredAndSaveToFile(OUTPUT_FILE_PATH);
		System.setIn( System.in );
		
		StringBuilder actualTextInFirstFile = new StringBuilder();	
		BufferedReader bufferedReader = new BufferedReader(new FileReader(OUTPUT_FILE_PATH));
		String lineInFile;
		while ( (lineInFile = bufferedReader.readLine()) != null ) {
			actualTextInFirstFile.append( lineInFile );
			actualTextInFirstFile.append(LINE_SEPARATOR);
		}
		bufferedReader.close();
		
		assertEquals( expectedTextInFile, actualTextInFirstFile.toString() );
		
		// Check second file
		System.setIn( new ByteArrayInputStream(userInput.getBytes()) );
		fs.readLinesUntilDotEnteredAndSaveToFile(SECOND_OUTPUT_FILE_PATH);
		System.setIn( System.in );
		
		StringBuilder actualTextInSecondFile = new StringBuilder();	
		bufferedReader = new BufferedReader(new FileReader(SECOND_OUTPUT_FILE_PATH));
		while ( (lineInFile = bufferedReader.readLine()) != null ) {
			actualTextInSecondFile.append( lineInFile );
			actualTextInSecondFile.append(LINE_SEPARATOR);
		}
		bufferedReader.close();
		
		assertEquals( expectedTextInFile, actualTextInSecondFile.toString() );
	}
}