// https://www.codeeval.com/open_challenges/112/

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
	        
	        String[] dataOnLine = lineInFile.split(" : ");
	        String[] numbers = dataOnLine[0].split(" ");
	        String[] swapPositions = dataOnLine[1].split(", ");
	        
	        for (int i = 0; i < swapPositions.length; ++i) {
	        	int originalIndex = Integer.parseInt(
	        		swapPositions[i].substring(
	        			0, 
	        			swapPositions[i].indexOf("-")
	        		)
	        	);
	        	int targetIndex = Integer.parseInt(
	        		swapPositions[i].substring( swapPositions[i].indexOf("-")+1 )
	        	);
	        	
	        	String temp = numbers[targetIndex];
	        	numbers[targetIndex] = numbers[originalIndex];
	        	numbers[originalIndex] = temp;
	        }
	        
	        System.out.println( String.join(" ", numbers));
	    }
	    
	    bufferedReader.close();
	}
}
