// https://www.codeeval.com/open_challenges/83/

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
            
            lineInFile = lineInFile.replaceAll("[^a-zA-Z]", "").toLowerCase();
            
            // Get frequency count for each letter
            Map<Character, Integer> letterFrequencies = new TreeMap<Character, Integer>( );
            for (int i = 0; i < lineInFile.length(); ++i) {
        		Integer currentLetterFrequencyCount = letterFrequencies.get( lineInFile.charAt(i) );
        		
        		if (currentLetterFrequencyCount == null) {
        			letterFrequencies.put( lineInFile.charAt(i), 1 );
        		}
        		else {
        			letterFrequencies.put ( lineInFile.charAt(i), currentLetterFrequencyCount + 1 );
        		}
            }
            
            List<Integer> letterFrequencyValues = new ArrayList<Integer>( letterFrequencies.values() );
            Collections.sort( letterFrequencyValues, Collections.reverseOrder() );
            
            int maxBeauty = 0;
            int letterBeauty = 26;
            
            for (int letterFrequencyValue : letterFrequencyValues ) {
            	while (letterFrequencyValue > 0) {
            		maxBeauty += letterBeauty;
            		letterFrequencyValue--;
            	}
            	letterBeauty--;
            }
            
            System.out.println( maxBeauty );
        }
        
        bufferedReader.close();
    }
}
