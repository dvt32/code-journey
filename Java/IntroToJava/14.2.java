// Напишете програма, която открива колко пъти даден подниз се съдържа в текст. 

import java.util.Scanner;

public class Solution {
	
	public static int getNumberOfSubstringInstances(String substring, String text) {
		int numberOfInstances = 0;
		substring = substring.toLowerCase();
		text = text.toLowerCase();
		
		int instanceIndex = 0;
		while (true) {
			instanceIndex = text.indexOf(substring, instanceIndex+1);
			if (instanceIndex == -1) {
				break;
			}
			numberOfInstances++;
		}
		
		return numberOfInstances;
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String substringToFind = read.next();
		String text = "We are living in a yellow submarine. We don't have anything else. Inside the submarine is very tight. So we are drinking all the day. We will move out of it in 5 days.";
		
		int numberOfSubstringInstances = getNumberOfSubstringInstances(substringToFind, text);
		
		// Print end result
		System.out.println(numberOfSubstringInstances);
		
		// Close scanner
		read.close();
	}
}
