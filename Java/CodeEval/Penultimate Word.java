// https://www.codeeval.com/open_challenges/92/

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
            
            System.out.println( words[ words.length-2 ] );
        }
        
        bufferedReader.close();
    }
}
