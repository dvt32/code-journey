// http://www.codeabbey.com/index/task_view/pythagorean-theorem
 
import java.util.Scanner;
 
class Solution
{
	
    public static void main(String[] args)
    {
    	Scanner read = new Scanner(System.in);
        
    	int numberOfTriangles = read.nextInt();
    	
    	for (int i = 0; i < numberOfTriangles; ++i) {
    		int a = read.nextInt();
    		int b = read.nextInt();
    		int c = read.nextInt(); // always largest value (as stated by problem description)
    		if (c == Math.sqrt(a*a + b*b)) {
    			System.out.print("R" + " ");
    		}
    		else if (c < Math.sqrt(a*a + b*b)) {
    			System.out.print("A" + " ");
    		}
    		else {
    			System.out.print("O" + " ");
    		}
    	}
        
        // Close scanner
        read.close();
    }
}
