// http://codeforces.com/problemset/problem/1025/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = Integer.parseInt( read.nextLine() );
		
		String s = read.nextLine();
		
		if (n == 1) {
			System.out.println("Yes");
		}
		else {
			char[] s_sorted = s.toCharArray();
			Arrays.sort(s_sorted);
			boolean possibleToRecolor = false;
			for (int i = 0; i < n-1; ++i) {
				if (s_sorted[i] == s_sorted[i+1]) {
					possibleToRecolor = true;
					System.out.println("Yes");
					break;
				}
			}	
			if (!possibleToRecolor) {
				System.out.println("No");
			}
		}
		
		// Close scanner
		read.close();
	}

}
