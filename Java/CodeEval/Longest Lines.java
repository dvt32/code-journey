// https://www.codeeval.com/open_challenges/2/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {	
	public static void main(String[] args) 
		throws IOException
	{
		File inputFile = new File( args[0] );
		BufferedReader bufferedReader = new BufferedReader( new FileReader(inputFile) );
		String lineInFile;
		
		int outputLineCount = Integer.parseInt( bufferedReader.readLine() );
		List<String> wordLines = new ArrayList<String>();
		
		while ( (lineInFile = bufferedReader.readLine()) != null ) {
			lineInFile = lineInFile.trim();
			
			if (lineInFile.isEmpty()) {
				lineInFile = bufferedReader.readLine(); // Escape Enter key press
			}
			
			wordLines.add(lineInFile);
 		}

		bufferedReader.close();
		
		Collections.sort(wordLines, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});
		
		for (int i = 0; i < outputLineCount; ++i) {
			System.out.println(wordLines.get(i));
		}
	}
}
