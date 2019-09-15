// https://codeforces.com/problemset/problem/988/B

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = Integer.parseInt( read.nextLine() );
		
		String[] strings = new String[n];
		for (int i = 0; i < n; ++i) {
			strings[i] = read.nextLine();
		}
		
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});
		
		boolean canBeReordered = true;
		for (int i = 1; i < n; ++i) {
			if (!strings[i].contains(strings[i-1])) {
				canBeReordered = false;
				break;
			}
		}
		
		if (canBeReordered) {
			System.out.println("YES");
			for (String string : strings) {
				System.out.println(string);
			}
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}

}
