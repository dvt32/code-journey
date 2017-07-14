// https://www.codeeval.com/browse/93/

import java.io.*;
import java.util.StringJoiner;
import java.util.stream.Stream;

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
            
            StringJoiner capitalizedWords = new StringJoiner(" ");
           
            Stream
            .of( lineInFile.split(" ") )
            .forEach( 
            	word -> 
            	capitalizedWords.add( Character.toUpperCase(word.charAt(0)) + word.substring(1) ) 
            );
            
            System.out.println( capitalizedWords );
        }
        
        bufferedReader.close();
    }
}
