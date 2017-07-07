// https://www.codeeval.com/open_challenges/40/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

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
            
            // Get number of frequencies of each digit
            Map<Integer, Integer> digitFrequencies = new HashMap<Integer, Integer>();
            for (int i = 0; i < lineInFile.length(); ++i) {
            	int currentDigit = Character.getNumericValue( lineInFile.charAt(i) );
            	Integer currentDigitFrequencyCount = digitFrequencies.get( currentDigit );
            	
            	if (currentDigitFrequencyCount == null) {
            		digitFrequencies.put( currentDigit, 1 );
            	}
            	else {
            		digitFrequencies.put( currentDigit, currentDigitFrequencyCount + 1 );
            	}
            	
            	// Add index number to map as well
            	if ( !digitFrequencies.containsKey(i) ) {
            		digitFrequencies.put(i, 0);
            	}
            }
            
            // Determine if number is self-describing
            boolean isSelfDescribingNumber = true;
            for (int i = 0; i < lineInFile.length(); ++i) {
            	int currentDigit = Character.getNumericValue( lineInFile.charAt(i) );
            	if (digitFrequencies.get(i) != currentDigit) {
            		isSelfDescribingNumber = false;
            		break;
            	}
            }
            
            // Print end result
            if (isSelfDescribingNumber) {
            	System.out.println("1");
            }
            else {
            	System.out.println("0");
            }
        }
        
        bufferedReader.close();
    }
}
