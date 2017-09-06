// https://www.codeeval.com/open_challenges/41/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

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
			String[] numbers = lineInFile.substring(separatorIndex+1).split(",");
			Map<String, Boolean> isDuplicateNumber = new HashMap<String, Boolean>();
			
			for (String number : numbers) {
				if (isDuplicateNumber.get(number) == null) {
					isDuplicateNumber.put(number, false);
				}
				else {
					System.out.println(number);
					break;
				}
			}
 		}

		bufferedReader.close();
	}
}
