// https://codeforces.com/problemset/problem/1230/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int a1 = read.nextInt();
		int a2 = read.nextInt();
		int a3 = read.nextInt();
		int a4 = read.nextInt();
		
		if ( a1+a2 == a3+a4 || 
			 a1+a3 == a2+a4 || 
			 a2+a3 == a1+a4 ||
			 a1+a2+a3 == a4 ||
			 a1+a3+a4 == a2 || 
			 a1+a2+a4 == a3 || 
			 a2+a3+a4 == a1 )
		{
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}

}
