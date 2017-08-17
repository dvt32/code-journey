// https://www.codeeval.com/open_challenges/18/

import java.io.*;

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
			
			int separatorIndex = lineInFile.indexOf(",");
			int x = Integer.parseInt( lineInFile.substring(0, separatorIndex) );
			int n = Integer.parseInt( lineInFile.substring(separatorIndex + 1) );
			
			int smallestMultiple = n;
			while (smallestMultiple < x) {
				smallestMultiple += n;
			}
			
			System.out.println(smallestMultiple);
 		}

		bufferedReader.close();
	}
}
