// https://www.codeeval.com/open_challenges/74/

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
				continue;
			}

			int total = Integer.parseInt(lineInFile);
			int coinCount = 0;
			
			while (total >= 5) {
				total -= 5;
				coinCount++;
			}
			while (total >= 3) {
				total -= 3;
				coinCount++;
			}
			while (total >= 1) {
				total -= 1;
				coinCount++;
			}
			
			System.out.println( coinCount );
 		}

		bufferedReader.close();
	}
}
