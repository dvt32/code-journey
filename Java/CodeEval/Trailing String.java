// https://www.codeeval.com/open_challenges/32/

import java.io.*;

public class Main {	
    public static void main(String[] args) throws IOException {
        File inputFile = new File( args[0] );
        BufferedReader bufferedReader = new BufferedReader( new FileReader(inputFile) );
        String lineInFile;

        while ( (lineInFile = bufferedReader.readLine()) != null ) {
            lineInFile = lineInFile.trim();

            if (lineInFile.isEmpty()) {
                lineInFile = bufferedReader.readLine(); // Escape Enter key press
            }

            String a = lineInFile.substring( 0, lineInFile.indexOf(",") );
            String b = lineInFile.substring( lineInFile.indexOf(",")+1 );

            if ( a.endsWith(b) ) {
                System.out.println("1");
            }
            else {
                System.out.println("0");
            }
        }

        bufferedReader.close();
    }
}
