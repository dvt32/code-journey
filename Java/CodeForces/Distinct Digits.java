// https://codeforces.com/problemset/problem/1228/A

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int l = read.nextInt();
		int r = read.nextInt();
		
		int answer = -1;
		for (int number = l; number <= r; ++number) {
			String numberAsString = String.valueOf(number);
			int numberLength = numberAsString.length();
			Set<Character> uniqueDigits = new HashSet<>();
			for (int i = 0; i < numberLength; ++i) {
				char currentDigit = numberAsString.charAt(i);
				uniqueDigits.add(currentDigit);
			}
			if (uniqueDigits.size() == numberLength) {
				answer = number;
				break;
			}
		}
		
		System.out.println(answer);
	
		// Close scanner
		read.close();
	}

}
