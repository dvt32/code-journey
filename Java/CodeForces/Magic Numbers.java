// http://codeforces.com/problemset/problem/320/A

import java.util.Scanner;

public class Solution {
	
	public static boolean isMagic(String number) {
		for (int i = 0; i < number.length(); ++i) {
			if (number.charAt(i) != '1' && number.charAt(i) != '4') {
				return false;
			}
		}
		
		if (number.charAt(0) != '1') {
			return false;
		}
		
		if (number.contains("444")) {
			return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String n = read.nextLine();
		
		if (isMagic(n)) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}

}
