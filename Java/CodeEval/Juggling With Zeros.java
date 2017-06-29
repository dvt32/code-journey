// https://www.codeeval.com/open_challenges/149/

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
            
            String[] numberData = lineInFile.split(" ");
            StringBuilder binaryNumber = new StringBuilder();
            String flag = numberData[0];
            
            for (int i = 1; i < numberData.length; ++i) {
            	if (i % 2 == 0) {
            		flag = numberData[i];
            	}
            	else if ( flag.equals("0") ) {
        			for (int j = 0; j < numberData[i].length(); ++j) {
        				binaryNumber.append("0");
        			}
            	}
            	else {
            		for (int j = 0; j < numberData[i].length(); ++j) {
        				binaryNumber.append("1");
        			}
            	}
            }
            
            System.out.println( Long.parseLong(binaryNumber.toString(), 2) );   
        }
        
        bufferedReader.close();
    }
}
