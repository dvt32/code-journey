// https://www.codeeval.com/open_challenges/34/

import java.io.*;
import java.util.Arrays;
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
				continue;
			}
		
			int separatorIndex = lineInFile.indexOf(";");
			int[] numbers = 
				Arrays.stream( lineInFile.substring(0, separatorIndex).split(",") )
				.mapToInt(Integer::parseInt)
				.toArray();
			int x = Integer.parseInt( lineInFile.substring(separatorIndex+1) );
			
			StringJoiner pairs = new StringJoiner(";");
			for (int i = 0; i < numbers.length-1; ++i) {
				for (int j = i+1; j < numbers.length; ++j) {
					if ( (numbers[i] + numbers[j]) == x ) {
						pairs.add(numbers[i] + "," + numbers[j]);
					}
				}
			}
			
			if (pairs.length() > 0) {
				System.out.println(pairs);
			}
			else {
				System.out.println("NULL");
			}
 		}

		bufferedReader.close();
	}
}
