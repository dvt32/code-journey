// https://www.codeeval.com/open_challenges/211/

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
            
            String[] dataOnLine = lineInFile.split(" \\| "); // alternatively pass Pattern.quote(" | ") to split()
            String[] wineNames = dataOnLine[0].split(" ");
            String letters = dataOnLine[1];
            
            StringBuilder output = new StringBuilder();
            
            for (String wineName : wineNames) {
            	boolean nameIsValid = true;
            	for (int i = 0; i < letters.length(); ++i) {
                	if ( !wineName.contains( Character.toString( letters.charAt(i) ) ) ) {
                		nameIsValid = false;
                		break;
                	}
                }
            	if (nameIsValid) {
            		output.append(wineName + " ");
            	}
            }
            
            if (output.length() == 0) {
            	System.out.println("False");
            }
            else {
            	output.deleteCharAt(output.length()-1);
            	System.out.println(output);
            }
        }
        
        bufferedReader.close();
    }
}
