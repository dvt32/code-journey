// https://www.hackerrank.com/challenges/divisible-sum-pairs

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int k = read.nextInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = read.nextInt();
		}
		
		int numberOfPairs = 0;
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr.length; ++j) {
				if (((arr[i] + arr[j]) % k) == 0 && i < j) {
					numberOfPairs++;
				}
			}
		}
		
		System.out.println(numberOfPairs);
		
		// Close scanner
		read.close();
	}
}
