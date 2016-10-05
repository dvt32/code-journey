// Component-Oriented Programming, Practice 4, 05.10.2016 - dvt32

// Get people born in the winter by their EGN, Version 2 with an input stream

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	
	public static void main(String[] args) throws NumberFormatException, IOException { 
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int numberOfPeople = Integer.parseInt(bufferedReader.readLine());
		
		for (int i = 0; i < numberOfPeople; ++i) {
			String EGN = bufferedReader.readLine();
			int monthBorn = Integer.parseInt(EGN.substring(2, 4));
			if (isBornInWinter(monthBorn)) {
				System.out.println(EGN + " was born in the winter.");
			}
			else {
				System.out.println(EGN + " was NOT born in the winter.");
			}
		}
		
		// Close scanner
		bufferedReader.close();
	}

}
