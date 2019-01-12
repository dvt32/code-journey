// https://codeforces.com/problemset/problem/734/B

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int k2 = read.nextInt();
		int k3 = read.nextInt();
		int k5 = read.nextInt();
		int k6 = read.nextInt();
		
		int sum = 0;
		
		while (k2 >= 1 && k5 >= 1 && k6 >= 1) {
			k2--;
			k5--;
			k6--;
			sum += 256;
		}
		
		while (k3 >= 1 && k2 >= 1) {
			k3--;
			k2--;
			sum += 32;
		}
		
		System.out.println(sum);
		
		// Close scanner
		read.close();
	}

}
