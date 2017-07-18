// https://www.codeeval.com/open_challenges/174/

import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException {
	    File inputFile = new File(args[0]);
	    
	    BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
	    String lineInFile;  
	    int slangIndexCounter = 0;
	
	    while ( (lineInFile = bufferedReader.readLine()) != null ) {
	        lineInFile = lineInFile.trim();
	        
	        if (lineInFile.equals("")) {
	        	lineInFile = bufferedReader.readLine(); // escape Enter key press
	        }
	        
	        String[] slangPhrases = new String[] {
	    		", yeah!",
	    		", this is crazy, I tell ya.",
	    		", can U believe this?",
	    		", eh?",
	    		", aw yea.",
	    		", yo.",
	    		"? No way!",
	    		". Awesome!"
	        };
	        
	        
	        StringBuilder modifiedLine = new StringBuilder();
	        int endPunctuationMarkCounter = 0;
	        
	        for (int i = 0; i < lineInFile.length(); ++i) {
	        	char currentChar = lineInFile.charAt(i);
	        	boolean isEndPunctuationMark = isEndPunctuationMark(currentChar);
	        	if (isEndPunctuationMark) {
	        		endPunctuationMarkCounter++;
	        	}
	        	
	        	if (isEndPunctuationMark && endPunctuationMarkCounter % 2 == 0) {
	    			if (slangIndexCounter == slangPhrases.length) {
	        			slangIndexCounter = 0;	
	        		}
	        		modifiedLine.append( slangPhrases[slangIndexCounter] );
	        		slangIndexCounter++;
	        	}
	        	else {
	        		modifiedLine.append(currentChar);
	        	}
	        }
	        
	        System.out.println( modifiedLine );
	    }
	    
	    bufferedReader.close();
	}

	public static boolean isEndPunctuationMark(char c) {
		return (c == '.' || c == '!' || c == '?');
	}
}
