package net.dvt32.inputoutput.task3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This program reverses the contents of a text file (line by line).
 * 
 * A constant is used to determine what the system's 
 * line separator character is, 
 * as it differs from system to system.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class TextFileReverser {
	final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	/**
	 * This method accomplishes the program's main task (described above).
	 * 
	 * First it gets the file's current lines in reverse order
	 * and then it writes them to the same file, one by one.
	 * 
	 * The method re-writes the file (it does NOT append the reversed lines).
	 * 
	 * @param filePath The full path to the input text file
	 */
	public void reverseTextInFileWithPath(String filePath)
		throws IOException 
	{
		List<String> reversedLines = getReversedLinesFromFileWithPath(filePath);
		BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter(filePath) );
		
		for (String reversedLine : reversedLines) {
			bufferedWriter.write( reversedLine );
			bufferedWriter.newLine();
		}
		
		bufferedWriter.flush();
		bufferedWriter.close();
	}
	
	/**
	 * This method retrieves every line from the input text file
	 * and returns them in reverse order in the form of a List.
	 * 
	 * @param filePath The full path to the input text file
	 * @return the file's lines in reverse order in the form of a List
	 */
	public List<String> getReversedLinesFromFileWithPath(String filePath) 
		throws IOException 
	{
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		List<String> reversedLines = new ArrayList<String>();
		
		String lineInFile;
		while ( (lineInFile = bufferedReader.readLine()) != null ) {
			String reversedLine = 
				new StringBuilder(lineInFile)
				.reverse()
				.toString();
			
			reversedLines.add( reversedLine );
		}
		
		bufferedReader.close();
		
		return reversedLines;
	}
}