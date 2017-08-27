// https://www.codeeval.com/open_challenges/37/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {	

	public static void main(String[] args) 
		throws IOException
	{
		File inputFile = new File( args[0] );
		BufferedReader bufferedReader = new BufferedReader( new FileReader(inputFile) );
		String lineInFile;
		
		while ( (lineInFile = bufferedReader.readLine()) != null ) {
			lineInFile = lineInFile.trim();
			
			if (lineInFile.isEmpty()) {
				lineInFile = bufferedReader.readLine(); // Escape Enter key press
			}
			
			Map<Character, Boolean> letterFound = new HashMap<Character, Boolean>();
			for (char c = 'a'; c <= 'z'; ++c) {
				letterFound.put(c, false);
			}
			
			lineInFile = lineInFile.toLowerCase();
			for (int i = 0; i < lineInFile.length(); ++i) {
				char currentChar = lineInFile.charAt(i);
				boolean isValidChar = (currentChar >= 'a' && currentChar <= 'z');
				if (isValidChar) {
					letterFound.put(currentChar, true);
				}
			}
			
			StringBuilder missingLetters = new StringBuilder();
			for (Character letter : letterFound.keySet()) {
				if (letterFound.get(letter) == false) {
					missingLetters.append(letter);
				}
			}
			
			if (missingLetters.length() == 0) {
				System.out.println("NULL");
			}
			else {
				System.out.println(missingLetters);
			}	
 		}

		bufferedReader.close();
	}
}  
