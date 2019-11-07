// https://codeforces.com/problemset/problem/1216/B

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		List<Element> elements = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			int a = read.nextInt();
			elements.add( new Element(i+1, a) );
		}
		
		Collections.sort(elements);
		Collections.reverse(elements);
		
		int minShots = 0;
		int x = 0;
		for (int i = 0; i < n; ++i) {
			minShots += (elements.get(i).value * x) + 1;
			x++;
		}
		
		System.out.println(minShots);
		for (Element e : elements) {
			System.out.print(e.index + " ");
		}
		
		// Close scanner
		read.close();
	}

}

class Element 
	implements Comparable<Element> 
{
    int index, value;

    Element(int index, int value){
        this.index = index;
        this.value = value;
    }

    public int compareTo(Element e) {
        return this.value - e.value;
    }
}
