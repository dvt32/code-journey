// https://www.codeeval.com/open_challenges/115/

import java.io.*;
import java.util.StringJoiner;

public class Main {	
	public static void main(String[] args) 
		throws IOException 
	{
		File inputFile = new File( args[0] );
		BufferedReader bufferedReader = new BufferedReader( new FileReader(inputFile) );
		String lineInFile;

		while ( (lineInFile = bufferedReader.readLine()) != null ) {
			lineInFile = lineInFile.trim();
			
			if (lineInFile.isEmpty()) {
				lineInFile = bufferedReader.readLine(); // Escape Enter key press
			}
			
			String[] elements = lineInFile.split(",");
			StringJoiner words = new StringJoiner(",");
			StringJoiner numbers = new StringJoiner(",");
			
			for (String element : elements) {
				try {
					numbers.add( String.valueOf(Integer.parseInt(element)) );
				}
				catch (NumberFormatException nfe) {
					words.add(element);
				}
			}
			
			System.out.println( words + "|" + numbers );
 		}

		bufferedReader.close();
	}
}
