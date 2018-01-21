// http://codeforces.com/problemset/problem/456/A

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static class LaptopPair {
		private int price;
		private int quality;
		
		public LaptopPair(int price, int quality) {
			this.price = price;
			this.quality = quality;
		}
		
		public int getPrice() { return price; }
		public int getQuality() { return quality; }
	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		// Add to list
		List<LaptopPair> laptopPairs = new ArrayList<LaptopPair>();
		for (int i = 0; i < n; ++i) {
			int a = read.nextInt();
			int b = read.nextInt();
			laptopPairs.add(new LaptopPair(a, b));
		}
		
		// Sort list
		Collections.sort(laptopPairs, new Comparator<LaptopPair>() {
			@Override
			public int compare(LaptopPair firstPair, LaptopPair secondPair) {
				if ( firstPair.getPrice() > secondPair.getPrice() ) {
					return 1;
				}
				else {
					return -1;
				}
			}
		});
		
		// Check if Alex is right
		boolean alexIsCorrect = false;
		for (int i = 0; i < laptopPairs.size()-1; ++i) {
			if ( laptopPairs.get(i).getQuality() > laptopPairs.get(i+1).getQuality() ) {
				alexIsCorrect = true;
				break;
			}
		}
		
		// Print end result
		if (alexIsCorrect) {
			System.out.println("Happy Alex");
		}
		else {
			System.out.println("Poor Alex");
		}
		
		// Close scanner
		read.close();
	}
	
}
