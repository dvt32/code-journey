// http://codeforces.com/problemset/problem/977/B

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();

		// Clear buffer
		read.nextLine();
		
		String line = read.nextLine();
		
		int maxFrequency = 0;
		String maxFrequencySubstring = "";
		
		Map<String, Integer> substringFrequencies = new HashMap<String, Integer>();
		for (int i = 0; i <= line.length()-2; ++i) {
			String substring = line.substring(i, i+2);
			
			Integer substringFrequency = substringFrequencies.get(substring);
			if (substringFrequency == null) {
				substringFrequency = 0;
			}
			substringFrequencies.put(substring, substringFrequency+1);
			
			if (substringFrequency+1 > maxFrequency) {
				maxFrequency = substringFrequency+1;
				maxFrequencySubstring = substring;
			}
		}
		
		System.out.println(maxFrequencySubstring);
		
		// Close scanner
		read.close();
	}
}
