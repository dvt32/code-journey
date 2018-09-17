// http://codeforces.com/problemset/problem/835/B

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int k = read.nextInt();
		
		read.nextLine(); // clear buffer
		
		String n = read.nextLine();
		
		// Close scanner
		read.close();
		
		int digitSum = 0;
		for (int i = 0; i < n.length(); ++i) {
			digitSum += Character.getNumericValue( n.charAt(i) );
		}
		
		if (digitSum >= k) {
			System.out.println("0");
			return;
		}
		else {
			char[] n_copy = n.toCharArray();
			Arrays.sort(n_copy);		
			int minChangedDigits = 0;
			for (int i = 0; i < n_copy.length; ++i) {
				digitSum -= Character.getNumericValue( n_copy[i] );
				digitSum += 9;
				minChangedDigits++;
				if (digitSum >= k) {
					System.out.println(minChangedDigits);
					return;
				}
			}
		}
	}

}
