// http://www.codeabbey.com/index/task_view/double-dice-roll
 
import java.util.Scanner;
 
class Solution
{
	
    public static void main(String[] args)
    {
    	Scanner read = new Scanner(System.in);
        
    	int numberOfTestcases = read.nextInt();
    	final int N = 6;
    	
    	for (int i = 0; i < numberOfTestcases; ++i) {
    		int firstNumber = read.nextInt();
    		int secondNumber = read.nextInt();
    		int firstMod = firstNumber % N + 1;
    		int secondMod = secondNumber % N + 1;
    		int result = firstMod + secondMod;
    		System.out.print(result + " ");
    	}
    	
        // Close scanner
        read.close();
    }
}
