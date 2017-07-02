// https://www.codeeval.com/open_challenges/152/

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
            
            int ageOfPerson = Integer.parseInt(lineInFile);
            
            if (ageOfPerson >= 0 && ageOfPerson <= 2) {
            	System.out.println( "Still in Mama's arms" );
            }
            else if (ageOfPerson == 3 || ageOfPerson == 4) {
            	System.out.println( "Preschool Maniac" );
            }
            else if (ageOfPerson >= 5 && ageOfPerson <= 11) {
            	System.out.println( "Elementary school" );
            }
            else if (ageOfPerson >= 12 && ageOfPerson <= 14) {
            	System.out.println( "Middle school" );
            }
            else if (ageOfPerson >= 15 && ageOfPerson <= 18) {
            	System.out.println( "High school" );
            }
            else if (ageOfPerson >= 19 && ageOfPerson <= 22) {
            	System.out.println( "College" );
            }
            else if (ageOfPerson >= 23 && ageOfPerson <= 65) {
            	System.out.println( "Working for the man" );
            }
            else if (ageOfPerson >= 66 && ageOfPerson <= 100) {
            	System.out.println( "The Golden Years" );
            }
            else {
            	System.out.println( "This program is for humans" );
            }
        }
        
        bufferedReader.close();
    }
}
