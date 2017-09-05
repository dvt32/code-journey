// https://www.codeeval.com/open_challenges/63/

import java.io.*;

public class Main {	
	public static void main(String[] args) 
		throws IOException
	{
		//File inputFile = new File( args[0] );
		File inputFile = new File("D://input.txt");
		BufferedReader bufferedReader = new BufferedReader( new FileReader(inputFile) );
		String lineInFile;
		
		while ( (lineInFile = bufferedReader.readLine()) != null ) {
			lineInFile = lineInFile.trim();
			if (lineInFile.isEmpty()) {
				continue;
			}
		
			int separatorIndex = lineInFile.indexOf(",");
			int n = Integer.parseInt(lineInFile.substring(0, separatorIndex));
			int m = Integer.parseInt(lineInFile.substring(separatorIndex+1));
			
			int primeCount = 0;
			long currentNumber = n;
		
			while (currentNumber >= n && currentNumber <= m) {
				boolean isPrime = true;
				
				// Check if number is prime
				for (int i = 2; i <= Math.sqrt(currentNumber); ++i) {
					if (currentNumber % i == 0) {
						isPrime = false;
						break;
					}
				}
				
				if (isPrime) {
					primeCount++;
				}
				
				currentNumber++;
			}
			
			System.out.println(primeCount);
 		}

		bufferedReader.close();
	}
}
