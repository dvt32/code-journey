// https://codeforces.com/problemset/problem/78/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String lineOne = read.nextLine();
		String lineTwo = read.nextLine();
		String lineThree = read.nextLine();
		
		final String VOWELS = "aeiou";
		
		int lineOneVowelCount = 0;
		for (int i = 0; i < lineOne.length(); ++i) {
			char c = lineOne.charAt(i);
			if (VOWELS.contains(String.valueOf(c))) {
				lineOneVowelCount++;
			}
		}
		
		int lineTwoVowelCount = 0;
		for (int i = 0; i < lineTwo.length(); ++i) {
			char c = lineTwo.charAt(i);
			if (VOWELS.contains(String.valueOf(c))) {
				lineTwoVowelCount++;
			}
		}
		
		int lineThreeVowelCount = 0;
		for (int i = 0; i < lineThree.length(); ++i) {
			char c = lineThree.charAt(i);
			if (VOWELS.contains(String.valueOf(c))) {
				lineThreeVowelCount++;
			}
		}
		
		if (lineOneVowelCount == 5 && lineTwoVowelCount == 7 && lineThreeVowelCount == 5) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}

		// Close scanner
		read.close();
	}

}
