// http://codeforces.com/problemset/problem/282/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int statementCount = Integer.parseInt( read.nextLine() );
		int x = 0;
		
		for (int i = 0; i < statementCount; ++i) {
			String statement = read.nextLine();
			if (statement.startsWith("++")) {
				++x;
			}
			else if (statement.endsWith("++")) {
				x++;
			}
			else if (statement.startsWith("--")) {
				--x;
			}
			else if (statement.endsWith("--")) {
				x--;
			}
		}
		
		System.out.println(x);
		
		// Close scanner
		read.close();
	}

}
