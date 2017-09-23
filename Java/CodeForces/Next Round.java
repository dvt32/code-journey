// http://codeforces.com/problemset/problem/158/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String line = read.nextLine();
		int k = Integer.parseInt( line.substring(line.indexOf(" ")+1) );
		
		int[] numbers = Arrays.stream( read.nextLine().split(" ") ).mapToInt(Integer::parseInt).toArray();
		int kthScore = numbers[k-1];
		int numberOfParticipantsWhoAdvance = 0;
		
		for (int i = 0; i < numbers.length; ++i) {
			if (numbers[i] > 0 && numbers[i] >= kthScore) {
				numberOfParticipantsWhoAdvance++;
			}
		}
		
		System.out.println( numberOfParticipantsWhoAdvance );
		
		// Close scanner
		read.close();
	}

}
