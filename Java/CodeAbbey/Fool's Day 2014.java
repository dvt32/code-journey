// http://www.codeabbey.com/index/task_view/fools-day-2014
 
import java.util.Scanner;
 
class Solution
{
   
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
       
        int numberOfTestcases = read.nextInt();
        
        // Clear buffer
        read.nextLine();
       
        for (int i = 0; i < numberOfTestcases; ++i) {
        	int total = 0;
        	String line = read.nextLine();
        	String[] numbersOnLine = line.split(" ");
        	int[] numbers = new int[numbersOnLine.length];
        	for (int j = 0; j < numbersOnLine.length; ++j) {
        		numbers[j] = Integer.parseInt(numbersOnLine[j]);
        		total += numbers[j] * numbers[j];
        	}
        	System.out.print(total + " ");
        }
       
        // Close scanner
        read.close();
    }
}
