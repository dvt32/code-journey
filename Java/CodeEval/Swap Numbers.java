// https://www.codeeval.com/open_challenges/196/

import java.io.*;

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
			
			String[] words = lineInFile.split(" ");
			
			for (int i = 0; i < words.length; ++i) {
				char prefixDigit = words[i].charAt(0);
				char suffixDigit = words[i].charAt( words[i].length()-1 );	
				if (prefixDigit != suffixDigit) {
					words[i] = suffixDigit + words[i].substring(1, words[i].length()-1) + prefixDigit;
				}
			}
			
			System.out.println( String.join(" ", words) );
 		}

		bufferedReader.close();
	}
}
