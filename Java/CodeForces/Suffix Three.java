// https://codeforces.com/problemset/problem/1281/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int t = Integer.parseInt( read.nextLine() );
		for (int i = 0; i < t; ++i) {
			String sentence = read.nextLine();
			if (sentence.endsWith("po")) {
				System.out.println("FILIPINO");
			}
			else if ( sentence.endsWith("desu") || sentence.endsWith("masu") ) {
				System.out.println("JAPANESE");
			}
			else {
				System.out.println("KOREAN");
			}
		}
		
		// Close scanner
		read.close();
	}

}
