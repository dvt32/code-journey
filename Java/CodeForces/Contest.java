// http://codeforces.com/problemset/problem/501/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int a = read.nextInt();
		int b = read.nextInt();
		int c = read.nextInt();
		int d = read.nextInt();
		
		int mishaPoints = Math.max( 
			(3*a)/10, 
			a - ( (a/250)*c ) 
		);
		int vasyaPoints = Math.max( 
			(3*b)/10, 
			b - ( (b/250)*d ) 
		);
		
		if (mishaPoints > vasyaPoints) {
			System.out.println("Misha");
		}
		else if (vasyaPoints > mishaPoints) {
			System.out.println("Vasya");
		}
		else {
			System.out.println("Tie");
		}
		
		// Close scanner
		read.close();
	}
	
}
