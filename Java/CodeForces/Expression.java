// http://codeforces.com/problemset/problem/479/A

import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int a = Integer.parseInt( read.nextLine() );
		int b = Integer.parseInt( read.nextLine() );
		int c = Integer.parseInt( read.nextLine() );
		
		TreeSet<Integer> possibleAnswers = new TreeSet<Integer>();
		possibleAnswers.add( a+b+c );
		possibleAnswers.add( a*b*c );
		possibleAnswers.add( a*b+c );
		possibleAnswers.add( a+b*c );
		possibleAnswers.add( a*(b+c) );
		possibleAnswers.add( (a+b)*c );
		
		System.out.println( possibleAnswers.last() );
		
		// Close scanner
		read.close();
	}
	
}
