// https://www.codeeval.com/open_challenges/199/

import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException {
            File inputFile = new File( args[0] );
		
	    BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
	    String lineInFile;  
	
	    while ( (lineInFile = bufferedReader.readLine()) != null ) {
	        lineInFile = lineInFile.trim();
	        
	        if (lineInFile.equals("")) {
	        	lineInFile = bufferedReader.readLine(); // escape Enter key press
	        }
	        
	        StringBuilder word = new StringBuilder();
	        String binaryPart = lineInFile.substring(lineInFile.indexOf(" ") + 1);
	        
	        for (int i = 0; i < binaryPart.length(); ++i) {
	        	if (binaryPart.charAt(i) == '1') {
	        		word.append( Character.toUpperCase(lineInFile.charAt(i)) );
	        	}
	        	else {
	        		word.append( lineInFile.charAt(i) );
	        	}
	        }
	        
	        System.out.println( word );
	    }
	    
	    bufferedReader.close();
	}
}
