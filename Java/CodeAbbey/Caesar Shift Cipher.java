// http://www.codeabbey.com/index/task_view/caesar-shift-cipher
 
import java.util.Scanner;
 
class Solution
{
    public static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   
    public static String decipher(String line, int K) {
    	StringBuilder deciphered = new StringBuilder(line);

        for (int i = 0; i < line.length()-1 /* to skip the last '.' */; ++i) {
            char currentLetter = line.charAt(i);
            if (currentLetter == ' ') {
            	continue;
            }
            int currentLetterIndex = LETTERS.indexOf(currentLetter);
            
            if ( (currentLetterIndex-K) >= 0) {
            	char decipheredLetter = LETTERS.charAt(currentLetterIndex-K);
            	deciphered.setCharAt(i, decipheredLetter);
            }
            else {
            	char decipheredLetter = LETTERS.charAt(currentLetterIndex + LETTERS.length() - K);
            	deciphered.setCharAt(i, decipheredLetter);
            }
        }
        return deciphered.toString();
    }
   
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
       
        int numberOfLines = read.nextInt();
        int K = read.nextInt();
       
        // Clear buffer
        read.nextLine();
       
        for (int i = 0; i < numberOfLines; ++i) {
            String line = read.nextLine();
            String decoded = decipher(line, K);
            System.out.print(decoded + " ");
        }
       
        // Close scanner
        read.close();
    }
}
