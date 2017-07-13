// https://www.codeeval.com/open_challenges/62/

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
           
            int N = Integer.parseInt( lineInFile.substring(0, lineInFile.indexOf(",")) );
            int M = Integer.parseInt( lineInFile.substring(lineInFile.indexOf(",") + 1) );
            
            int mod = N - ((N/M) * M);
            
            System.out.println( mod );
        }
        
        bufferedReader.close();
    }
}
