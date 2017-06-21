// https://www.codeeval.com/open_challenges/31/

import java.io.*;
import java.util.*;

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
            StringJoiner output = new StringJoiner(" ");
            
            for (int i = ( words.length-1 ); i >= 0; --i) {
            	output.add(words[i]);
            }
            
            System.out.println(output);
        }
        
        bufferedReader.close();
    }
}
