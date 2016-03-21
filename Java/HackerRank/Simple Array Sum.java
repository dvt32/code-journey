/*

You are given an array of integers of size N. Can you find the sum of the elements in the array?

Input 

The first line of input consists of an integer N. 
The next line contains N space-separated integers representing the array elements. 

Sample:

66
11 22 33 44 1010 1111

Output 

Output a single value equal to the sum of the elements in the array. 

For the sample above you would just print 3131 since 1+2+3+4+10+11=311+2+3+4+10+11=31.

 */

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        int n = read.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        
        // Enter array elements and calculate sum
        for (int i = 0; i < arr.length; ++i) {
        	arr[i] = read.nextInt();
        	sum += arr[i];
        }
        
        // Print sum
        System.out.println(sum);
        
        // Close scanner
        read.close();
    }
}
