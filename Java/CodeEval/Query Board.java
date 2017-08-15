// https://www.codeeval.com/open_challenges/87/

import java.io.*;

public class Main {	
	public static void main(String[] args) 
		throws IOException 
	{
		File inputFile = new File( args[0] );
		BufferedReader bufferedReader = new BufferedReader( new FileReader(inputFile) );
		String lineInFile;
		
		int[][] board = new int[256][256];

		while ( (lineInFile = bufferedReader.readLine()) != null ) {
			lineInFile = lineInFile.trim();
			
			if (lineInFile.isEmpty()) {
				lineInFile = bufferedReader.readLine(); // Escape Enter key press
			}
			
			int separatorIndex = lineInFile.indexOf(" ");
			String queryType = lineInFile.substring(0, separatorIndex);
			String numbers = lineInFile.substring(separatorIndex+1);
			separatorIndex = numbers.indexOf(" ");
			
			if ( queryType.equals("SetRow") ) {
				int i = Integer.parseInt( numbers.substring(0, separatorIndex) );
				int x = Integer.parseInt( numbers.substring(separatorIndex+1) );
				for (int j = 0; j < board[i].length; ++j) {
					board[i][j] = x;
				}
			}
			else if ( queryType.equals("SetCol") ) {
				int j = Integer.parseInt( numbers.substring(0, separatorIndex) );
				int x = Integer.parseInt( numbers.substring(separatorIndex+1) );
				for (int i = 0; i < board.length; ++i) {
					board[i][j] = x;
				}
			}
			else if ( queryType.equals("QueryRow") ) {
				int i = Integer.parseInt( numbers );
				int sum = 0;
				for (int j = 0; j < board[i].length; ++j) {
					sum += board[i][j];
				}
				System.out.println( sum );
			}
			else if ( queryType.equals("QueryCol") ) {
				int j = Integer.parseInt( numbers );
				int sum = 0;
				for (int i = 0; i < board.length; ++i) {
					sum += board[i][j];
				}
				System.out.println( sum );
			}
 		}

		bufferedReader.close();
	}
}
