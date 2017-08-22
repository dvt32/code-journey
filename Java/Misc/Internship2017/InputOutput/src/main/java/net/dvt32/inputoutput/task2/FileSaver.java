package net.dvt32.inputoutput.task2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This program reads lines from the console until a '.' is entered
 * and saves the entered lines to a text file with a specified path.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class FileSaver {
	/**
	 * This method accomplishes the program's main task (described above).
	 * 
	 * NOTE: The BufferedReader is not closed, 
	 * so that the method can be used multiple times.
	 * 
	 * @param outputFilePath The output path of the text file being saved
	 */
	public void readLinesUntilDotEnteredAndSaveToFile(String outputFilePath) 
		throws IOException  
	{
		FileWriter fileWriter = new FileWriter(outputFilePath);
		BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(System.in) );
		String line = "";
	
		while (true) {
			line = bufferedReader.readLine();
			if (line.equals(".")) {
				break; 
			}
			fileWriter.write(line);
			fileWriter.write( System.getProperty("line.separator") );
		}
		
		fileWriter.close();	
	}
}