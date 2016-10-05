// Component-Oriented Programming, Practice 4, 05.10.2016 - dvt32

// Get people born in the winter by their EGN

import java.util.Scanner;

public class Solution {
	
	static boolean isBornInWinter(int monthBorn) {
		switch (monthBorn) {
			case 11: return true;
			case 12: return true;
			case 1: return true;
			case 2: return true;
			default: return false;
		}
	}
	
	public static void main(String[] args) { 
		Scanner read = new Scanner(System.in);
		
		int numberOfPeople = read.nextInt();
		
		for (int i = 0; i < numberOfPeople; ++i) {
			String EGN = read.next();
			int monthBorn = Integer.parseInt(EGN.substring(2, 4));
			if (isBornInWinter(monthBorn)) {
				System.out.println(EGN + " was born in the winter.");
			}
			else {
				System.out.println(EGN + " was NOT born in the winter.");
			}
		}
		
		// Close scanner
		read.close();
	}

}
