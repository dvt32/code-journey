// https://www.codeeval.com/open_challenges/99/

import java.io.*;
import java.util.Arrays;

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
			
			int pointSeparatorIndex = lineInFile.indexOf(")");
			int[] firstPointCoordinates = Arrays.stream( lineInFile.substring(1, pointSeparatorIndex).split(", ") ).mapToInt(Integer::parseInt).toArray();
			int[] secondPointCoordinates = Arrays.stream( lineInFile.substring(pointSeparatorIndex+3, lineInFile.length()-1).split(", ") ).mapToInt(Integer::parseInt).toArray();
			
			int x1 = firstPointCoordinates[0];
			int y1 = firstPointCoordinates[1];
			int x2 = secondPointCoordinates[0];
			int y2 = secondPointCoordinates[1];
			
			int distanceBetweenPoints = (int) Math.sqrt( Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2) );
			
			System.out.println( distanceBetweenPoints );
 		}

		bufferedReader.close();
	}
}  
