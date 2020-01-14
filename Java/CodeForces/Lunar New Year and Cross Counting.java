// https://codeforces.com/problemset/problem/1106/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = Integer.parseInt( read.nextLine() );

		String[] matrix = new String[n];
		for (int i = 0; i < n; ++i) {
			matrix[i] = read.nextLine();
		}
		
		int k = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (matrix[i].charAt(j) == 'X' && 
					i-1 >= 0 && j-1 >= 0 && i+1 < n && j+1 < n &&
					matrix[i].charAt(j) == matrix[i-1].charAt(j-1) &&
					matrix[i].charAt(j) == matrix[i-1].charAt(j+1) &&
					matrix[i].charAt(j) == matrix[i+1].charAt(j-1) &&
					matrix[i].charAt(j) == matrix[i+1].charAt(j+1)) 
				{
					k++;
				}
			}
		}
		
		System.out.println(k);
		
		// Close scanner
		read.close();
	}

}
