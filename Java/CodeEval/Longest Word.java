// https://www.codeeval.com/open_challenges/111/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File inputFile = new File(args[0]);
	
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
        String lineInFile;

        while ( (lineInFile = bufferedReader.readLine()) != null ) {
            lineInFile = lineInFile.trim();
            
            if (lineInFile.equals("")) {
            	lineInFile = bufferedReader.readLine(); // escape Enter key press
            }
            
            String[] words = lineInFile.split(" ");
            int maxWordLength = words[0].length();
            String longestWord = words[0];
            
            for (int i = 1; i < words.length; ++i) {
            	if (words[i].length() > maxWordLength) {
            		maxWordLength = words[i].length();
            		longestWord = words[i];
            	}
            }
            
            System.out.println( longestWord );
        }
        
        bufferedReader.close();
    }
}
