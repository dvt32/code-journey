// page 26

/*
 *  Inserts a line number for each line in a text file
 */

import java.io.*;

public class TextFileLineNumberInserter {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
			new FileReader("D:\\input.txt"));
		PrintWriter printWriter = new PrintWriter(
			new FileWriter("D:\\output.txt"));
		
		int lineNumber = 0;
		String lineInFile = null;
		
		while ( ( lineInFile = bufferedReader.readLine() ) != null ) {
			lineNumber++;
			printWriter.println(lineNumber + " " + lineInFile);
		}
		
		bufferedReader.close();
		printWriter.close();
	}
}
