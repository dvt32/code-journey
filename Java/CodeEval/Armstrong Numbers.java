// https://www.codeeval.com/open_challenges/82/

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
	        
	        int number = Integer.parseInt(lineInFile);
	        
	        if (isArmstrongNumber(number)) {
	        	System.out.println("True");
	        }
	        else {
	        	System.out.println("False");
	        }
	    }
	    
	    bufferedReader.close();
	}
	
	public static boolean isArmstrongNumber(int number) {
		String numberToString = String.valueOf(number);
		int power = numberToString.length();
		int newNumber = 0;
		
		for (int i = 0 ; i < numberToString.length(); ++i) {
			newNumber += (int) Math.pow( Character.getNumericValue(numberToString.charAt(i)), power );
		}
		
		return (number == newNumber);
	}
}
