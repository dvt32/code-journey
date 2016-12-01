/*
 * 2. Дадена е матрица unsigned a[MAX][MAX]. Да се напише функция, която извежда елемен-
тите ѝ по спирала, например за n = 5 имаме:

1 16 15 14 13
2 17 24 23 12
3 18 25 22 11
4 19 20 21 10
5  6  7  8  9

Explained here: http://javaconceptoftheday.com/how-to-create-spiral-of-numbers-matrix-in-java/

 */

import java.util.Scanner;

public class Solution {
	
	public static int[][] generateSpiralMatrix(int n) {
		int[][] spiralMatrix = new int[n][n];
		
		int number = 1;
		
		int minColumn = 0;
		int maxColumn = n-1;
		int minRow = 0;
		int maxRow = n-1;
		
		while (number <= n*n) {
			for (int i = minRow; i <= maxRow; ++i) {
				spiralMatrix[i][minColumn] = number;
				number++;
			}
			for (int i = minColumn+1; i <= maxColumn; ++i) {
				spiralMatrix[maxRow][i] = number;
				number++;
			}
			for (int i = maxRow-1; i >= minRow; --i) {
				spiralMatrix[i][maxColumn] = number;
				number++;
			}
			for (int i = maxColumn-1; i >= minColumn+1; --i) {
				spiralMatrix[minRow][i] = number;
				number++;
			}
			minColumn++;
			maxColumn--;
			minRow++;
			maxRow--;
		}
		
		return spiralMatrix;
	}
	
	public static void printArray(int[][] arr, int n) {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[][] result = generateSpiralMatrix(n);
		
		printArray(result, n);
		
		// Close scanner
		read.close();
	}
}
