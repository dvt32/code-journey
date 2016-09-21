// Component-Oriented Programming, Practice 2, 21.09.2016 - dvt32

// Trying out a different input stream

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		String line =  bufferedReader.readLine();
		int lineToInt = Integer.parseInt(line);
		System.out.println(lineToInt);
		
		bufferedReader.close(); // inputStreamReader is automatically closed after this call
		
	}

}
