/*

Given a square matrix of size N×NN×N, calculate the absolute difference between the sums of its diagonals.

Input Format

The first line contains a single integer, N. 
The next N lines denote the matrix's rows, 
with each line containing N space-separated integers describing the columns.

Output Format

Print the absolute difference between the two sums of the matrix's diagonals as a single integer.

Sample Input

3
11 2 4
4 5 6
10 8 -12

Sample Output

15

Explanation

The primary diagonal is: 
11
      5
            -12

Sum across the primary diagonal: 11 + 5 - 12 = 4

The secondary diagonal is:
            4
      5
10

Sum across the secondary diagonal: 4 + 5 + 10 = 19 

Difference: |4 - 19| = 15

 */

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        int n = read.nextInt();
        int[][] arr = new int[n][n];
        int sumOfPrimaryDiagonal = 0;
        int sumOfSecondaryDiagonal = 0;
        int absoluteDifference = -1;
        
        // Enter values
        for (int i = 0; i < n; ++i) {
        	for (int j = 0; j < n; ++j) {
        		arr[i][j] = read.nextInt();
        	}
        }
        
        // Get sum of primary diagonal
        for (int i = 0; i < n; ++i) 
        {
        	sumOfPrimaryDiagonal += arr[i][i];
        }
        
        // Get sum of secondary diagonal
        for (int i = 0, j = n-1; i < n && j >= 0; ++i, --j) 
        {
        	sumOfSecondaryDiagonal += arr[i][j];
        }
        
        // Calculate absolute difference
        absoluteDifference = Math.abs(sumOfSecondaryDiagonal - sumOfPrimaryDiagonal);
        
        // Print end result
        System.out.println(absoluteDifference);
        
        // Close scanner
        read.close();
    }
}
