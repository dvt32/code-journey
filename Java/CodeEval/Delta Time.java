// https://www.codeeval.com/open_challenges/166/

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
			
			int separatorIndex = lineInFile.indexOf(" ");
			int[] firstTime = Arrays.stream(
				lineInFile.substring(0, separatorIndex).split(":")
			).mapToInt(Integer::parseInt).toArray();
			int[] secondTime = Arrays.stream(
				lineInFile.substring(separatorIndex+1).split(":")
			).mapToInt(Integer::parseInt).toArray();
			
			int firstTimeInSeconds = 
				firstTime[0] * 3600 +
				firstTime[1] * 60 +
				firstTime[2];
			
			int secondTimeInSeconds =
				secondTime[0] * 3600 +
				secondTime[1] * 60 +
				secondTime[2];	
			
			int differenceInSeconds = Math.abs(firstTimeInSeconds - secondTimeInSeconds);
			
			int hours = differenceInSeconds / 3600;
			int minutes = (differenceInSeconds / 60) - (hours * 60);
			int seconds = differenceInSeconds - (hours * 3600) - (minutes * 60);
			
			System.out.println( 
				String.format("%02d:%02d:%02d", hours, minutes, seconds)
			);	
 		}

		bufferedReader.close();
	}
}  
