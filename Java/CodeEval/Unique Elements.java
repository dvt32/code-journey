// https://www.codeeval.com/open_challenges/29/

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

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
			
			String uniqueNumbers = String.join( ",", Arrays.stream(lineInFile.split(",")).collect(Collectors.toSet()) );	
			System.out.println( uniqueNumbers );
 		}

		bufferedReader.close();
	}
}
