import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) {
		Queue<String> colors = new PriorityQueue<String>();
		
		colors.add("red");
		colors.add("blue");
		colors.add("green");
		
		System.out.println(colors); // not necessarily in natural order
	}
}
