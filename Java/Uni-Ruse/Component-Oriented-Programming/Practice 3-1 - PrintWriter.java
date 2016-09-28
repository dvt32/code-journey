// Component-Oriented Programming, Practice 3, 28.09.2016 - dvt32

// PrintWriter - writing to a file

import java.io.*;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter printWriter = new PrintWriter("H:\\text.txt");
		
		printWriter.println("Test");
		printWriter.close();
	}
  
}
