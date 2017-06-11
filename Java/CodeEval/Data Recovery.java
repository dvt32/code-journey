// https://www.codeeval.com/open_challenges/140/

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
            
            String[] dataOnLine = lineInFile.split(";");
            String[] words = dataOnLine[0].split(" ");
            String[] wordPositions = dataOnLine[1].split(" ");
            String[] sentenceWords = new String[words.length];
            boolean[] wordHasBeenAdded = new boolean[words.length];
            
            for (int i = 0; i < wordPositions.length; ++i) {
            	int currentPositionIndex = Integer.parseInt(wordPositions[i]) - 1;
            	sentenceWords[currentPositionIndex] = words[i];
            	wordHasBeenAdded[i] = true;
            }
            
            String lastWord = null;
            for (int i = 0; i < words.length; ++i) {
            	if (!wordHasBeenAdded[i]) {
            		lastWord = words[i];
            		break;
            	}
            }
            
            for (int i = 0; i < sentenceWords.length; ++i) {
            	if (sentenceWords[i] == null) {
            		sentenceWords[i] = lastWord;
            		break;
            	}
            }
            
            System.out.println( String.join(" ", sentenceWords) );
        }
        
        bufferedReader.close();
    }
}
