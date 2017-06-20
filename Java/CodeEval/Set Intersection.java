// https://www.codeeval.com/open_challenges/30/

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
            
            String[] sets = lineInFile.split(";");
            String[] firstSetNumbers = sets[0].split(",");
            String[] secondSetNumbers = sets[1].split(",");
            
            StringBuilder intersection = new StringBuilder();
            
            int i = 0;
            int j = 0;
            
            while ( i < firstSetNumbers.length ) {
            	if ( firstSetNumbers[i].equals(secondSetNumbers[j] ) ) {
            		while ( i < firstSetNumbers.length &&
            				j < secondSetNumbers.length &&
            				firstSetNumbers[i].equals(secondSetNumbers[j]) ) 
            		{
            			intersection.append( firstSetNumbers[i] + "," );
            			i++;
            			j++;
            		}
            		break;
            	}
            	else {
            		i++;
            	}
            }
            
            if (intersection.length() > 0) {
            	System.out.println( intersection.substring(0, intersection.length()-1) );
            }
            else {
            	System.out.println();
            }
        }
        
        bufferedReader.close();
    }
}
