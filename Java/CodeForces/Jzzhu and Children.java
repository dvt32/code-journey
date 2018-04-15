// http://codeforces.com/problemset/problem/450/A

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static class Child {
		private int index;
		private int numberOfCandies;
		
		public Child(int index, int numberOfCandies) {
			super();
			this.index = index;
			this.numberOfCandies = numberOfCandies;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public int getNumberOfCandies() {
			return numberOfCandies;
		}

		public void setNumberOfCandies(int numberOfCandies) {
			this.numberOfCandies = numberOfCandies;
		}
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		
		Queue<Child> children = new LinkedList<Child>();
		for (int i = 0; i < n; ++i) {
			int index = i+1;
			int numberOfCandies = read.nextInt();
			children.add( new Child(index, numberOfCandies) );
		}
		
		while ( children.size() > 1 ) {
			Child child = children.peek();
			child.setNumberOfCandies( child.getNumberOfCandies()-m );
			if (child.getNumberOfCandies() <= 0) {
				children.remove();
			}
			else {
				Child removedChild = children.remove();
				children.add(removedChild);
			}
		}
		
		System.out.println( children.peek().getIndex() );
		
		// Close scanner
		read.close();
	}
	
}
