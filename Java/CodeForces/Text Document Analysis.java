// http://codeforces.com/problemset/problem/723/B

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		read.nextLine();
		
		String line = read.nextLine();
		
		StringBuilder lineWithoutParantheses = new StringBuilder();
		
		int numberOfWordsInParantheses = 0;
		int i = 0;
		while (i < line.length()) {
			if (line.charAt(i) == '(') {
				lineWithoutParantheses.append("_");
				i++;
				StringBuilder paranthesesWords = new StringBuilder();
				while (line.charAt(i) != ')') {
					paranthesesWords.append(line.charAt(i));
					i++;
				}
				
				String[] wordsInParantheses = paranthesesWords.toString().split("_");
				for (String word : wordsInParantheses) {
					if (!word.isEmpty()) {
						numberOfWordsInParantheses++;
					}
				}
			}
			else {
				lineWithoutParantheses.append(line.charAt(i));
			}
			i++;
		}
		
		int maxWordWithoutParanthesesLength = 0;
		String[] wordsWithoutParantheses = lineWithoutParantheses.toString().split("_");
		
		for (String word : wordsWithoutParantheses) {
			if (!word.isEmpty() && word.length() > maxWordWithoutParanthesesLength) {
				maxWordWithoutParanthesesLength = word.length();
			}
		}
		
		System.out.println(maxWordWithoutParanthesesLength + " " + numberOfWordsInParantheses);
		
		// Close scanner
		read.close();
	}
}
