// https://www.codeeval.com/open_challenges/225/

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
			
			int separatorIndex = lineInFile.indexOf(" | ");
			
			String developerString = lineInFile.substring(0, separatorIndex);
			String designString = lineInFile.substring(separatorIndex+3);
			
			int bugCount = 0;
			for (int i = 0; i < developerString.length(); ++i) {
				if ( developerString.charAt(i) != designString.charAt(i) ) {
					bugCount++;
				}
			}
			
			switch (bugCount) {
			case 0: System.out.println("Done"); break;
			case 1: case 2: System.out.println("Low"); break;
			case 3: case 4: System.out.println("Medium"); break;
			case 5: case 6: System.out.println("High"); break;
			default: System.out.println("Critical"); break;
			}
 		}
		
		bufferedReader.close();
	}
}
