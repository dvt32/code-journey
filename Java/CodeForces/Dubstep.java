// http://codeforces.com/problemset/problem/208/A

import java.util.Scanner;
import java.util.StringJoiner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String line = read.nextLine();
		String[] words = line.replaceAll("WUB", " ").trim().split(" ");
		
		StringJoiner output = new StringJoiner(" ");
		for (String word : words) {
			if ( !word.isEmpty() ) {
				output.add( word.trim() );
			}
			
		}
		
		System.out.println(output);
		
		// Close scanner
		read.close();
	}
	
}
