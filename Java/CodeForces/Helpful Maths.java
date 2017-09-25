// http://codeforces.com/problemset/problem/96/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String[] numbers = read.nextLine().split("\\+");
		Arrays.sort(numbers);
		
		String sortedLine = String.join("+", numbers);
		System.out.println(sortedLine);
		
		// Close scanner
		read.close();
	}
	
}
