// http://codeforces.com/problemset/problem/723/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int[] x = new int[3];
		for (int i = 0; i < x.length; ++i) {
			x[i] = read.nextInt();
		}
		
		Arrays.sort(x);
		
		System.out.println( x[2] - x[0] );
		
		// Close scanner
		read.close();
	}
	
}
