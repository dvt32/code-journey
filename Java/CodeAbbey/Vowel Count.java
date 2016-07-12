// http://www.codeabbey.com/index/task_view/vowel-count

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		final String VOWELS = "aouiey";
		
		int numberOfTestcases = read.nextInt();
		
		read.nextLine();
		
		for (int i = 0; i < numberOfTestcases; ++i) {
			String line = read.nextLine();
			int numberOfVowels = 0;
			for (int j = 0; j < line.length(); ++j) {
				if (VOWELS.indexOf(line.charAt(j)) != -1) {
					numberOfVowels++;
				}
			}
			System.out.print(numberOfVowels + " ");
		}
		
		// Close scanner
		read.close();
	}
}
