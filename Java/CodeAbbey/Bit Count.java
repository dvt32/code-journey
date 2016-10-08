// http://www.codeabbey.com/index/task_view/bit-count
 
import java.util.Scanner;
 
class Solution
{
	
    public static void main(String[] args)
    {
    	Scanner read = new Scanner(System.in);
        
    	int numberOfTestcases = read.nextInt();
    	
    	for (int i = 0; i < numberOfTestcases; ++i) {
    		// Sorry about that...
        	System.out.print(Integer.toBinaryString(read.nextInt()).replaceAll("0", "").length() + " ");
    	}
    	
        // Close scanner
        read.close();
    }
}
