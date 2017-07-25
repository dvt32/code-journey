// https://www.codeeval.com/open_challenges/232/

import java.io.*;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class Main {	
	public static void main(String[] args) throws IOException {
            File inputFile = new File( args[0] );
		
	    BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
	    String lineInFile;  
	
	    while ( (lineInFile = bufferedReader.readLine()) != null ) {
	        lineInFile = lineInFile.trim();
	        
	        if (lineInFile.equals("")) {
	        	lineInFile = bufferedReader.readLine(); // escape Enter key press
	        }
	        
	        String[] dataOnLine = lineInFile.split(" \\| ");
	        int[] numbers = Stream.of(dataOnLine[0].split(" ")).mapToInt(Integer::parseInt).toArray();
	        int iterationCount = Integer.parseInt(dataOnLine[1]);
	        
	        stupidSort(numbers, iterationCount);
	        
	        StringJoiner output = new StringJoiner(" ");
	        for (int number : numbers) {
	        	output.add(String.valueOf(number));
	        }
	        
	        System.out.println(output);
	    }
	    
	    bufferedReader.close();
	}
	
	public static void stupidSort(int[] arr, int iterationCount) {
		for (int i = 0; i < iterationCount; ++i) {
			for (int j = 1; j < arr.length; ++j) {
				if (arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
					break;
				}
			}
		}
	}
}
