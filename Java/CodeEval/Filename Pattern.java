// https://www.codeeval.com/open_challenges/169/

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
			
			int separatorIndex = lineInFile.indexOf(" ");
			String encryptedRegex = lineInFile.substring(0, separatorIndex);
			String[] fileNames = lineInFile.substring(separatorIndex+1).split(" ");
			
			StringBuilder decryptedRegex = new StringBuilder();
			for (int i = 0; i < encryptedRegex.length(); ++i) {
				char currentChar = encryptedRegex.charAt(i);
				switch (currentChar) {
				case '*': decryptedRegex.append(".*"); break;
				case '?': decryptedRegex.append("."); break;
				case '.': decryptedRegex.append("[.]"); break;
				default: decryptedRegex.append(currentChar); break;
				}
			}
			
			StringJoiner matchingFileNames = new StringJoiner(" ");
			for (String fileName : fileNames) {
				if ( fileName.matches(decryptedRegex.toString()) ) {
					matchingFileNames.add(fileName);
				}
			}
			
			System.out.println(
				matchingFileNames.length() > 0
				? matchingFileNames
				: "-"
			);
 		}

		bufferedReader.close();
	}
}  
