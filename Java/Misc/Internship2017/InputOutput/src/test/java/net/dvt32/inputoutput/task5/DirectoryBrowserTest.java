package net.dvt32.inputoutput.task5;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DirectoryBrowserTest {

	DirectoryBrowser browser = new DirectoryBrowser();
	private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	final String TEST_PATH = "D:\\ExampleFolder\\";
	
	@Before
	public void setUpOutputStream() {
		System.setOut(new PrintStream(consoleOutput));
	}
	
	@After
	public void cleanUpOutputStream() {
		System.setOut(null);
	}
	
	/*
	 * Helper methods
	 */
	public void createFileInTestPath(String fileName) 
		throws IOException 
	{
		File newFile = new File(TEST_PATH + fileName);
		newFile.getParentFile().mkdirs();
		newFile.createNewFile();
	}
	
	public void createDirectoryInTestPath(String directoryName) 
		throws IOException 
	{
		File newFile = new File(TEST_PATH + directoryName);
		newFile.getParentFile().mkdirs();
		newFile.mkdirs();
	}
	
	/*
	 * listContent() tests
	 */
	@Test
	public void shouldListAllFilesAndDirectoriesInTestPath() 
		throws IOException 
	{
		createFileInTestPath("hello.txt");
		createFileInTestPath("roger.txt");
		createDirectoryInTestPath("ABC");
		createDirectoryInTestPath("Test//AnotherTest");
		
		browser.listContent(TEST_PATH);
		
		/* 
		 * The test is done line by line,
		 * because the File listFiles() method
		 * does not guarantee any order.
		 */
		String[] expectedLinesInOutput = new String[] {
			"File: hello.txt",
			"File: roger.txt",
			"Directory: ABC",
			"Directory: Test"
		};
		
		String actualOutput = consoleOutput.toString();
		
		for (String expectedLine : expectedLinesInOutput) {
			assertTrue( actualOutput.contains(expectedLine) );
		}
		
		assertTrue(
			expectedLinesInOutput.length == actualOutput.split(System.getProperty("line.separator")).length
		);	
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerException() {
		browser.listContent(null);
	}
}