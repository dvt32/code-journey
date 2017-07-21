// https://www.codeeval.com/open_challenges/22/

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
	        
	        int n = Integer.parseInt(lineInFile);
	        
	        int f0 = 0;
	        int f1 = 1;
	        
	        int nthFibonacciNumber = f0 + f1;
	        
	        for (int i = 2; i <= n; ++i) {
	        	nthFibonacciNumber = f0 + f1;
	        	f0 = f1;
	        	f1 = nthFibonacciNumber;
	        }
	        
	        System.out.println( nthFibonacciNumber );
	    }
	    
	    bufferedReader.close();
	}
}
