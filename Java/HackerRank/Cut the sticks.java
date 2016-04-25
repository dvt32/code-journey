// https://www.hackerrank.com/challenges/cut-the-sticks

import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	
	public static void main(String[] args) {	
		Scanner read = new Scanner(System.in);
	
		// Enter number of integers & validate input
		int N = read.nextInt();
		if (N < 1 || N > 1000) {
			read.close();
			return;
		}
		
		// Enter N integers & validate input
		int arr[] = new int[N];
		for (int i = 0; i < N; ++i) {
			arr[i] = read.nextInt();
			if (arr[i] < 1 || arr[i] > 1000) {
				read.close();
				return;
			}
		}
		
		// Sort array
		Arrays.sort(arr);
	
		// Perform cut operation
		for (int i = 0; i < N; ++i) {
			if (arr[i] == 0) { 
				continue; 
			}
			int minElement = arr[i];
			int numberOfCutSticks = 0;
			// Decrease each stick's value & calculate number of cut sticks
			for (int j = 0; j < N; ++j) {
				if (arr[j] != 0) {
					arr[j] -= minElement;
					numberOfCutSticks++;
				}
			}
			System.out.println(numberOfCutSticks);
		}
		
		// Close scanner
		read.close();
	}
}
