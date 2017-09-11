// https://www.codeeval.com/open_challenges/71/

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
		
			int separatorIndex = lineInFile.indexOf(";");
			
			String[] numbers = lineInFile.substring(0, separatorIndex).split(",");
			int k = Integer.parseInt( lineInFile.substring(separatorIndex+1) );
			StringJoiner output = new StringJoiner(",");
			
			int i;
			for (i = (k-1); i < numbers.length; i += k) {
				for (int j = i; j > (i-k); --j) {
					output.add(numbers[j]);
				}
			}
			
			i -= (k-1);
			while (i < numbers.length) {
				output.add(numbers[i]);
				i++;
			}
			
			System.out.println( output );
 		}

		bufferedReader.close();
	}
}
