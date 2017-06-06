// https://www.codeeval.com/open_challenges/205/

// Status is 'Partially', needs to be optimized

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
            
            StringBuilder currentWord = new StringBuilder();
            StringBuilder output = new StringBuilder();
            
            for (int i = 0; i < lineInFile.length(); ++i) {
            	char currentChar = lineInFile.charAt(i);
            	if ( Character.isLetter(currentChar) ){
            		currentWord.append( Character.toLowerCase(currentChar) );
            	}
            	else if (currentWord.length() > 0) {
            		output.append(currentWord + " ");
            		currentWord.setLength(0);
            	}
            }
           
            output.deleteCharAt(output.length()-1); // delete space after last word
            
            System.out.println(output);
        }
        
        bufferedReader.close();
    }
}
