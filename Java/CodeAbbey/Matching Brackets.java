// http://www.codeabbey.com/index/task_view/matching-brackets
 
import java.util.Scanner;
import java.util.Stack;
 
class Solution
{
	
    public static void main(String[] args)
    {
    	Scanner read = new Scanner(System.in);
        
    	int numberOfTestcases = read.nextInt();
    
    	// Consume last newline character
    	read.nextLine();
    	
    	for (int i = 0; i < numberOfTestcases; ++i) {
    		String line = read.nextLine();
    		boolean bracketsMatch = true;
    		Stack<Character> bracketsStack = new Stack<Character>();
    		for (int j = 0; j < line.length(); ++j) 
    		{
    			char currentChar = line.charAt(j);
    			if (currentChar == '(' ||
    				currentChar == '[' ||
    				currentChar == '{' ||
    				currentChar == '<') 
    			{	
    				bracketsStack.push(currentChar);
    			}
    			else if (currentChar == ')' || 
    					 currentChar == ']' || 
    					 currentChar == '}' || 
    					 currentChar == '>') 
    			{
    				if (bracketsStack.isEmpty()) {
    					bracketsMatch = false;
    					break;
    				}
    				
    				char topOfStack = bracketsStack.peek();
    				
    				if ((currentChar == ')' && topOfStack == '(') ||
    					(currentChar == ']' && topOfStack == '[') ||	
    					(currentChar == '}' && topOfStack == '{') ||
    					(currentChar == '>' && topOfStack == '<'))
    				{
    					bracketsStack.pop();
    				}
    				else {
    					bracketsMatch = false;
    					break;
    				}
    			}
    		}	
    		if (bracketsMatch && bracketsStack.isEmpty()) {
    			System.out.print("1" + " ");
    		}
    		else {
    			System.out.print("0" + " ");
    		}
    	}
    	
        // Close scanner
        read.close();
    }
}
