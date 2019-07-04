// https://codeforces.com/problemset/problem/63/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = Integer.parseInt( read.nextLine() );
		
		String[] names = new String[n];
		String[] statuses = new String[n];
		for (int i = 0; i < n; ++i) {
			String[] words = read.nextLine().split(" ");
			names[i] = words[0];
			statuses[i] = words[1];
		}
		
		for (int i = 0; i < n; ++i) {
			if ( statuses[i].equals("rat") ) {
				System.out.println(names[i]);
			}
		}
		
		for (int i = 0; i < n; ++i) {
			if ( statuses[i].equals("woman") || statuses[i].equals("child") ) {
				System.out.println(names[i]);
			}
		}
		
		for (int i = 0; i < n; ++i) {
			if ( statuses[i].equals("man") ) {
				System.out.println(names[i]);
			}
		}
		
		for (int i = 0; i < n; ++i) {
			if ( statuses[i].equals("captain") ) {
				System.out.println(names[i]);
				break;
			}
		}
		
		// Close scanner
		read.close();
	}

}
