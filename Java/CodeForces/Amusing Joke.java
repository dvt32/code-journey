// http://codeforces.com/problemset/problem/734/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		char[] names = (read.nextLine() + read.nextLine()).toCharArray();
		char[] pile = read.nextLine().toCharArray();
		
		Arrays.sort(names);
		Arrays.sort(pile);
		
		if ( String.valueOf(names).equals(String.valueOf(pile)) ) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
			
		// Close scanner
		read.close();
	}
}
