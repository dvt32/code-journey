// http://www.codeabbey.com/index/task_view/arithmetic-progression
 
import java.util.Scanner;
 
class Solution
{
   
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
       
        int numberOfTestcases = read.nextInt();
        
        for (int i = 0; i < numberOfTestcases; ++i) {
        	int A = read.nextInt();
        	int B = read.nextInt();
        	int N = read.nextInt();
        	int sumOfSequence = A;
        	for (int j = 1; j < N; ++j) {
        		sumOfSequence += A + j*B;
        	}
        	System.out.print(sumOfSequence + " ");
        }
        		
        // Close scanner
        read.close();
    }
}
