// http://www.codeabbey.com/index/task_view/array-counters
 
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
 
class Solution
{
   
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
       
	    int M = read.nextInt();
	    int N = read.nextInt();
	    
	    List<Integer> listOfNumbers = new ArrayList<Integer>();
	    
	    for (int i = 0; i < M; ++i) {
	    	int number = read.nextInt();
	    	listOfNumbers.add(number);
	    }
	    
	    for (int i = 1; i <= N; ++i) {
	    	int currentNumberOccurences = Collections.frequency(listOfNumbers, i);
	    	System.out.print(currentNumberOccurences + " ");
	    }
        		
        // Close scanner
        read.close();
    }
}
