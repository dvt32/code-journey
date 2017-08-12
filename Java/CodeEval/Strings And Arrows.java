// https://www.codeeval.com/open_challenges/203/

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
			
			int arrowCount = 0;
			int rightPointingArrowIndex = lineInFile.indexOf(">>-->");
			int leftPointingArrowIndex = lineInFile.indexOf("<--<<");
			
			while (rightPointingArrowIndex != -1 || leftPointingArrowIndex != -1) {
				if (rightPointingArrowIndex != -1) {
					arrowCount++;
				}
				if (leftPointingArrowIndex != -1) {
					arrowCount++;
				}
				rightPointingArrowIndex = lineInFile.indexOf(">>-->", rightPointingArrowIndex+1);
				leftPointingArrowIndex = lineInFile.indexOf("<--<<", leftPointingArrowIndex+1);
			}
			
			System.out.println( arrowCount );
 		}

		bufferedReader.close();
	}
}
