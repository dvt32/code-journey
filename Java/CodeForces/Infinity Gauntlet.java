// http://codeforces.com/problemset/problem/987/A

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();

		// Escape newline
		read.nextLine();

		Map<String, String> gems = new HashMap<String, String>();
		gems.put("purple", "Power");
		gems.put("green", "Time");
		gems.put("blue", "Space");
		gems.put("orange", "Soul");
		gems.put("red", "Reality");
		gems.put("yellow", "Mind");

		for (int i = 0; i < n; ++i) {
			String color = read.nextLine();
			gems.remove(color);
		}
		
		System.out.println(gems.size());
		for (String color : gems.keySet()) {
			System.out.println( gems.get(color) );
		}

		// Close scanner
		read.close();
	}
}
