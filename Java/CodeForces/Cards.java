// http://codeforces.com/problemset/problem/701/A

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static class Number {
		private int index;
		private int value;
		
		public Number(int index, int value) { this.index = index; this.value = value; }
		
		public int getIndex() { return index; }
		public void setIndex(int index) { this.index = index; }
		public int getValue() { return value; }
		public void setValue(int value) { this.value = value; }
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		List<Number> numbers = new ArrayList<Number>();
		for (int i = 0; i < n; ++i) {
			numbers.add( new Number(i+1, read.nextInt()) );
		}
		
		Collections.sort(numbers, new Comparator<Number>() {
			@Override
			public int compare(Number a, Number b) {
				if (a.getValue() > b.getValue()) { return 1; }
				else if (a.getValue() < b.getValue()) { return -1; }
				else return 0;
			}	
		});
		
		int firstNumberIndex = 0;
		int secondNumberIndex = (n-1);
		for (int i = 0; i < (n/2); ++i) {
			System.out.println( 
				numbers.get(firstNumberIndex).getIndex() + " " + 
				numbers.get(secondNumberIndex).getIndex()
			);
			firstNumberIndex++;
			secondNumberIndex--;
		}
		
		// Close scanner
		read.close();
	}
	
}
