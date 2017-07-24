// https://www.codeeval.com/open_challenges/156/

import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException {
            File inputFile = new File( args[0] )'
		
	    BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
	    String lineInFile;  
	
	    while ( (lineInFile = bufferedReader.readLine()) != null ) {
	        lineInFile = lineInFile.trim();
	        
	        if (lineInFile.equals("")) {
	        	lineInFile = bufferedReader.readLine(); // escape Enter key press
	        }
	        
	        StringBuilder rollerCoasterText = new StringBuilder();
	        int letterCount = 0;
	        
	        for (int i = 0; i < lineInFile.length(); ++i) {
	        	char currentChar = lineInFile.charAt(i);
	        	if ( Character.isLetter(currentChar) ) {
	        		if (letterCount % 2 == 0) {
	        			rollerCoasterText.append( Character.toUpperCase(currentChar) );
	        		}
	        		else {
	        			rollerCoasterText.append( Character.toLowerCase(currentChar) );
	        		}
	        		letterCount++;
	        	}
	        	else {
	        		rollerCoasterText.append(currentChar);
	        	}
	        }
	        
	        System.out.println( rollerCoasterText );
	    }
	    
	    bufferedReader.close();
	}
}
