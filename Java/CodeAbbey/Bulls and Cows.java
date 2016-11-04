// http://www.codeabbey.com/index/task_view/combinations-counting

import java.util.Scanner;
 
class Solution
{
	
    public static void main(String[] args)
    {
    	Scanner read = new Scanner(System.in);
        
    	String secretValue = read.next();
    	int numberOfGuesses = read.nextInt();
    	
    	for (int i = 0; i < numberOfGuesses; ++i) {
    		String guess = read.next();
    		int numberOfCorrectlyPlacedDigits = 0;
    		int numberOfIncorrectlyPlacedDigits = 0;
    		for (int j = 0; j < secretValue.length(); ++j) {
    			if (guess.charAt(j) == secretValue.charAt(j)) {
    				numberOfCorrectlyPlacedDigits++;
    			}
    			else if (secretValue.contains(Character.toString(guess.charAt(j)))) {
    				numberOfIncorrectlyPlacedDigits++;
    			}
    		}
    		System.out.print(numberOfCorrectlyPlacedDigits + "-" + numberOfIncorrectlyPlacedDigits + " ");
    	}
    	
        // Close scanner
        read.close();
    }
}
