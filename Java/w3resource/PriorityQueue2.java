import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) {
		Queue<String> colors = new PriorityQueue<String>();
		
		colors.add("a red");
		colors.add("c green");
		colors.add("b blue");
		
		// Not necessarily printed in natural order
		for (String color : colors) {
			System.out.println(color);
		}
	}
}
