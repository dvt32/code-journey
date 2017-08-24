// https://www.codeeval.com/open_challenges/106/

// More info: http://www.rapidtables.com/convert/number/how-number-to-roman-numerals.htm

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
				lineInFile = bufferedReader.readLine(); // Escape Enter key press
			}
			
			int x = Integer.parseInt(lineInFile);
			int[] v = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
			String[] n = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
			StringBuilder romanNumber = new StringBuilder();
			
			while (x != 0) {
				for (int i = v.length-1; i >= 0; --i) {
					if (v[i] <= x) {
						romanNumber.append( n[i] );
						x -= v[i];
						break;
					}
				}
			}
			
			System.out.println( romanNumber );
 		}

		bufferedReader.close();
	}
}  
