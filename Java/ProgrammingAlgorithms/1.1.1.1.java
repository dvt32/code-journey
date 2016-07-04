/*
 * 1. Дадена е матрица unsigned a[MAX][MAX]. 

Да се напише функция
void fillMatrix(unsigned a[][], unsigned n),
която запълва с числа елементите на a[][] по следния начин:

{0} 20 19 17 14
1 {0} 18 16 13
2 5 {0} 15 12
3 6 8 {0} 11
4 7 9 10 {0}

 */

import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public static final int MAX = 5;
	
	public static void fillMatrix(int a[][], int n) {
		for (int i = 0, j = -1; i < MAX; ++i, ++j) {
				a[i][j+1] = n;
		}
		// Print modified array
		System.out.println(Arrays.deepToString(a));
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int[][] a = new int[][] 
		{
			{1, 20, 19, 17, 14},
			{1, 2, 18, 16, 13},
			{2, 5, 3, 15, 12},
			{3, 6, 8, 4, 11},
			{4, 7, 9, 10, 5}
		};
		
		fillMatrix(a, 0);
		
		// Close scanner
		read.close();
	}
}
