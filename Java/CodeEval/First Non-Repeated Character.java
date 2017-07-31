// https://www.codeeval.com/open_challenges/12/

import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		File inputFile = new File( args[0] );
		BufferedReader bufferedReader = new BufferedReader( new FileReader(inputFile) );
		String lineInFile;
		
		while ( (lineInFile = bufferedReader.readLine()) != null ) {
			lineInFile = lineInFile.trim();
			
			if (lineInFile.isEmpty()) {
				lineInFile = bufferedReader.readLine(); // Escape Enter key press
			}
			
			for (int i = 0; i < lineInFile.length(); ++i) {
				String currentCharAsString = String.valueOf(lineInFile.charAt(i));
				String substringBeforeCurrentChar = (i > 0) ? lineInFile.substring(0, i) : "";
				String substringAfterCurrentChar = lineInFile.substring(i+1);
				
				if ( !substringBeforeCurrentChar.contains(currentCharAsString) &&
                                      !substringAfterCurrentChar.contains(currentCharAsString)
				   )
				{
					System.out.println(currentCharAsString);
					break;
				}
			}
 		}
		
		bufferedReader.close();
	}
}
