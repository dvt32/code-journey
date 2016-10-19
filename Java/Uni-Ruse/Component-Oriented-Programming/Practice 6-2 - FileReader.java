// Component-Oriented Programming, Practice 6, 19.10.2016 - dvt32

// FileReader

import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws IOException { 
		
		FileReader fileReader = new FileReader("H:\\output.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = "";
		
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}
		
		// Close readers
		fileReader.close();
		bufferedReader.close();
			
	}
	
}
