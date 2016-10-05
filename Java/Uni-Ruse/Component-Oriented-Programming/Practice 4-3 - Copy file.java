// Component-Oriented Programming, Practice 4, 05.10.2016 - dvt32

// Copy file

import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws IOException { 
		
		FileInputStream fileInput;
		FileOutputStream fileOutput;
		int k = 0;
		
		// Handle input
		try {
			fileInput = new FileInputStream("P:\\pingvin.jpg");
		}
		catch (FileNotFoundException ex) {
			System.out.println("File not found.");
			return;
		}
		
		// Handle output
		try {
			fileOutput = new FileOutputStream("P:\\new_pingvin.jpg");
		}
		catch (FileNotFoundException ex) {
			System.out.println("File not found.");
			return;
		}
		
		// Copy file
		do {
			k = fileInput.read();
			if (k != -1) {
				fileOutput.write(k);
			}
		} while (k != -1);
		
		fileInput.close();
		fileOutput.close();
	}

}
