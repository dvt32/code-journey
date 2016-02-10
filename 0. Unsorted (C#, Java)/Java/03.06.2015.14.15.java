// dvt32

/* 
 * 7. Сортиране на масив означава 
 * да подредим елементите му в нарастващ (намаляващ) ред. 
 * 
 * Напишете програма, която сортира масив. 
 * Да се използва алгоритъма "Selection sort".
 */


package myJava;

import java.util.Arrays;
import java.util.Scanner;

public class myClass {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int i, j, first, temp;
		int[] arr = new int[5];
		
		// Enter array elements
		for (i = 0; i < arr.length; ++i){
			System.out.print("arr["+i+"]: "); arr[i] = read.nextInt();
		}
		
		// Sort in descending order
		for (i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (j = i + 1; j < arr.length; j++)
            {
                if (arr[j] > arr[index])
                    index = j;
            }
      
            int smallerNumber = arr[index]; 
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        } System.out.println(Arrays.toString(arr));
		
		// Sort in ascending order
        for (i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (j = i + 1; j < arr.length; j++)
            {
                if (arr[j] < arr[index])
                    index = j;
            }
      
            int smallerNumber = arr[index]; 
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        } System.out.println(Arrays.toString(arr));
		
		

	}

}
