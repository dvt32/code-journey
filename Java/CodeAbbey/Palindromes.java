// http://www.codeabbey.com/index/task_view/palindromes
 
import java.util.Scanner;
 
class Solution
{
	
	static boolean isPalindrome(String input) {
		boolean isPalindrome = true;
		
		for (int i = 0, j = input.length()-1; i < input.length() / 2; ++i, --j) {
			if (input.charAt(i) != input.charAt(j)) {
				isPalindrome = false;
				return isPalindrome;
			}
		}
		
		return isPalindrome;
	}
	
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
        
        int numberOfPhrases = read.nextInt();
        
        // Clear buffer
        read.nextLine();
        
        for (int i = 0; i < numberOfPhrases; ++i) {
        	String phrase = read.nextLine();
        	phrase = phrase.toUpperCase();
        	phrase = phrase.replaceAll("\\W+", ""); // remove all non-word characters, including whitespaces
        	
        	// Determine if the String is a palindrome
        	if (isPalindrome(phrase)) {
        		System.out.print("Y" + " ");
        	}
        	else {
        		System.out.print("N" + " ");
        	}
        }
       
        // Close scanner
        read.close();
    }
}
