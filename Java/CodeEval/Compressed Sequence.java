// https://www.codeeval.com/open_challenges/128/

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
            
            int[] numbers = Arrays.asList(lineInFile.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        
            int currentSubsequenceLength = 0;
            int currentNumber = numbers[0];
            StringJoiner compressedSequence = new StringJoiner(" ");
            
            for (int i = 0; i < numbers.length; ++i) {
            	if (currentNumber == numbers[i]) {
            		currentSubsequenceLength++;
            	}
            	if (currentNumber != numbers[i] || 
            		i == numbers.length-1) 
            	{
            		compressedSequence.add( String.valueOf( currentSubsequenceLength ) );
            		compressedSequence.add( String.valueOf( currentNumber ) );
            		currentNumber = numbers[i];
            		currentSubsequenceLength = 1;
            	}
            }
            
            System.out.println( compressedSequence );
        }
        
        bufferedReader.close();
    }
}
