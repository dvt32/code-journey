// http://codeforces.com/problemset/problem/609/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		
		int[] usbSizes = new int[n];
		for (int i = 0; i < n; ++i) {
			usbSizes[i] = read.nextInt();
		}
		
		Arrays.sort(usbSizes);
		
		int neededUsbDrivesCount = 0;
		for (int i = n-1; i >= 0; --i) {
			m -= usbSizes[i];
			neededUsbDrivesCount++;
			if (m <= 0) {
				break;
			}
		}
		
		System.out.println(neededUsbDrivesCount);
		
		// Close scanner
		read.close();
	}
}
