// https://www.codeeval.com/open_challenges/17/

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
			
			int[] numbers = Arrays.stream(lineInFile.split(",")).mapToInt(Integer::parseInt).toArray();
			int maxSum = Integer.MIN_VALUE;
			
			for (int i = 0; i < numbers.length; ++i) {
				int sum = numbers[i];
				for (int j = i+1; j < numbers.length; ++j) {
					sum += numbers[j];
					if (sum > maxSum) {
						maxSum = sum;
					}
				}
			}
			
			System.out.println( maxSum );
 		}

		bufferedReader.close();
	}
}
