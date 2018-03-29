// http://codeforces.com/problemset/problem/118/B

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		// First half (and center row)
		for (int i = 0, limit = 0, spaceCount = n*2; i < n+1; ++i) {
			char[] spaces_arr = new char[spaceCount];
			Arrays.fill(spaces_arr, ' ');
			String spaces = new String(spaces_arr);
			StringJoiner line = new StringJoiner(" ");
			
			for (int j = 0; j <= limit; ++j) {
				line.add(String.valueOf(j));
			}
			for (int j = limit-1; j >= 0; --j) {
				line.add(String.valueOf(j));
			}
			
			limit++;
			spaceCount -= 2;
			
			System.out.println(spaces + line);
		}
		
		// Second half
		for (int i = 0, limit = n-1, spaceCount = 2; i < n; ++i) {
			char[] spaces_arr = new char[spaceCount];
			Arrays.fill(spaces_arr, ' ');
			String spaces = new String(spaces_arr);
			StringJoiner line = new StringJoiner(" ");
			
			for (int j = 0; j <= limit; ++j) {
				line.add(String.valueOf(j));
			}
			for (int j = limit-1; j >= 0; --j) {
				line.add(String.valueOf(j));
			}
			
			limit--;
			spaceCount += 2;
			
			System.out.println(spaces + line);
		}
		
		// Close scanner
		read.close();
	}
	
}
