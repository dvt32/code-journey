// Component-Oriented Programming, Practice 5, 12.10.2016 - dvt32

// Copy file - v3 - with args[] & currentTimeMillis()

import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws IOException { 
		
		FileInputStream fileInput;
		FileOutputStream fileOutput;
		byte[] buffer = new byte[512];
		
		int k = 0;
		
		// Handle input
		try {
			fileInput = new FileInputStream(args[0]);
		}
		catch (IndexOutOfBoundsException ex) {
			System.out.println("Missing file name.");
			return;
		}
		catch (FileNotFoundException ex) {
			System.out.println("File not found.");
			return;
		}
		
		// Handle output
		try {
			fileOutput = new FileOutputStream(args[1]);
		}
		catch (IndexOutOfBoundsException ex) {
			System.out.println("Missing file name.");
			return;
		}
		catch (FileNotFoundException ex) {
			System.out.println("File not found.");
			return;
		}
		
		// Copy file
		long startTime = System.currentTimeMillis();
		do {
			k = fileInput.read(buffer);
			if (k > 0) {
				fileOutput.write(buffer);
			}
		} while (k > 0);
		long endTime = System.currentTimeMillis();
		
		fileInput.close();
		fileOutput.close();
		
		long timeToExecuteMethod = endTime - startTime;
		
		System.out.println(timeToExecuteMethod);
	}

}
