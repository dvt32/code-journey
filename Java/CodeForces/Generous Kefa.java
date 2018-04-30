// http://codeforces.com/problemset/problem/841/A

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int k = read.nextInt();
		
		// Clear buffer
		read.nextLine();
		
		String s = read.nextLine();
		
		Map<Character, Integer> balloonFrequencies = new HashMap<Character, Integer>();
		for (int i = 0; i < n; ++i) {
			char balloon = s.charAt(i);
			Integer balloonFrequency = balloonFrequencies.get(balloon);
			if (balloonFrequency == null) {
				balloonFrequencies.put(balloon, 1);
			}
			else {
				balloonFrequencies.put(balloon, balloonFrequency+1);
			}
		}
		
		boolean allFriendsHappy = true;
		for (Character balloon : balloonFrequencies.keySet()) {
			/*
			The number of balloons of any colour should not exceed the number of people. 
			That forces one person to get balloons of the same colour by the pigeonhole principle.
			 */
			if (balloonFrequencies.get(balloon) > k) {
				allFriendsHappy = false;
				break;
			}
		}
		
		if (allFriendsHappy) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}
	
}
