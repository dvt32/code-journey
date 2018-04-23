// http://codeforces.com/problemset/problem/255/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int numberOfChestExercises = 0;
		int numberOfBicepsExercises = 0;
		int numberOfBackExercises = 0;
		
		String currentExercise = "chest";
		for (int i = 0; i < n; ++i) {
			int numberOfExercises = read.nextInt();
			
			switch (currentExercise) {
			case "chest":
				numberOfChestExercises += numberOfExercises;
				currentExercise = "biceps";
				break;
			case "biceps":
				numberOfBicepsExercises += numberOfExercises;
				currentExercise = "back";
				break;
			case "back":
				numberOfBackExercises += numberOfExercises;
				currentExercise = "chest";
				break;
			}
		}
		
		int maxNumberOfExercises = Math.max(
			Math.max(numberOfChestExercises, numberOfBicepsExercises),
			numberOfBackExercises
		);
		
		if (maxNumberOfExercises == numberOfChestExercises) {
			System.out.println("chest");
		}
		else if (maxNumberOfExercises == numberOfBicepsExercises) {
			System.out.println("biceps");
		}
		else {
			System.out.println("back");
		}
		
		// Close scanner
		read.close();
	}
	
}
