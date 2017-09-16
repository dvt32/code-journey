// https://www.codeeval.com/open_challenges/153/

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

			int separatorIndex = lineInFile.indexOf(" ");
			int n = Integer.parseInt( lineInFile.substring(0, separatorIndex) );
			int m = Integer.parseInt( lineInFile.substring(separatorIndex+1) );
			
			boolean[] isLocked = new boolean[n];
			for (int i = 0; i < (m-1) /* skip last iteration */; ++i) {
				// first segment: lock every 2nd door
				for (int j = 1; j < n; j += 2) {
					isLocked[j] = true;
				}
				
				// second segment: change state of every 3rd door
				for (int j = 2; j < n; j += 3) {
					isLocked[j] = !isLocked[j];
				}
			}
			
			// Last iteration
			isLocked[ isLocked.length-1 ] = !isLocked[ isLocked.length-1 ];
			
			int unlockedDoorCount = 0;
			for (boolean doorIsLocked : isLocked) {
				if ( !doorIsLocked ) {
					unlockedDoorCount++;
				}
			}
			
			System.out.println( unlockedDoorCount );
 		}

		bufferedReader.close();
	}
}
