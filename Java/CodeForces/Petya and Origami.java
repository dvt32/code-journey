// https://codeforces.com/problemset/problem/1080/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int k = read.nextInt();
		
		int redSheetsNeeded = n * 2;
		int redBooksNeeded = redSheetsNeeded / k;
		if (redSheetsNeeded % k != 0) {
			redBooksNeeded++;
		}
		
		int greenSheetsNeeded = n * 5;
		int greenBooksNeeded = greenSheetsNeeded / k;
		if (greenSheetsNeeded % k != 0) {
			greenBooksNeeded++;
		}
		
		int blueSheetsNeeded = n * 8;
		int blueBooksNeeded = blueSheetsNeeded / k;
		if (blueSheetsNeeded % k != 0) {
			blueBooksNeeded++;
		}
		
		System.out.println( redBooksNeeded + greenBooksNeeded + blueBooksNeeded );
		
		// Close scanner
		read.close();
	}

}
