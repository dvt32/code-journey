// https://www.codeeval.com/open_challenges/237/

import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException {
            File inputFile = new File( args[0] );
		
	    BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
	    String lineInFile;  
	
	    while ( (lineInFile = bufferedReader.readLine()) != null ) {
	        lineInFile = lineInFile.trim();
	        
	        if (lineInFile.equals("")) {
	        	lineInFile = bufferedReader.readLine(); // escape Enter key press
	        }
	        
	        String[] dataOnLine = lineInFile.split(" \\| ");
	        String[] hexNumbers = dataOnLine[0].split(" ");
	        String[] binNumbers = dataOnLine[1].split(" ");
	        
	        int hexSum = 0;
	        int binSum = 0;
	        
	        for (String hexNumber : hexNumbers) {
	        	hexSum += Integer.parseInt(hexNumber, 16);
	        }
	        
	        for (String binNumber : binNumbers) {
	        	binSum += Integer.parseInt(binNumber, 2);
	        }
	        
	        if (binSum >= hexSum) {
	        	System.out.println("True");
	        }
	        else {
	        	System.out.println("False");
	        }
	    }
	    
	    bufferedReader.close();
	}
}
