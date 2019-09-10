// https://codeforces.com/problemset/problem/1174/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] firstPart = new int[n];
		int[] secondPart = new int[n];
		
		int firstSum = 0;
		for (int i = 0; i < n; ++i) {
			firstPart[i] = read.nextInt();
			firstSum += firstPart[i];
		}
		
		int secondSum = 0;
		for (int i = 0; i < n; ++i) {
			secondPart[i] = read.nextInt();
			secondSum += secondPart[i];
		}
		
		if (firstSum != secondSum) {
			for (int i = 0; i < n; ++i) { 
				System.out.print(firstPart[i] + " "); 
			};
			for (int i = 0; i < n; ++i) { 
				System.out.print(secondPart[i] + " "); 
			};
		}
		else {
			boolean swapped = false;
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (firstPart[i] != secondPart[j]) {
						int temp = firstPart[i];
						firstPart[i] = secondPart[j];
						secondPart[j] = temp;
						swapped = true;
						break;
					}
				}
				if (swapped) {
					break;
				}
			}
			
			if (!swapped) {
				System.out.println("-1");
			}
			else {
				for (int i = 0; i < n; ++i) { 
					System.out.print(firstPart[i] + " "); 
				};
				for (int i = 0; i < n; ++i) { 
					System.out.print(secondPart[i] + " "); 
				};
			}
		}
	
		// Close scanner
		read.close();
	}

}
