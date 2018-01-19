// http://codeforces.com/problemset/problem/499/B

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		
		// Clear buffer
		read.nextLine();

		Map<String, String> language = new HashMap<String, String>();
		for (int i = 0; i < m; ++i) {
			String[] line = read.nextLine().split(" ");
			String a = line[0];
			String b = line[1];
			language.put(a, b);
		}
		
		String[] lectureText = read.nextLine().split(" ");
		StringJoiner output = new StringJoiner(" ");
		for (String word : lectureText) {
			String alternativeWord = language.get(word);
			if (word.length() <= alternativeWord.length()) {
				output.add(word);
			}
			else {
				output.add(alternativeWord);
			}
		}
		
		System.out.println(output);
		
		// Close scanner
		read.close();
	}
	
}
