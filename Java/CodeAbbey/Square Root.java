// http://www.codeabbey.com/index/task_view/square-root
 
import java.util.Scanner;
 
class Solution
{
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
        
        int numberOfTestcases = read.nextInt();
        
        for (int i = 0; i < numberOfTestcases; ++i) {
        	int X = read.nextInt();
        	int N = read.nextInt();
        	double r = 1.0;
        	for (int j = 0; j < N; ++j) {
        		r = (r + (X / r)) / 2;
        	}
        	System.out.print(r + " ");
        }
        
        // Close scanner
        read.close();
    }
}
