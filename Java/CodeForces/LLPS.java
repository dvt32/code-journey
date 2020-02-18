// https://codeforces.com/problemset/problem/202/A

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {

	static SortedSet<String> palindromeSubsequences = new TreeSet<>();
	
	public static boolean isPalindrome(String str) {
		return new StringBuilder(str).reverse().toString().equals(str);
	}
	
	// https://www.geeksforgeeks.org/print-all-subsequences-of-a-string-using-arraylist
	public static void addAllPalindromeSubsequences(String sub, String ans) {
		if (sub.length() == 0) {
			if (isPalindrome(ans)) {
				palindromeSubsequences.add(ans);
			}
			return;
		}
		char ch = sub.charAt(0);
		String ros = sub.substring(1);
		addAllPalindromeSubsequences(ros, ans);
		addAllPalindromeSubsequences(ros, ans+ch);
	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		String s = read.nextLine();

		addAllPalindromeSubsequences(s, "");
		
		System.out.println( palindromeSubsequences.last() );

		// Close scanner
		read.close();
	}

}
