// http://www.codeabbey.com/index/task_view/bubble-in-array

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Solution {
	
	// Get checksum of array
	public static final int SEED = 113;
	public static final int LIMIT = 10000007;
	
	public static long getChecksum(List<Integer> arr) {
		long result = 0;
		
		for (int i = 0; i < arr.size(); ++i) {
			result += arr.get(i);
			result *= SEED;
			result %= LIMIT;
		}
		
		return result;
	}
	
	// Bubble Sort (first iteration)
	public static int getNumberOfBubbleSortSwaps(List<Integer> arr) {
		int numberOfSwaps = 0;
		
		for (int i = 0; i < arr.size()-1; ++i) {
			if (arr.get(i) > arr.get(i+1)) {
				int temp = arr.get(i+1);
				arr.set(i+1, arr.get(i));
				arr.set(i, temp);
				numberOfSwaps++;
			}
		}
		
		return numberOfSwaps;
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		List<Integer> sequence = new ArrayList<Integer>();
		
		while (true) {
			int number = read.nextInt();
			if (number == -1) {
				break;
			}
			sequence.add(number);
		}
		
		int swaps = getNumberOfBubbleSortSwaps(sequence);
		long checksum = getChecksum(sequence); // need to get the checksum AFTER sorting
		
		System.out.print(swaps + " " + checksum);
		
		// Close scanner
		read.close();
	}
}
