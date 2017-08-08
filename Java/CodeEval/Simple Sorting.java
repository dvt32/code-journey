// https://www.codeeval.com/open_challenges/91/

import java.io.*;
import java.util.Arrays;
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
			
			double[] numbers = Arrays.stream(lineInFile.split(" ")).mapToDouble(Double::parseDouble).toArray();
			Arrays.sort(numbers);
			
			StringJoiner output = new StringJoiner(" ");
			
			for (double number : numbers) {
				output.add( String.format("%.3f", number) );
			}
			
			System.out.println(output);
 		}

		bufferedReader.close();
	}
}
