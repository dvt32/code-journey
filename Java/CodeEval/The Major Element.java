// https://www.codeeval.com/open_challenges/132/

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

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
            
            String[] numbers = lineInFile.split(",");
            int appearancesBoundary = numbers.length / 2;
            boolean majorElementFound = false;
            
            for (String number : numbers) {
            	if (Collections.frequency(Arrays.asList(numbers), number) > appearancesBoundary) {
            		System.out.println(number);
            		majorElementFound = true;
            		break;
            	}
            }
            
            if (!majorElementFound) {
            	System.out.println("None");
            }
        }
        
        bufferedReader.close();
    }
}
