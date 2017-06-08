// https://www.codeeval.com/open_challenges/19/

// Accepted as "Partially", needs optimization

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
            
            String[] dataOnCurrentLine = lineInFile.split(",");
            
            int number = Integer.parseInt(dataOnCurrentLine[0]);
            int firstBitIndex= Integer.parseInt(dataOnCurrentLine[1]) - 1;
            int secondBitIndex = Integer.parseInt(dataOnCurrentLine[2]) - 1;
            
            
            String binaryNumber = Integer.toBinaryString(number);
            boolean bitsAreEqual = 
            	( binaryNumber.charAt(firstBitIndex) == binaryNumber.charAt(secondBitIndex) );
            
            System.out.println(bitsAreEqual);
        }
        
        bufferedReader.close();
    }
}
