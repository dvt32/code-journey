// https://codeforces.com/problemset/problem/1191/A

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static String getCategory(int x) {
		int rem = x % 4;
		
		if (rem == 1) { return "A"; }
		if (rem == 3) { return "B"; }
		if (rem == 2) { return "C"; }
		if (rem == 0) { return "D"; }
		
		return null;
	}
	
	static class CategoryIncreasePair {
		private String category;
		private int increase;
		
		public CategoryIncreasePair(String category, int increase) {
			super();
			this.category = category;
			this.increase = increase;
		}

		public String getCategory() {
			return category;
		}
		
		public int getIncrease() {
			return increase;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int x = read.nextInt();
		
		List<CategoryIncreasePair> categoryIncreasePairs = new ArrayList<>();
		for (int i = 0; i <= 2; ++i) {
			categoryIncreasePairs.add(
				new CategoryIncreasePair( getCategory(x+i), i )
			);
		}
		Collections.sort(categoryIncreasePairs, new Comparator<CategoryIncreasePair> () {
			@Override
			public int compare(CategoryIncreasePair o1, CategoryIncreasePair o2) {
				return o1.getCategory().compareTo(o2.getCategory());
			}
		});
		
		System.out.println(
			categoryIncreasePairs.get(0).getIncrease() + 
			" " +
			categoryIncreasePairs.get(0).getCategory()
		);
	
		// Close scanner
		read.close();
	}

}
