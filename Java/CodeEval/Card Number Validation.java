// https://www.codeeval.com/open_challenges/172/

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
		
			lineInFile = lineInFile.replaceAll(" ", "");
			int digitSum = 0;
			
			for (int i = lineInFile.length()-2; i >= 0; i -= 2) {
				int doubleOperationResult = Character.getNumericValue( lineInFile.charAt(i) ) * 2;
				if (doubleOperationResult > 9) {
					while (doubleOperationResult > 0) {
						digitSum += doubleOperationResult % 10;
						doubleOperationResult /= 10;
					}
				}
				else {
					digitSum += doubleOperationResult;
				}
			}
			
			for (int i = lineInFile.length()-1; i >= 0; i -= 2) {
				digitSum += Character.getNumericValue( lineInFile.charAt(i) );
			}
			
			if (digitSum % 10 == 0) {
				System.out.println("1");
			}
			else {
				System.out.println("0");
			}
 		}

		bufferedReader.close();
	}
}
