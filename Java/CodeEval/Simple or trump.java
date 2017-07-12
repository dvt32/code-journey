// https://www.codeeval.com/open_challenges/235/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

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
           
            
            String[] cards = lineInFile.substring(0, lineInFile.indexOf(" |")).split(" ");
            char trumpSuit = lineInFile.charAt( lineInFile.length() - 1 );
            
            Map<String, Integer> cardValues = new HashMap<String, Integer>();  
            cardValues.put("J", 11);
            cardValues.put("Q", 12);
            cardValues.put("K", 13);
            cardValues.put("A", 14);
            
            String firstCardFace = cards[0].substring(0, cards[0].length()-1);
            char firstCardSuit = cards[0].charAt( cards[0].length()-1 );
            int firstCardValue = (cardValues.containsKey(firstCardFace)) ? cardValues.get(firstCardFace) : Integer.parseInt(firstCardFace);
            
            String secondCardFace = cards[1].substring(0, cards[1].length()-1);
            char secondCardSuit = cards[1].charAt( cards[1].length()-1 );
            int secondCardValue = (cardValues.containsKey(secondCardFace)) ? cardValues.get(secondCardFace) : Integer.parseInt(secondCardFace);
            
            if ( (firstCardSuit == trumpSuit && secondCardSuit == trumpSuit) ||
            	 (firstCardSuit != trumpSuit && secondCardSuit != trumpSuit)
               ) 
            {
            	if (firstCardValue == secondCardValue) {
            		System.out.println( firstCardFace + firstCardSuit + " " + secondCardFace + secondCardSuit);
            	}
            	else if (firstCardValue > secondCardValue) {
            		System.out.println( firstCardFace + firstCardSuit );
            	}
            	else {
            		System.out.println( secondCardFace + secondCardSuit );
            	}
            }
            else if (firstCardSuit == trumpSuit) {
            	System.out.println( firstCardFace + firstCardSuit );
            }
            else if (secondCardSuit == trumpSuit) {
            	System.out.println( secondCardFace + secondCardSuit );
            }
        }
        
        bufferedReader.close();
    }
}
