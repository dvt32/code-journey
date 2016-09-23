// http://www.codeabbey.com/index/task_view/bubble-sort
 
import java.util.Scanner;
 
class Solution
{
   
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
        
        int arraySize = read.nextInt();
        
        int arr[] = new int[arraySize];
        for (int i = 0; i < arraySize; ++i) {
        	arr[i] = read.nextInt();
        }
        
        int numberOfPasses = 0;
        int numberOfSwaps = 0;
        boolean stillSwapping = true;
        
        while (stillSwapping) {
        	numberOfPasses++;
        	stillSwapping = false;
        	for (int i = 0; i < arr.length-1; ++i) {
    			if (arr[i] > arr[i+1]) {
    				int temp = arr[i];
    				arr[i] = arr[i+1];
    				arr[i+1] = temp;
    				numberOfSwaps++;
    				stillSwapping = true;
    			}
    		}
        }
        
        System.out.println(numberOfPasses + " " + numberOfSwaps);
         		
        // Close scanner
        read.close();
    }
}
