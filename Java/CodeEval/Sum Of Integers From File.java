// https://www.codeeval.com/open_challenges/225/

import java.io.*;

public class Main {	
	
	public static void main(String[] args) 
		throws IOException 
	{
		File inputFile = new File( args[0] );
		BufferedReader bufferedReader = new BufferedReader( new FileReader(inputFile) );
		String lineInFile;
		
		int sum = 0;
		
		while ( (lineInFile = bufferedReader.readLine()) != null ) {
			lineInFile = lineInFile.trim();
			
			if (lineInFile.isEmpty()) {
				lineInFile = bufferedReader.readLine(); // Escape Enter key press
			}
			
			sum += Integer.parseInt(lineInFile);
			
 		}
		
		System.out.println(sum);
		
		bufferedReader.close();
	}
}
