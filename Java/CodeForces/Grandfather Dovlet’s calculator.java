// https://codeforces.com/problemset/problem/620/B

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int a = read.nextInt();
		int b = read.nextInt();
		
		Map<Character, Integer> segmentsInDigit = new HashMap<>();
		segmentsInDigit.put('0', 6);
		segmentsInDigit.put('1', 2);
		segmentsInDigit.put('2', 5);
		segmentsInDigit.put('3', 5);
		segmentsInDigit.put('4', 4);
		segmentsInDigit.put('5', 5);
		segmentsInDigit.put('6', 6);
		segmentsInDigit.put('7', 3);
		segmentsInDigit.put('8', 7);
		segmentsInDigit.put('9', 6);
		
		int sum = 0;
		for (int i = a; i <= b; ++i) {
			char[] digits = String.valueOf(i).toCharArray();
			for (Character digit : digits) {
				sum += segmentsInDigit.get(digit);
			}
		}
		
		System.out.println(sum);
		
		// Close scanner
		read.close();
	}

}
