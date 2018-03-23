// http://codeforces.com/problemset/problem/731/A

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String exhibitName = read.nextLine();
		
		Map<Character, Integer> letterPositions = new HashMap<Character, Integer>();
		int letterPosition = 1;
		for (char c = 'a'; c <= 'z'; ++c) {
			letterPositions.put(c, letterPosition);
			letterPosition++;
		}
		
		int minRotationCount = 0;
		char currentLetter = 'a';
		for (int i = 0; i < exhibitName.length(); ++i) {
			int clockwiseDifference = Math.abs( 
				letterPositions.get( exhibitName.charAt(i) ) -
				letterPositions.get( currentLetter )
			);
			int counterClockwiseDifference = Math.abs( 
				26 -
				Math.abs( 
					letterPositions.get( exhibitName.charAt(i) ) -
					letterPositions.get( currentLetter )
				)
			);
			minRotationCount += Math.min(clockwiseDifference, counterClockwiseDifference);
			
			currentLetter = exhibitName.charAt(i);
		}
		
		System.out.println(minRotationCount);
		
		// Close scanner
		read.close();
	}
	
}
