// https://www.codeeval.com/open_challenges/104/

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
			
			String[] digitWords = lineInFile.split(";");
			StringBuilder digits = new StringBuilder();
			
			for (String digitWord : digitWords) {
				switch (digitWord) {
				case "zero": digits.append(0); break;
				case "one": digits.append(1); break;
				case "two": digits.append(2); break;
				case "three": digits.append(3); break;
				case "four": digits.append(4); break;
				case "five": digits.append(5); break;
				case "six": digits.append(6); break;
				case "seven": digits.append(7); break;
				case "eight": digits.append(8); break;
				case "nine": digits.append(9); break;
				default: break;
				}
			}
			
			System.out.println( digits );
 		}

		bufferedReader.close();
	}
}
