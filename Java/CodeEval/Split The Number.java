// https://www.codeeval.com/open_challenges/131/

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
	        
	        String[] dataOnLine = lineInFile.split(" ");
	       
	        // Replace first part of expression with digits (before operator)
	        String digits = dataOnLine[0];
	        int digitIndexCounter = 0;
	        char[] expression = dataOnLine[1].toCharArray();
	        int i = 0;
	        while ( Character.isLetter(expression[i]) ) {
	        	expression[i] = digits.charAt(digitIndexCounter);
	        	digitIndexCounter++;
	        	i++;
	        }
	        
	        // Find out type of operator
	        char operator = expression[i];
	        int operatorIndex = i;
	        
	        // Replace second part of expression with digits (after operator)
	        i++;
	        while (i < expression.length) {
	        	expression[i] = digits.charAt(digitIndexCounter);
	        	digitIndexCounter++;
	        	i++;
	        }
	        
	        // Find out the two operands' values
	        int firstOperand = Integer.parseInt( String.valueOf(expression).substring(0, operatorIndex) );
	        int secondOperand = Integer.parseInt ( String.valueOf(expression).substring(operatorIndex+1) );
	        
	        // Evaluate expression, based on the type of operator used
	        switch (operator) {
	        case '+':
	        	System.out.println( firstOperand + secondOperand );
	        	break;
	        case '-':
	        	System.out.println( firstOperand - secondOperand );
	        default:
	        	break;
	        }
	    }
	    
	    bufferedReader.close();
	}
}
