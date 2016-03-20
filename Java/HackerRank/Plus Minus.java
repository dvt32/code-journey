/*

Given an array of integers,
calculate which fraction of the elements are 
positive, negative, and zeroes, respectively. 

Print the decimal value of each fraction.

Input Format

The first line, N, is the size of the array. 
The second line contains N space-separated integers describing the array of numbers (A1,A2,A3,⋯,ANA1,A2,A3,⋯,AN).

Output Format

Print each value on its own line with the fraction of positive numbers first, negative numbers second, and zeroes third.

Sample Input

6
-4 3 -9 0 4 1         

Sample Output

0.500000
0.333333
0.166667

Explanation

There are 3 positive numbers, 2 negative numbers, and 1 zero in the array. 
The fraction of the positive numbers, negative numbers and zeroes are 3/6=0.50000036=0.500000, 2/6=0.33333326=0.333333 and 1/6=0.16666716=0.166667, respectively.

Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, though answers with absolute error of up to 10−410−4 are acceptable.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int arr[] = new int[n];
        
        int positiveNumberCount = 0;
        int negativeNumberCount = 0;
        int zeroNumberCount = 0;
        
        for (int i=0; i < n; ++i)
        {
            arr[i] = in.nextInt();
            if (arr[i] > 0) 
            {
            	positiveNumberCount++;
            }
            else if (arr[i] < 0) 
            {
            	negativeNumberCount++;
            }
            else 
            {
            	zeroNumberCount++;
            }
        }
        
        // Print end result
        System.out.printf("%.6f %n", (double) positiveNumberCount/n);
        System.out.printf("%.6f %n", (double) negativeNumberCount/n);
        System.out.printf("%.6f %n", (double) zeroNumberCount/n);
     
        in.close();
    }
}
