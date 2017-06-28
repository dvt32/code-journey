// https://www.codeeval.com/open_challenges/103/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File inputFile = new File(args[0]);
        
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
        String lineInFile;

        while ( (lineInFile = bufferedReader.readLine()) != null ) {
            lineInFile = lineInFile.trim();
            
            if (lineInFile.equals("")) {
            	lineInFile = bufferedReader.readLine(); // escape Enter key press
            }
            
            int[] numbers = Arrays.stream( lineInFile.split(" ") ).mapToInt( Integer::parseInt ).toArray();
            
            // Calculate frequency of each number and store the player's number
            Map<Integer, Integer[]> numberFrequenciesAndIndices = new HashMap<Integer, Integer[]>(); //
            for (int i = 0; i < numbers.length; ++i) {
            	Integer[] numberFrequencyAndIndex = numberFrequenciesAndIndices.get( numbers[i] );
            	
            	if (numberFrequencyAndIndex == null) {
            		numberFrequenciesAndIndices.put( 
            			numbers[i], 
            			new Integer[] { 1, i+1 } 
            		);
            	}
            	else {
            		numberFrequenciesAndIndices.put(
            			numbers[i],
            			new Integer[] { (numberFrequencyAndIndex[0] + 1), i+1 }
            		);
            	}
            }
            
            // Get min unique number and the position of the player who chose that number
            int minUniqueNumber = 9;
            int positionOfPlayerWithMinUniqueNumber = 0;
            
            for (Integer number : numberFrequenciesAndIndices.keySet() ) {
            	Integer[] numberFrequencyAndIndex = numberFrequenciesAndIndices.get( number );
            	
            	if (numberFrequencyAndIndex[0] == 1) {
            		if (number < minUniqueNumber) {
            			minUniqueNumber = number;
            			positionOfPlayerWithMinUniqueNumber = numberFrequencyAndIndex[1];
            		}
            	}
            }
            
            System.out.println( positionOfPlayerWithMinUniqueNumber );
            
        }
        
        bufferedReader.close();
    }
}
