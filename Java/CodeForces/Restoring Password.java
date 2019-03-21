// https://codeforces.com/problemset/problem/94/A

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String accountInfo = read.nextLine();
		
		Map<String, Integer> binaryCodeNumbers = new HashMap<String, Integer>();
		
		for (int number = 0; number <= 9; ++number) {
			String binaryCode = read.nextLine();
			binaryCodeNumbers.put(binaryCode, number);
		}
		
		StringBuilder output = new StringBuilder();
		for (int substringBeginIndex = 0; substringBeginIndex < 80; substringBeginIndex += 10) {
			String binaryCodeSubstring = accountInfo.substring(substringBeginIndex, substringBeginIndex+10);
			output.append( binaryCodeNumbers.get(binaryCodeSubstring) );
		}
		
		System.out.println(output);
		
		// Close scanner
		read.close();
	}

}
