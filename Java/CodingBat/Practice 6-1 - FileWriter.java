// Component-Oriented Programming, Practice 6, 19.10.2016 - dvt32

// FileWriter

import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws IOException { 
		
		String line = "";
		FileWriter fileWriter;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			fileWriter = new FileWriter("output.txt");
		}
		catch (IOException e) {
			System.out.println("Failed to load file.");
			return;
		}
		
		System.out.println("Enter text or 'stop' to end program: ");
		
		while (true) {
			line = bufferedReader.readLine();
			if (line.equals("stop")) {
				break; 
			}
			line += "\r\n";
			fileWriter.write(line);
		}
		
		// Close reader & writer
		bufferedReader.close();
		fileWriter.close();
		
	}
	
}
