// http://codeforces.com/problemset/problem/535/A

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		Map<Integer, String> numerals = new HashMap<Integer, String>();
		
		numerals.put(0, "zero");
		numerals.put(1, "one");
		numerals.put(2, "two");
		numerals.put(3, "three");
		numerals.put(4, "four");
		numerals.put(5, "five");
		numerals.put(6, "six");
		numerals.put(7, "seven");
		numerals.put(8, "eight");
		numerals.put(9, "nine");
		numerals.put(10, "ten");
		numerals.put(11, "eleven");
		numerals.put(12, "twelve");
		numerals.put(13, "thirteen");
		numerals.put(14, "fourteen");
		numerals.put(15, "fifteen");
		numerals.put(16, "sixteen");
		numerals.put(17, "seventeen");
		numerals.put(18, "eighteen");
		numerals.put(19, "nineteen");
		numerals.put(20, "twenty");
		numerals.put(30, "thirty");
		numerals.put(40, "forty");
		numerals.put(50, "fifty");
		numerals.put(60, "sixty");
		numerals.put(70, "seventy");
		numerals.put(80, "eighty");
		numerals.put(90, "ninety");
		
		int s = read.nextInt();
		
		if ( numerals.get(s) != null ) {
			System.out.println( numerals.get(s) );
		}
		else {
			System.out.println( 
				numerals.get( (s/10) * 10 ) + 
				"-" + 
				numerals.get( s % 10) 
			);
		}
		
		// Close scanner
		read.close();
	}
	
}
