// http://codeforces.com/problemset/problem/133/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String line = read.nextLine();
		
		boolean willProduceOutput = false;
		for (int i = 0; i < line.length(); ++i) {
			char c = line.charAt(i);
			if (c == 'H' || c == 'Q' || c == '9') {
				willProduceOutput = true;
				break;
			}
		}
		
		if (willProduceOutput) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}
	
}
