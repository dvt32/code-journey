// http://codeforces.com/problemset/problem/75/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int a = read.nextInt();
		int b = read.nextInt();
		long c = (long) a + b;
		
		String aWithoutZeros = String.valueOf(a).replace("0", "");
		String bWithoutZeros = String.valueOf(b).replace("0", "");
		String cWithoutZeros = String.valueOf(c).replace("0", "");
		
		a = Integer.parseInt(aWithoutZeros);
		b = Integer.parseInt(bWithoutZeros);
		c = Long.parseLong(cWithoutZeros);
		
		if ( c == (a+b) ) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}
}
