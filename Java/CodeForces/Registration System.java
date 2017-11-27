// http://codeforces.com/problemset/problem/4/C

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		Map<String, Integer> names = new HashMap<String, Integer>();
		
		int n = Integer.parseInt( read.nextLine() );
		for (int i = 0; i < n; ++i) {
			String name = read.nextLine();
			if (names.get(name) == null) {
				names.put(name, 0);
				System.out.println("OK");
			}
			else {
				int newPostfix = names.get(name)+1;
				names.put(name, newPostfix);
				System.out.println(name + newPostfix);
			}
		}
		
		// Close scanner
		read.close();
	}
	
}
