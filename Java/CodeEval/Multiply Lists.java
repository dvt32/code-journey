// https://www.codeeval.com/open_challenges/113/

import java.io.*;
import java.util.StringJoiner;
import java.util.stream.Stream;

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
			
			int separatorIndex = lineInFile.indexOf(" | ");
			
			int[] firstList = Stream.of(
				lineInFile.substring(0, separatorIndex).split(" ")
			).mapToInt(Integer::parseInt).toArray(); 
			
			int[] secondList = Stream.of(
				lineInFile.substring(separatorIndex + 3).split(" ")
			).mapToInt(Integer::parseInt).toArray(); 
			
			StringJoiner output = new StringJoiner(" ");
			for (int i = 0; i < firstList.length; ++i) {
				output.add( String.valueOf(firstList[i] * secondList[i]) );
			}
			
			System.out.println( output );
 		}
		
		bufferedReader.close();
	}
}
