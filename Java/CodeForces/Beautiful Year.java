// http://codeforces.com/problemset/problem/271/A

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String year = read.nextLine();
		int currentYear = Integer.parseInt(year)+1;
		Set<Character> uniqueDigitsOfCurrentYear = new HashSet<Character>();
		
		while (true) {
			String currentYearToString = String.valueOf(currentYear);
			uniqueDigitsOfCurrentYear.clear();
			
			for (int i = 0; i < currentYearToString.length(); ++i) {
				uniqueDigitsOfCurrentYear.add( currentYearToString.charAt(i) );
			}
			
			if (uniqueDigitsOfCurrentYear.size() == 4) {
				break;
			}
			else {
				currentYear++;
			}
		}
		
		System.out.println(currentYear);
		
		// Close scanner
		read.close();
	}
	
}
