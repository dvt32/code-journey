// https://codeforces.com/problemset/problem/978/A

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		Integer[] a = new Integer[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		List<Integer> output = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			List<Integer> subArrayAsList = Arrays.asList(a).subList(i+1, n);
			if ( !subArrayAsList.contains(a[i]) ) {
				output.add(a[i]);
			}
		}
		
		System.out.println( output.size() );
		for (Integer element : output) {
			System.out.print(element + " ");
		}

		// Close scanner
		read.close();
	}

}
