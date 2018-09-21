// http://codeforces.com/problemset/problem/447/B

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String s = read.nextLine();
		int k = read.nextInt();
		
		int[] w = new int[26];
		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < 26; ++i) {
			w[i] = read.nextInt();
			if (w[i] > maxValue) {
				maxValue = w[i];
			}
		}
		
		Map<Character, Integer> letterValues = new HashMap<Character, Integer>();
		int indexCounter = 0;
		for (char c = 'a'; c <= 'z'; ++c) {
			letterValues.put(c, w[indexCounter]);
			indexCounter++;
		}
		
		int totalValue = 0;
		for (int i = 1; i <= s.length(); ++i) {
			char c = s.charAt(i-1);
			totalValue += i * letterValues.get(c);
		}
		
		for (int i = s.length()+1; i <= s.length()+k; ++i) {
			totalValue += i * maxValue;
		}
		
		System.out.println(totalValue);
		
		// Close scanner
		read.close();
	}

}
