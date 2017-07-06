// https://www.codeeval.com/open_challenges/222/

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

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
            
            String[] dataOnLine = lineInFile.split(" \\| ");          
            int totalNumberOfTurns = Integer.parseInt( dataOnLine[1] );
            int turnCount = 0;
          
            List<String> names = new ArrayList<String>( Arrays.asList(dataOnLine[0].split(" ")) );
            while (names.size() != 1) {
            	Iterator<String> it = names.iterator();
            	while (it.hasNext()) {
            		it.next();
            		turnCount++;
            		if (turnCount == totalNumberOfTurns) {
            			it.remove();
            			turnCount = 0;
            			break;
            		}	
            	}
            }
            
            System.out.println( names.get(0) );
        }
        
        bufferedReader.close();
    }
}
