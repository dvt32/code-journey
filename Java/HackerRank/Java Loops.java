/*
 *  In this problem you will test your knowledge of Java loops. 
 *  Given three integers a, b, and n, output the following series:

a +(2^0)*b, a +(2^0)*b + (2^1)*b, ...... , a + (2^0)*b +(2^1)*b + ... +(2^(n−1))*b

Input Format

The first line will contain the number of testcases t. 
Each of the next t lines will have three integers, a, b, and n.

Constraints:

0≤t≤500
0≤a,b≤50
1≤n≤15

Output Format

Print the answer to each test case in separate lines.

Sample Input

2
0 2 10
5 3 5

Sample Output

2 6 14 30 62 126 254 510 1022 2046
8 14 26 50 98

Explanation

In the first case:

1st term=0+1*2=2
2nd term=0+1*2+2*2=6
3rd term=0+1*2+2*2+4*2=14
and so on.

 */

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int t, a, b, n;
		int sequence;
		
		// Enter 't'
		t = read.nextInt();
		if (t < 0 || t > 500) 
		{
			read.close();
			return;
		}
		
		// Enter values for 'a', 'b', 'n'
		for (int i = 0; i < t; ++i)
		{	
			a = read.nextInt();
			if (a < 0 || a > 50) 
			{
				read.close();
				return;
			}
			
			b = read.nextInt();
			if (b < 0 || b > 50) 
			{
				read.close();
				return;
			}
			
			n = read.nextInt();
			if (n < 1 || n > 15) 
			{
				read.close();
				return;
			}
			
			sequence = a;
			
			// Calculate and print sequence
			for (int j = 0; j < n; ++j)
			{
				
				sequence += ((int)Math.pow(2, j)) * b;
				System.out.print(sequence + " ");
			}	
			
			System.out.println();
		}
		
		// Close scanner
		read.close();
	}
}
