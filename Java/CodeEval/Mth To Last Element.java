// https://www.codeeval.com/open_challenges/10/

import java.io.*;

public class Main {	
	public static void main(String[] args) 
		throws IOException
	{
		//File inputFile = new File( args[0] );
		File inputFile = new File("D://input.txt");
		BufferedReader bufferedReader = new BufferedReader( new FileReader(inputFile) );
		String lineInFile;
		
		while ( (lineInFile = bufferedReader.readLine()) != null ) {
			lineInFile = lineInFile.trim();
			
			if (lineInFile.isEmpty()) {
				lineInFile = bufferedReader.readLine(); // Escape Enter key press
			}
			
			String[] dataOnLine = lineInFile.split(" ");
			int indexToFind = Integer.parseInt( dataOnLine[dataOnLine.length-1] );
			
			if ( indexToFind <= (dataOnLine.length-1) ) {
				System.out.println(dataOnLine[dataOnLine.length-1 - indexToFind]);
			}
			
			// Cool readability, bro. :P
 		}

		bufferedReader.close();
	}
}
