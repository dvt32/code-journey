// https://codeforces.com/problemset/problem/837/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = Integer.parseInt( read.nextLine() );
		String s = read.nextLine();
		
		String[] words = s.split(" ");
		int textVolume = 0;
		for (String word : words) {
			int wordVolume = 0;
			for (int i = 0; i < word.length(); ++i) {
				char c = word.charAt(i);
				if (Character.isUpperCase(c)) {
					wordVolume++;
				}
			}
			textVolume = Math.max(wordVolume, textVolume);
		}
		
		System.out.println(textVolume);
		
		// Close scanner
		read.close();
	}

}
