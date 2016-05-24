// https://www.hackerrank.com/challenges/java-anagrams

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Solution {
	
	static boolean areAnagrams(String a, String b) {
		// If the strings have a different length or they're empty, they're not anagrams
		if (a.length() != b.length() || a == null || b == null) { return false; }
		// If both strings have the same value, they're anagrams
		if (a.equals(b)) { return true; }
		
		// Remove case sensitivity
		a = a.toLowerCase();
		b = b.toLowerCase();
		
		// Declare 2 maps to store occurrences of each character for both strings
		Map<Character, Integer> a_numberOfOccurrences = new HashMap<Character, Integer>();
		Map<Character, Integer> b_numberOfOccurrences = new HashMap<Character, Integer>();
		int lengthOfStrings = a.length(); // or b.length();
		
		// Iterate through strings and get number of occurrences for each character
		for (int i = 0; i < lengthOfStrings; ++i) {
			// Count number of occurrences of character from 'a'
			char a_char = a.charAt(i);
			if (a_numberOfOccurrences.containsKey(a_char)) {
				a_numberOfOccurrences.put(a_char, a_numberOfOccurrences.get(a_char) + 1);
			}
			else {
				a_numberOfOccurrences.put(a_char, 1);
			}
			// Count number of occurrences of character from 'b'
			char b_char = b.charAt(i);
			if (b_numberOfOccurrences.containsKey(b_char)) {
				b_numberOfOccurrences.put(b_char, b_numberOfOccurrences.get(b_char) + 1);
			}
			else {
				b_numberOfOccurrences.put(b_char, 1);
			}
		}
		
		// Check if the strings are anagrams
		if (a_numberOfOccurrences.equals(b_numberOfOccurrences)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		// Enter 2 strings & validate input
		String a = read.next();
		if (a.length() > 50 || a.length() == 0) {
			read.close();
			return;
		}
		String b = read.next();
		if (b.length() > 50 || b.length() == 0) {
			read.close();
			return;
		}
		
		// Check if they're anagrams
		boolean areAnagrams = areAnagrams(a, b);
		
		// Print end result
		if (areAnagrams) {
			System.out.println("Anagrams");
		}
		else {
			System.out.println("Not Anagrams");
		}
			
		// Close scanner
		read.close();
	}
}
