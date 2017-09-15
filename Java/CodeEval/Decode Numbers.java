// https://www.codeeval.com/open_challenges/73/

// Based on this solution: https://github.com/mpillar/codeeval/blob/master/1-moderate/decode-numbers/main.py

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

			System.out.println( getNumberOfWaysToDecode(lineInFile) );
 		}

		bufferedReader.close();
	}
	
	public static int getNumberOfWaysToDecode(String msg) {
		if ( msg.length() == 1 || msg.length() == 0 ) {
			return 1;
		}
		
		int numberOfWaysToDecode = 0;
		int numberOfChars = 1;
		
		while (true) {
			String chars = "";
			if (numberOfChars > msg.length()) {
				chars = msg;
			}
			else {
				chars = msg.substring(0, numberOfChars);
			}
			
			if ( chars.length() != numberOfChars ) {
				break;
			}
			if ( Integer.parseInt(chars) > 26 ) {
				break;
			}
			
			numberOfWaysToDecode += getNumberOfWaysToDecode( msg.substring(numberOfChars) );
			numberOfChars++;
		}
		
		return numberOfWaysToDecode;
	}
}
