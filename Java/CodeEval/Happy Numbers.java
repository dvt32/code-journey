// https://www.codeeval.com/open_challenges/39/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
	        
	        if (isHappyNumber(number)) {
	        	System.out.println("1");
	        }
	        else {
	        	System.out.println("0");
	        }
	    }
	    
	    bufferedReader.close();
	}
	
	public static boolean isHappyNumber(int number) {
		List<Integer> numbers = new ArrayList<Integer>();
		
		while (number != 1 && !numbers.contains(number)) {
			numbers.add(number);
			
			String numberToString = String.valueOf(number);
			int newNumber = 0;
			
			for (int i = 0 ; i < numberToString.length(); ++i) {
				int currentDigit = Character.getNumericValue( numberToString.charAt(i) );
				newNumber += (int) Math.pow( currentDigit, 2 );
			}
			
			number = newNumber;
		}
		
		return (number == 1);
	}
}
