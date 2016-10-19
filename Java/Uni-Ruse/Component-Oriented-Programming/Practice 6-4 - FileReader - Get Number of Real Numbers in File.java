// Component-Oriented Programming, Practice 6, 19.10.2016 - dvt32

// FileReader + Get Number Of Real Numbers in File

import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws IOException { 
		
		FileReader fileReader = new FileReader("H:\\numbers.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = "";
		
		//int positiveNumbersCount = 0;
		int realNumbersCount = 0;
		//int positiveNumbersSum = 0;
		//double positiveNumbersAverage = 0.0;
		
		while ((line = bufferedReader.readLine()) != null) {
			String[] numbersOnLine = line.split("[ ,:!?]+");
			for (int i = 0; i < numbersOnLine.length; ++i) {
				if (numbersOnLine[i].contains("."))
				{
					try {
						double currentNumber = Double.parseDouble(numbersOnLine[i]);
						realNumbersCount++;
					}
						
					//if (currentNumber > 0) {
					//	positiveNumbersCount++;
					//	positiveNumbersSum += currentNumber;
					//}
					
					catch (NumberFormatException e) {
						continue;
					}
				}
			}
			System.out.println(line);
		}
		
		//if (positiveNumbersCount > 0) {
		//	positiveNumbersAverage = (double) positiveNumbersSum / positiveNumbersCount;
		//	System.out.println(positiveNumbersAverage);
		//}
		
		System.out.println(realNumbersCount);
		
		// Close readers
		fileReader.close();
		bufferedReader.close();
			
	}
	
}
