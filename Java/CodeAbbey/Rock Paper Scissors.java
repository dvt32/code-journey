// http://www.codeabbey.com/index/task_view/rock-paper-scissors

import java.util.Scanner;
 
class Solution
{
	
    public static void main(String[] args)
    {
    	Scanner read = new Scanner(System.in);
        
    	int numberOfMatchesPlayed = read.nextInt();
    	
    	// Consume newline character
    	read.nextLine();
    	
    	for (int i = 0; i < numberOfMatchesPlayed; ++i) {
    		int playerOneWinCount = 0;
    		int playerTwoWinCount = 0;
    		String[] matchOfRPS = read.nextLine().split(" ");
    		for (int j = 0; j < matchOfRPS.length; ++j) {
    			switch (matchOfRPS[j]) {
    			case "RR":
    			case "PP":
    			case "SS":
    				// Draw
    				break;
    			case "RP":
    				playerTwoWinCount++;
    				break;
    			case "RS":
    				playerOneWinCount++;
    				break;
    			case "PR":
    				playerOneWinCount++;
    				break;
    			case "PS":
    				playerTwoWinCount++;
    				break;
    			case "SR":
    				playerTwoWinCount++;
    				break;
    			case "SP":
    				playerOneWinCount++;
    				break;
    			default: 
    				break;
    			}
    		}
    		int winnerOfGame = (playerOneWinCount > playerTwoWinCount) ? 1 : 2;
    		System.out.print(winnerOfGame + " ");
    	}
    	
        // Close scanner
        read.close();
    }
}
