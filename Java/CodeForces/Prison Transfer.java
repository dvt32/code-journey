// https://codeforces.com/problemset/problem/427/B

// With help from https://codeforces.com/blog/entry/12082

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int t = read.nextInt(); // max prisoner crime severity
		int c = read.nextInt(); // required prisoner sequence length
		
		int[] prisonerCrimeSeverities = new int[n];
		for (int i = 0; i < n; ++i) {
			prisonerCrimeSeverities[i] = read.nextInt();
		}
		
		int numberOfPrisonersInCurrentSequence = 0;
		int numberOfWaysPrisonersCanBeChosenInCurrentSequence = 0;
		int numberOfWaysPrisonersCanBeChosen = 0;
		
		for (int i = 0; i < n; ++i) {
			if (prisonerCrimeSeverities[i] <= t) {
				numberOfPrisonersInCurrentSequence++;
			}
			else {
				numberOfWaysPrisonersCanBeChosenInCurrentSequence = (numberOfPrisonersInCurrentSequence - c + 1);
				
				if (numberOfWaysPrisonersCanBeChosenInCurrentSequence > 0) {
					numberOfWaysPrisonersCanBeChosen += numberOfWaysPrisonersCanBeChosenInCurrentSequence;
				}
			
				numberOfPrisonersInCurrentSequence = 0;
			}
		}
		
		// If the last valid prisoner sequence ends with the last prisoner
		numberOfWaysPrisonersCanBeChosenInCurrentSequence = (numberOfPrisonersInCurrentSequence - c + 1);
		if (numberOfWaysPrisonersCanBeChosenInCurrentSequence > 0) {
			numberOfWaysPrisonersCanBeChosen += numberOfWaysPrisonersCanBeChosenInCurrentSequence;
		}
		
		System.out.println( numberOfWaysPrisonersCanBeChosen );
		
		// Close scanner
		read.close();
	}

}
