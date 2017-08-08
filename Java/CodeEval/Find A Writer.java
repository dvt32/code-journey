// https://www.codeeval.com/open_challenges/97/

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
			
			int separatorIndex = lineInFile.indexOf("|");
			String encodedWriterInfo = lineInFile.substring(0, separatorIndex);
			String[] keyNumbers = lineInFile.substring(separatorIndex+2).split(" ");
			StringBuilder decodedWriterInfo = new StringBuilder();
			
			for (String keyNumber : keyNumbers) {
				decodedWriterInfo.append( encodedWriterInfo.charAt(Integer.parseInt(keyNumber)-1) );
			}
			
			System.out.println( decodedWriterInfo );
 		}

		bufferedReader.close();
	}
}
