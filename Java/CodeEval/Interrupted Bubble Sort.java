// https://www.codeeval.com/open_challenges/158/

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
				continue;
			}
		
			int separatorIndex = lineInFile.indexOf(" | ");
			int[] numbers = 
				Arrays.stream(lineInFile.substring(0, separatorIndex).split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			long targetIterationCount = Long.parseLong(lineInFile.substring(separatorIndex+3));
			
			System.out.println( partialBubbleSort(numbers, targetIterationCount) );
 		}
		
		// Error 404: Clean code not found :(

		bufferedReader.close();
	}
	
	public static String partialBubbleSort(int[] arr, long targetIterationCount) {
		boolean stillSwappingElements = true;
		int j = 0;
		long iterationCount = 0;
		while (stillSwappingElements && iterationCount < targetIterationCount) {
			iterationCount++;
			stillSwappingElements = false;
			j++;
			for (int i = 0; i < (arr.length - j); ++i) {
				if (arr[i] > arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					stillSwappingElements = true;
				}
			}
		}
		
		return Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" "));
	}
}
