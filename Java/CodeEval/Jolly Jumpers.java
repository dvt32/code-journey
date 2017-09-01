// https://www.codeeval.com/open_challenges/43/

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
			
			int[] numbers = Arrays.stream(lineInFile.split(" ")).mapToInt(Integer::parseInt).toArray();
			boolean isJollyJumper = true;
			
			for (int i = 1; i < numbers.length; ++i) {
				int abs = Math.abs(numbers[i] - numbers[i-1]);
				if (abs == 0 || abs > numbers.length-1) {
					isJollyJumper = false;
					break;
				}
			}
		
			if (isJollyJumper) {
				System.out.println("Jolly");
			}
			else {
				System.out.println("Not jolly");
			}
 		}

		bufferedReader.close();
	}
}
