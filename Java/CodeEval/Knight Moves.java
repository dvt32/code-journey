// https://www.codeeval.com/open_challenges/180/

// Helpful visualization for possible knight moves: http://ssqq.com/archive/images/chess02.jpg

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class Main {	
	static char[] possibleRowLetters = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
	static Set<String> validKnightMoves = new TreeSet<String>();
	
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
			
			char rowLetter = lineInFile.charAt(0);
			int colNumber = Character.getNumericValue( lineInFile.charAt(1) );
			int rowNumber = 0;
			
			for (int i = 0; i < possibleRowLetters.length; ++i) {
				if (rowLetter == possibleRowLetters[i]) {
					rowNumber = (i+1);
					break;
				}
			}
			
			addMoveToSetIfValid(rowNumber-2, colNumber-1); // top left
			addMoveToSetIfValid(rowNumber-1, colNumber-2); // upper left
			addMoveToSetIfValid(rowNumber+1, colNumber-2); // lower left
			addMoveToSetIfValid(rowNumber+2, colNumber-1); // bottom left
			addMoveToSetIfValid(rowNumber-2, colNumber+1); // top right
			addMoveToSetIfValid(rowNumber-1, colNumber+2); // upper right
			addMoveToSetIfValid(rowNumber+1, colNumber+2); // lower right
			addMoveToSetIfValid(rowNumber+2, colNumber+1); // bottom right
			
			System.out.println( String.join(" ", validKnightMoves) );
			
			validKnightMoves.clear();
 		}

		bufferedReader.close();
	}
	
	public static boolean isWithinBounds(int rowNumber, int colNumber) {
		return (rowNumber >= 1 && rowNumber <= 8) && (colNumber >= 1 && colNumber <= 8);
	}
	
	public static void addMoveToSetIfValid(int rowNumber, int colNumber) {
		if (isWithinBounds(rowNumber, colNumber)) {
			char rowLetter = possibleRowLetters[rowNumber-1];
			validKnightMoves.add( 
				rowLetter + String.valueOf(colNumber) 
			);
		}
	}
}
