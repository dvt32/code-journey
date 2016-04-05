/*

This problem will test your knowledge on "if-else" statements.

Given an integer N as input, check the following:

If N is odd, print "Weird".
If N is even and, in between the range of 2 and 5(inclusive), print "Not Weird".
If N is even and, in between the range of 6 and 20(inclusive), print "Weird".
If N is even and N>20, print "Not Weird".


Input Format

There is a single line of input: integer N.

Constraints

1≤N≤100

Output Format

Print "Weird" if the number is weird. Otherwise, print "Not Weird". Do not print the quotation marks.

Sample Input 1

3
Sample Output 1

Weird
Sample Input 2

24
Sample Output 2

Not Weird
 
 
*/

import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner read = new Scanner(System.in);
			
		// Enter N
		int N = read.nextInt();
		
		// Check if input is valid
		if (N < 1 || N > 100) {
			read.close();
			return;
		}
		
		// Print end result depending on conditions
		if (N % 2 == 1) {
			System.out.println("Weird");
		}
		else if (N >= 2 && N <= 5) {
			System.out.println("Not Weird");
		}
		else if (N >= 6 && N <= 20) {
			System.out.println("Weird");
		}
		else if (N > 20) {
			System.out.println("Not Weird");
		}

		// Close scanner
		read.close();
	}
}
