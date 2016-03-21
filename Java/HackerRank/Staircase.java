/*

Your teacher has given you the task of drawing a staircase structure. 
Being an expert programmer, you decided to make a program to draw it for you instead.
Given the required height, can you print a staircase as shown in the example?

Input 

You are given an integer N depicting the height of the staircase.

Output 

Print a staircase of height N that consists of # symbols and spaces. 
For example for N=6, here's a staircase of that height:

     #
    ##
   ###
  ####
 #####
######


Note: The last line has 0 spaces before it.

 */

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        int n = read.nextInt();
        int numberOfSpaces = n;
        int numberOfSymbols = 1;
        
        while (numberOfSpaces > 0)
        {
	        for (int i = 1; i < numberOfSpaces; ++i) 
	        {
	        	System.out.print(" ");
	        }
	        for (int j = 1; j <= numberOfSymbols; ++j)
	        {
	        	System.out.print("#");
	        }
	        System.out.println();
	        
	        numberOfSymbols++;
	        numberOfSpaces--;
        }
        
        // Close scanner
        read.close();
    }
}
