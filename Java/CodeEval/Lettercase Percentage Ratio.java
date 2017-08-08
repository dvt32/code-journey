// https://www.codeeval.com/open_challenges/147/

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
			
			int lowerCaseLetterCount = 0;
			int upperCaseLetterCount = 0;
			for (int i = 0; i < lineInFile.length(); ++i) {
				if ( Character.isLowerCase(lineInFile.charAt(i)) ) {
					lowerCaseLetterCount++;
				}
				else {
					upperCaseLetterCount++;
				}
			}
			
			int totalLetterCount = lineInFile.length();
			double lowerCaseLetterPercentage =
				( (double) lowerCaseLetterCount / totalLetterCount )
				* 100;
			double upperCaseLetterPercentage =
				( (double) upperCaseLetterCount / totalLetterCount )
				* 100;
			
			System.out.println( 
				"lowercase: " + String.format("%.2f", lowerCaseLetterPercentage) + " " +
				"uppercase: " + String.format("%.2f", upperCaseLetterPercentage)
			);
 		}

		bufferedReader.close();
	}
}
