// https://www.codeeval.com/open_challenges/227/

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
            
            lineInFile = lineInFile.replaceAll(" ", "");
            
            int sum = Character.getNumericValue( lineInFile.charAt(0) ) * 2;
            
            for (int i = 1; i < lineInFile.length(); ++i) {
            	if (i % 2 == 0) {
            		sum += Character.getNumericValue( lineInFile.charAt(i) ) * 2;
            	}
            	else {
            		sum += Character.getNumericValue( lineInFile.charAt(i) );
            	}
            }
            
            if (sum % 10 == 0) {
            	System.out.println("Real");
            }
            else {
            	System.out.println("Fake");
            }
        }
        
        bufferedReader.close();
    }
}
