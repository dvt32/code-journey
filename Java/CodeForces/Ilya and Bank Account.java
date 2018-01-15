// http://codeforces.com/problemset/problem/313/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		if (n > 0) {
			System.out.println(n);
		}
		else {
			String nStr = String.valueOf(n);
			String s1 = nStr.substring(0, nStr.length()-1);
			String s2 = nStr.substring(0, nStr.length()-2) + nStr.charAt(nStr.length()-1);
			int max = Math.max(
				n,
				Math.max(Integer.valueOf(s1), Integer.valueOf(s2))
			);
			System.out.println(max);
		}
		
		// Close scanner
		read.close();
	}
	
}
