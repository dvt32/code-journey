// http://codeforces.com/problemset/problem/437/A

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static class Choice {
		private char letter;
		private String description;
		
		public Choice(char letter, String description) {
			this.letter = letter;
			this.description = description;
		}
		
		public char getLetter() {
			return letter;
		}
		public void setLetter(char letter) {
			this.letter = letter;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		List<Choice> choices = new ArrayList<Choice>();
		for (char c = 'A'; c <= 'D'; ++c) {
			choices.add(new Choice(c, read.nextLine().substring(2)));
		}
		
		char finalAnswer = ' ';
		int numberOfGreatChoices = 0;
		
		for (int i = 0; i < choices.size(); ++i) {
			Choice currentChoice = choices.get(i);
			int currentChoiceDescriptionLength = currentChoice.getDescription().length();
			
			boolean lengthTwiceLonger = true;
			boolean lengthTwiceShorter = true;
			
			for (int j = 0; j < choices.size(); ++j) {
				if (i != j) {
					if (currentChoiceDescriptionLength < choices.get(j).getDescription().length() * 2) {
						lengthTwiceLonger = false;
					}
					if (currentChoiceDescriptionLength > choices.get(j).getDescription().length() / 2) {
						lengthTwiceShorter = false;
					}
				}
			}
			
			if (lengthTwiceLonger || lengthTwiceShorter) {
				numberOfGreatChoices++;
				if (numberOfGreatChoices > 1) {
					break;
				}
				finalAnswer = currentChoice.getLetter();
			}
		}
		
		if (numberOfGreatChoices == 1) {
			System.out.println(finalAnswer);
		}
		else {
			System.out.println("C");
		}
		
		// Close scanner
		read.close();
	}
}
