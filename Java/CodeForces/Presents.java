// http://codeforces.com/problemset/problem/136/A

import java.util.Scanner;
import java.util.StringJoiner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int[] p = new int[n];
		int[] answers = new int[n];
		
		for (int i = 0; i < n; ++i) {
			p[i] = read.nextInt();
			answers[ p[i]-1 ] = i+1;
		}
		
		StringJoiner output = new StringJoiner(" ");
		for (Integer answer : answers) {
			output.add(String.valueOf(answer));
		}
		
		System.out.println(output);
		
		// Close scanner
		read.close();
	}
	
}
