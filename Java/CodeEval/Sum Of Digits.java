// https://www.codeeval.com/open_challenges/225/

import java.io.*;
import java.util.Arrays;

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
			
			int sumOfDigits = Arrays.stream(lineInFile.split("")).mapToInt(Integer::parseInt).sum();
			System.out.println(sumOfDigits);
 		}

		bufferedReader.close();
	}
}
