// http://codeforces.com/problemset/problem/757/A

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String s = read.nextLine();
		
		final String BULBASAUR_NAME = "Bulbasaur";
		
		Map<Character, Integer> letterFrequencies = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (BULBASAUR_NAME.indexOf(c) != -1) {
				Integer letterFrequencyCount = letterFrequencies.get(c);
				if (letterFrequencyCount == null) {
					letterFrequencies.put(c, 1);
				}
				else {
					letterFrequencies.put(c, letterFrequencyCount+1);
				}
			}
		}
		
		int bulbasaurCount = 0;
		while (true) {
			Integer capitalBcount = letterFrequencies.get('B');
			Integer uCount = letterFrequencies.get('u');
			Integer lCount = letterFrequencies.get('l');
			Integer bCount = letterFrequencies.get('b');
			Integer aCount = letterFrequencies.get('a');
			Integer sCount = letterFrequencies.get('s');
			Integer rCount = letterFrequencies.get('r');
			
			if (capitalBcount != null && capitalBcount > 0 &&
				uCount != null && uCount > 1 &&
				lCount != null && lCount > 0 &&
				bCount != null && bCount > 0 &&
				aCount != null && aCount > 1 &&
				sCount != null && sCount > 0 &&
				rCount != null && rCount > 0) 
			{
				letterFrequencies.put('B', capitalBcount-1);
				letterFrequencies.put('u', uCount-2);
				letterFrequencies.put('l', lCount-1);
				letterFrequencies.put('b', bCount-1);
				letterFrequencies.put('a', aCount-2);
				letterFrequencies.put('s', sCount-1);
				letterFrequencies.put('r', rCount-1);
				
				bulbasaurCount++;
			}
			else {
				break;
			}
		}
		
		System.out.println(bulbasaurCount);
		
		// Close scanner
		read.close();
	}
	
}
