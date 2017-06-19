// https://www.codeeval.com/open_challenges/1/

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
            
            String[] numbers = lineInFile.split(" ");
            
            int X = Integer.parseInt( numbers[0] );
            int Y = Integer.parseInt( numbers[1] );
            int N = Integer.parseInt( numbers[2] );
            
            StringBuilder output = new StringBuilder();
            
            for (int number = 1; number <= N; ++number) {
            	if ( (number % X == 0) && (number % Y == 0) ) {
            		output.append("FB ");
            	}
            	else if (number % X == 0) {
            		output.append("F ");
            	}
            	else if (number % Y == 0) {
            		output.append("B ");
            	}
            	else {
            		output.append(number + " ");
            	}
            }
            
            System.out.println( output.toString().trim() );
         
        }
        
        bufferedReader.close();
    }
}
