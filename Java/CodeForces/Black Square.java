// http://codeforces.com/problemset/problem/431/A

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		Map<Character, Integer> caloriesWasted = new HashMap<Character, Integer>();
		for (char c = '1'; c <= '4'; ++c) {
			caloriesWasted.put(c, read.nextInt());
		}
		
		read.nextLine(); // clear buffer
		
		int numberOfWastedCalories = 0;
		String s = read.nextLine();
		for (int i = 0; i < s.length(); ++i) {
			numberOfWastedCalories += caloriesWasted.get( s.charAt(i) );
		}
		
		System.out.println(numberOfWastedCalories);
		
		// Close scanner
		read.close();
	}
	
}
