// https://www.codeeval.com/open_challenges/202/

import java.io.*;
import java.util.StringJoiner;

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
			int maxWordLength = 0;
			String maxWord = "";
			for (String word : words) {
				if (word.length() > maxWordLength) {
					maxWordLength = word.length();
					maxWord = word;
				}
			}
			
			StringJoiner wordSteps = new StringJoiner(" ");
			for (int asterixCount = 0, i = 0; 
				 asterixCount < maxWordLength; 
				 ++asterixCount, ++i) 
			{
				StringBuilder wordStep = new StringBuilder();
				for (int j = 0; j < asterixCount; ++j) {
					wordStep.append('*');
				}
				wordStep.append( maxWord.charAt(i) );
				wordSteps.add(wordStep);
			}
			
			System.out.println( wordSteps );
 		}

		bufferedReader.close();
	}
}
