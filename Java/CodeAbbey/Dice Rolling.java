// http://www.codeabbey.com/index/task_view/dice-rolling
 
import java.util.Scanner;
 
class Solution
{
   
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
       
        int numberOfValues = read.nextInt();
        
        for (int i = 0; i < numberOfValues; ++i) {
        	double number = read.nextDouble();
        	number = Math.floor(number * 6) + 1;
        	System.out.print((int)number + " ");
        }
       
        // Close scanner
        read.close();
    }
}
