// https://www.codeeval.com/open_challenges/102/

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
            
            int idSum = 0;
            
            String itemsStartIndicator = "\"items\": [";
            
            // Cool readability, bro :(
            
            String[] items = lineInFile.substring(
            	lineInFile.indexOf(itemsStartIndicator) + itemsStartIndicator.length()+1,
            	lineInFile.lastIndexOf("]")
            ).replaceAll("\\}", "").replaceAll(", null", "").split(", \\{");
            
            for (String item : items) {
            	if (item.contains("label")) {
            		idSum += Integer.parseInt(
            			item.substring(
            				item.indexOf(" ") + 1,
            				item.indexOf(",")
            			)
            		);
            	}
            } 
            
            System.out.println(idSum);
        }
        
        bufferedReader.close();
    }
}
