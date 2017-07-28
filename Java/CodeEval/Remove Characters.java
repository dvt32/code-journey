// https://www.codeeval.com/open_challenges/13/

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
			
			String lettersToRemove = lineInFile.substring(lineInFile.indexOf(",") + 2);
			lineInFile = lineInFile.replaceAll("[" + lettersToRemove + ",]", "");
			
			System.out.println(lineInFile);
		}
		
		bufferedReader.close();
	}
}
