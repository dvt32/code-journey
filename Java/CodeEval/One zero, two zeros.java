// https://www.codeeval.com/open_challenges/217/

import java.io.*;

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
            
            int numberOfZeroesNeeded = Integer.parseInt( lineInFile.substring( 0, lineInFile.indexOf(" ") ) );
            int maxNumber = Integer.parseInt( lineInFile.substring( lineInFile.indexOf(" ")+1 ) );
            int validNumberCount = 0;
            
            for (int number = 1; number <= maxNumber; ++number) {
            	if (Integer.toBinaryString(number).replaceAll("1", "").length() == numberOfZeroesNeeded) {
            		validNumberCount++;
            	}
            }
            
            System.out.println( validNumberCount ); 
        }
        
        bufferedReader.close();
    }
}
