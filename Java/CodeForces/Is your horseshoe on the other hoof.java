// http://codeforces.com/problemset/problem/228/A

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int[] horseShoeColors = new int[4];
		Set<Integer> uniqueHorseShoeColors = new HashSet<Integer>();
		
		for (int i = 0; i < 4; ++i) {
			horseShoeColors[i]  = read.nextInt();
			uniqueHorseShoeColors.add(horseShoeColors[i]);
		}
		
		int horseShoeBuyCount = Math.abs(horseShoeColors.length - uniqueHorseShoeColors.size());
		System.out.println(horseShoeBuyCount);
		
		// Close scanner
		read.close();
	}
	
}
