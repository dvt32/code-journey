// https://www.codeeval.com/open_challenges/240/

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
				lineInFile = bufferedReader.readLine(); // Escape Enter key press
			}
			
			StringJoiner mersennePrimes = new StringJoiner(", ");
			int numberOnLine = Integer.parseInt(lineInFile);
			int currentNumber = 2;
			
			while (currentNumber < numberOnLine) {
				boolean isPrime = true;
				boolean isMersennePrime = false;
				
				// Check if number is prime
				for (int i = 2; i <= Math.sqrt(currentNumber); ++i) {
					if (currentNumber % i == 0) {
						isPrime = false;
						break;
					}
				}
				
				// Check if number is MERSENNE prime
				if (isPrime) {
					int power = 0;
					int twoToPower = (int) Math.pow(2, power);
					while (twoToPower < currentNumber) {
						twoToPower = (int) Math.pow(2, power); 
						if ( currentNumber == (twoToPower-1) ) {
							isMersennePrime = true;
							break;
						}
						power++;
					}
				}
				
				if (isMersennePrime) {
					mersennePrimes.add(String.valueOf(currentNumber));
				}
				
				currentNumber++;
			}
			
			System.out.println( mersennePrimes );
 		}

		bufferedReader.close();
	}
}
