// https://www.codeeval.com/open_challenges/208/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
		
			String[] rows = lineInFile.split(" \\| ");
			List<String[]> table = new ArrayList<String[]>();
			for (String row : rows) {
				String[] rowElements = row.split(" ");
				table.add(rowElements);
			}
			
			StringJoiner output = new StringJoiner(" ");
			for (int i = 0; i < table.get(0).length; ++i) {
				int maxNumberInColumn = Integer.MIN_VALUE;
				for (int j = 0; j < table.size(); ++j) {
					int numberInColumn = Integer.parseInt(table.get(j)[i]);
					if (numberInColumn > maxNumberInColumn) {
						maxNumberInColumn = numberInColumn;
					}
				}
				output.add(String.valueOf(maxNumberInColumn));
			}
			
			System.out.println(output);
 		}

		bufferedReader.close();
	}
}
