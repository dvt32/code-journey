// https://www.codeeval.com/open_challenges/45/

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
		
			long number = Long.parseLong(lineInFile);
			long reversedNumber = Long.parseLong( new StringBuilder(String.valueOf(number)).reverse().toString() );
			boolean isPalindrome = ( reversedNumber == number );
			int iterationCount = 0;
			
			while (!isPalindrome) {
				iterationCount++;
				number = number + reversedNumber;
				reversedNumber = Long.parseLong( new StringBuilder(String.valueOf(number)).reverse().toString() );
				isPalindrome = ( reversedNumber == number );
			}
			
			System.out.println(iterationCount + " " + number);
 		}

		bufferedReader.close();
	}
}
