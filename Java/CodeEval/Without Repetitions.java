// https://www.codeeval.com/open_challenges/102/

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
           
            StringBuilder output = new StringBuilder( String.valueOf(lineInFile.charAt(0)) );
            
            for (int i = 1; i < lineInFile.length(); ++i) {
            	if ( lineInFile.charAt(i) != lineInFile.charAt(i-1) ) {
            		output.append( lineInFile.charAt(i) );
            	}
            }
            
            System.out.println( output );
        }
        
        bufferedReader.close();
    }
}
