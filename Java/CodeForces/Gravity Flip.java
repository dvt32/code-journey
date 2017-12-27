// http://codeforces.com/problemset/problem/405/A

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
	
		int n = read.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; ++i) {
			arr[i] = read.nextInt();
		}
		
		Arrays.sort(arr);
		
		StringJoiner output = new StringJoiner(" ");
		for (int el : arr) {
			output.add(String.valueOf(el));
		}
		
		System.out.println(output);
		
		// Close scanner
		read.close();
	}
	
}
