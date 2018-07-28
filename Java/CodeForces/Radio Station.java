// https://codeforces.com/problemset/problem/918/B

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		int m = read.nextInt();
		
		read.nextLine();
		
		Map<String, String> ipServerNames = new HashMap<String, String>();
		for (int i = 0; i < n; ++i) {
			String[] line = read.nextLine().split(" ");
			String name = line[0];
			String ip = line[1];
			ipServerNames.put(ip, name);
		}
		
		for (int i = 0; i < m; ++i) {
			String[] line = read.nextLine().split(" ");
			String ip = line[1].substring(0, line[1].length()-1);
			System.out.println( line[0] + " " + line[1] + " #" + ipServerNames.get(ip) );
		}
		
		// Close scanner
		read.close();
	}
}
