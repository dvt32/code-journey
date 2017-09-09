// https://www.codeeval.com/open_challenges/186/

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
				continue;
			}
		
			int separatorIndex = lineInFile.indexOf(";");
			int n = Integer.parseInt( lineInFile.substring(0, separatorIndex) );
			int[] numbers = 
				Arrays.stream(lineInFile.substring(separatorIndex+1).split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			
			int maxGain = Integer.MIN_VALUE;
			for (int i = 0; i < (numbers.length - n + 1); ++i) {
				int gain = 0;
				for (int j = i; j < (i+n); ++j) {
					gain += numbers[j];
				}
				if (gain > maxGain) {
					maxGain = gain;
				}
			}
			
			System.out.println( maxGain >= 0 ? maxGain : 0 );
 		}

		bufferedReader.close();
	}
}
