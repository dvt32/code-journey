// http://codeforces.com/problemset/problem/71/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = Integer.parseInt( read.nextLine() );
		for (int i = 0; i < n; ++i) {
			String line = read.nextLine();
			if (line.length() > 10) {
				line =
					line.charAt(0) +
					String.valueOf( line.substring(1, line.length()-1).length() ) +
					line.charAt(line.length()-1);
			}
			
			System.out.println( line );
		}
		
		// Close scanner
		read.close();
	}

}
