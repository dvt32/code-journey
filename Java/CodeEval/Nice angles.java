// https://www.codeeval.com/open_challenges/160/

// More info: http://www.rapidtables.com/convert/number/degrees-to-degrees-minutes-seconds.htm

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
			
			double decimalDegrees = Double.parseDouble( lineInFile );
			int integerDegrees = (int) decimalDegrees;
			int minutes = (int) ( (decimalDegrees - integerDegrees) * 60 );
			int seconds = (int) ( 
				( (decimalDegrees - integerDegrees - minutes/60) * 3600 ) 
				- (minutes * 60) 
			);

			String output = 
				integerDegrees + "."
                                + ( (minutes <= 9) ? ("0" + minutes) : minutes ) + "'"
				+ ( (seconds <= 9) ? ("0" + seconds) : seconds ) + "\"";
			    
			System.out.println(output);
 		}

		bufferedReader.close();
	}
}  
