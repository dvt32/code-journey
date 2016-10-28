// http://www.codeabbey.com/index/task_view/linear-congruential-generator
 
import java.util.Scanner;
 
class Solution
{
	
    public static void main(String[] args)
    {
    	Scanner read = new Scanner(System.in);
        
    	int numberOfTestcases = read.nextInt();
    	
    	for (int i = 0; i < numberOfTestcases; ++i) {
    		int A = read.nextInt();
    		int C = read.nextInt();
    		int M = read.nextInt();
    		int X0 = read.nextInt();
    		int N = read.nextInt();
    		
    		int Xnext = X0;
    		for (int j = 0; j < N; ++j) {
    			Xnext = (A * Xnext + C) % M;
    		}
    		System.out.print(Xnext + " ");
    	}
    	
        // Close scanner
        read.close();
    }
}
