// http://codeforces.com/problemset/problem/466/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		read.nextLine();
		
		String fileName = read.nextLine();
		
		if (fileName.contains("xxx")) {
			StringBuilder sb = new StringBuilder(fileName);
			int xxxIndex = sb.indexOf("xxx");
			int minRemovedCharacters = 0;
			
			while (xxxIndex != -1) {
				sb.deleteCharAt(xxxIndex);
				xxxIndex = sb.indexOf("xxx");
				minRemovedCharacters++;
			}
			
			System.out.println(minRemovedCharacters);
		}
		else {
			System.out.println("0");
		}
		
		// Close scanner
		read.close();
	}
}
