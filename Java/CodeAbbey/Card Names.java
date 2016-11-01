// http://www.codeabbey.com/index/task_view/card-names

import java.util.Scanner;
 
class Solution
{
	
    public static void main(String[] args)
    {
    	Scanner read = new Scanner(System.in);
        
    	int numberOfCards = read.nextInt();
    	
    	for (int i = 0; i < numberOfCards; ++i) {
    		int cardValue = read.nextInt();
    		String[] suits = { "Clubs", "Spades", "Diamonds", "Hearts" };
        	String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        	int suitValue = cardValue / 13;
        	int rankValue = cardValue % 13;
        	String suitOfCard = suits[suitValue];
        	String rankOfCard = ranks[rankValue];
        	System.out.print(rankOfCard + "-of-" + suitOfCard + " ");
    	}
    	
        // Close scanner
        read.close();
    }
}
