// http://www.codeabbey.com/index/task_view/sort-with-indexes
 
import java.util.Scanner;
 
class Solution
{
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
        
        int arraySize = read.nextInt();
        
        int arr[] = new int[arraySize];
        int arrIndices[] = new int[arraySize];
        
        // Enter array elements and set indices
        for (int i = 0; i < arraySize; ++i) {
        	arr[i] = read.nextInt();
        	// Indices start from 1 according to the problem description, hence why "i+1", instead of "i"
        	arrIndices[i] = i+1; 
        }
        
        // Sort array and indices
        boolean stillSwapping = true;
        while (stillSwapping) {
        	stillSwapping = false;
        	for (int i = 0; i < arr.length - 1; ++i) {
        		if (arr[i] > arr[i+1]) {
        			int temp_value = arr[i];
        			int temp_index = arrIndices[i];
        			
        			arr[i] = arr[i+1];
        			arrIndices[i] = arrIndices[i+1];
        			
        			arr[i+1] = temp_value;
        			arrIndices[i+1] = temp_index;
        			
        			stillSwapping = true;
        		}
        	}
        }
               
        // Print indices
        for (int i = 0; i < arrIndices.length; ++i) {
        	System.out.print(arrIndices[i] + " ");
        }
       
        // Close scanner
        read.close();
    }
}
