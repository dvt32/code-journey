// http://www.codeabbey.com/index/task_view/array-checksum

import java.util.Scanner;

public class Solution {
	
	public static final int SEED = 113;
	public static final int LIMIT = 10000007;
	
	public static long getChecksum(int[] arr) {
		long result = 0;
		
		for (int i = 0; i < arr.length; ++i) {
			result += arr[i];
			result *= SEED;
			result %= LIMIT;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int length = read.nextInt();
		
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = read.nextInt();
		}
		
		long checksum = getChecksum(arr);
		
		System.out.println(checksum);
		
		// Close scanner
		read.close();
	}
}
