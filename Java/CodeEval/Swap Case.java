// https://www.codeeval.com/open_challenges/96/

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
            
            StringBuilder output = new StringBuilder();
            
            for (int i = 0; i < lineInFile.length(); ++i) {
            	if ( Character.isLowerCase(lineInFile.charAt(i)) ) {
            		output.append( Character.toUpperCase(lineInFile.charAt(i)) );
            	}
            	else {
            		output.append( Character.toLowerCase(lineInFile.charAt(i)) );
            	}
            }
            
            System.out.println( output );
        }
        
        bufferedReader.close();
    }
}
