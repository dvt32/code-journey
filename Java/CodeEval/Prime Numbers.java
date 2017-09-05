// https://www.codeeval.com/open_challenges/46/

import java.io.*;
import java.util.StringJoiner;

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
		
			StringJoiner primes = new StringJoiner(",");
			long n = Long.parseLong(lineInFile);
			long currentNumber = 2;
			
			while (currentNumber < n) {
				boolean isPrime = true;
				
				// Check if number is prime
				for (long i = 2; i <= Math.sqrt(currentNumber); ++i) {
					if (currentNumber % i == 0) {
						isPrime = false;
						break;
					}
				}
				
				if (isPrime) {
					primes.add(String.valueOf(currentNumber));
				}
				
				currentNumber++;
			}
			
			System.out.println(primes);
 		}

		bufferedReader.close();
	}
}
