// http://codeforces.com/problemset/problem/867/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		read.nextLine();
		
		String line = read.nextLine();
		
		int numberOfFlightsToSanFrancisco = 0;
		int numberOfFlightsToSeattle = 0;
		for (int i = 0; i < n-1; ++i) {
			char currentCity = line.charAt(i);
			char nextCity = line.charAt(i+1);
			
			if (currentCity == 'S' && nextCity == 'F') {
				numberOfFlightsToSanFrancisco++;
			}
			else if (currentCity == 'F' && nextCity == 'S') {
				numberOfFlightsToSeattle++;
			}		
		}
		
		if (numberOfFlightsToSanFrancisco > numberOfFlightsToSeattle) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
			
		// Close scanner
		read.close();
	}

}
