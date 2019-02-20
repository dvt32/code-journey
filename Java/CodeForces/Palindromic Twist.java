// https://codeforces.com/problemset/problem/1027/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int T = Integer.parseInt( read.nextLine() );
		
		for (int testCase = 0; testCase < T; ++testCase) {
			int n = Integer.parseInt( read.nextLine() );
			String s = read.nextLine();
			
			boolean palindromePossible = true;
			for (int i = 0, j = n-1; i < j; ++i, --j) {
				char beginningChar = s.charAt(i);
				char endingChar = s.charAt(j);

				char beginningChar_next = (char) (beginningChar+1);
				char beginningChar_prev = (char) (beginningChar-1);
				char endingChar_next = (char) (endingChar+1);
				char endingChar_prev = (char) (endingChar-1);

				if (beginningChar == 'a') {
					beginningChar_prev = beginningChar_next;
				}
				else if (beginningChar == 'z') {
					beginningChar_next = beginningChar_prev;
				}
				
				if (endingChar == 'a') {
					endingChar_prev = endingChar_next;
				}
				else if (endingChar == 'z') {
					endingChar_next = endingChar_prev;
				}
				
				if (beginningChar_next != endingChar_next &&
					beginningChar_prev != endingChar_prev &&
					beginningChar_next != endingChar_prev &&
					beginningChar_prev != endingChar_next) 
				{
					palindromePossible = false;
					break;
				}
			}
				
			if (palindromePossible) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		
		// Close scanner
		read.close();
	}

}
