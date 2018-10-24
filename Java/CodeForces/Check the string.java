// http://codeforces.com/problemset/problem/960/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String s = read.nextLine();
		
		// Close scanner
		read.close();
		
		char[] temp = s.toCharArray();
		Arrays.sort(temp);
		String s_sorted = String.valueOf(temp);
		
		if (s.equals(s_sorted)) {
			int aCount = 0;
			int bCount = 0;
			int cCount = 0;
			
			for (int i = 0; i < s.length(); ++i) {
				char c = s.charAt(i);
				switch (c) {
					case 'a': aCount++; break;
					case 'b': bCount++; break;
					case 'c': cCount++; break;
					default: break;
				}
			}
			
			if (aCount != 0 && bCount != 0) {
				if (cCount == aCount || cCount == bCount) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
			else {
				System.out.println("NO");
			}
		}
		else {
			System.out.println("NO");
		}
	}

}
