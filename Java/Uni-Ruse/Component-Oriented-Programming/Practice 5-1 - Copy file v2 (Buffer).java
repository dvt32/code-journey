// Component-Oriented Programming, Practice 5, 12.10.2016 - dvt32

// Copy file - v2 (buffer)

import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws IOException { 
		
		FileInputStream fileInput;
		FileOutputStream fileOutput;
		byte[] buffer = new byte[100];
		
		int k = 0;
		
		// Handle input
		try {
			fileInput = new FileInputStream("H:\\logo.png");
		}
		catch (FileNotFoundException ex) {
			System.out.println("File not found.");
			return;
		}
		
		// Handle output
		try {
			fileOutput = new FileOutputStream("H:\\new_logo.png");
		}
		catch (FileNotFoundException ex) {
			System.out.println("File not found.");
			return;
		}
		
		// Copy file
		do {
			k = fileInput.read(buffer);
			if (k > 0) {
				fileOutput.write(buffer);
			}
		} while (k > 0);
		
		fileInput.close();
		fileOutput.close();
	}

}
