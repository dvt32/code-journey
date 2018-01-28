// http://codeforces.com/problemset/problem/12/B

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String n = read.nextLine();
		String m = read.nextLine();
		
		// If Bob's answer starts with a leading zero - he is automatically wrong
		if (m.length() > 1 && m.startsWith("0")) {
			System.out.println("WRONG_ANSWER");
			read.close();
			return;
		}
			
		// Get smallest possible number (with leading zeros)
		char[] nDigits = n.toCharArray();
		Arrays.sort(nDigits);
		String smallestNumber = new String(nDigits);
		
		// Get smallest possible number WITHOUT leading zeros
		StringBuilder smallestValidNumber = new StringBuilder();
		if ( smallestNumber.length() == 1 || !smallestNumber.startsWith("0") ) {
			smallestValidNumber.append(smallestNumber);
		}
		else {
			int i = 0;
			while (i < smallestNumber.length() && smallestNumber.charAt(i) == '0') {
				i++;
			}
			smallestValidNumber.append( smallestNumber.substring(i, i+1) );
			for (int j = 0; j < i; ++j) { smallestValidNumber.append("0"); };
			smallestValidNumber.append( smallestNumber.substring(i+1) );
		}
		
		// Print if Bob is correct
		if (smallestValidNumber.toString().equals(m)) {
			System.out.println("OK");
		}
		else {
			System.out.println("WRONG_ANSWER");
		}
		
		// Close scanner
		read.close();
	}
	
}
