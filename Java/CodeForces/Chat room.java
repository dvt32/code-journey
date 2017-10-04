// http://codeforces.com/problemset/problem/58/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String line = read.nextLine();
		
		read.close();
	
		int h_index = line.indexOf("h");
		if (h_index == -1) {
			System.out.println("NO");
			return;
		}
		
		int e_index = line.indexOf("e", h_index+1);
		if (e_index == -1) {
			System.out.println("NO");
			return;
		}
		
		int first_l_index = line.indexOf("l", e_index+1);
		if (first_l_index == -1) {
			System.out.println("NO");
			return;
		}
		
		int second_l_index = line.indexOf("l", first_l_index+1);
		if (second_l_index == -1) {
			System.out.println("NO");
			return;
		}
		
		int o_index = line.indexOf("o", second_l_index+1);
		if (o_index == -1) {
			System.out.println("NO");
			return;
		}
		
		System.out.println("YES");
		
	}
	
}
