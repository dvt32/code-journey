// https://www.codeeval.com/open_challenges/220/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		File inputFile = new File(args[0]);
		
		try {
			Scanner fileReader = new Scanner(inputFile);
			
			while (fileReader.hasNextLine()) {
				String currentLine = fileReader.nextLine();
				
				if (currentLine.equals("")) {
					currentLine = fileReader.nextLine(); // escape reading Enter key press
				}
				
				String[] dataOnCurrentLine = currentLine.split(", ");
				
				int vampireCount = Integer.parseInt(
					dataOnCurrentLine[0].substring(
						dataOnCurrentLine[0].lastIndexOf(' ') + 1
					)
				);
				int zombieCount = Integer.parseInt(
					dataOnCurrentLine[1].substring(
						dataOnCurrentLine[1].lastIndexOf(' ') + 1
					)
				);
				int witchCount = Integer.parseInt(
					dataOnCurrentLine[2].substring(
						dataOnCurrentLine[2].lastIndexOf(' ') + 1
					)
				);
				int houseCount = Integer.parseInt(
					dataOnCurrentLine[3].substring(
						dataOnCurrentLine[3].lastIndexOf(' ') + 1
					)
				);
				
				final int NUMBER_OF_CANDIES_PER_VAMPIRE = 3;
				final int NUMBER_OF_CANDIES_PER_ZOMBIE = 4;
				final int NUMBER_OF_CANDIES_PER_WITCH = 5;
				
				int totalCandyCount = 
					vampireCount * NUMBER_OF_CANDIES_PER_VAMPIRE * houseCount +
					zombieCount * NUMBER_OF_CANDIES_PER_ZOMBIE * houseCount +
					witchCount * NUMBER_OF_CANDIES_PER_WITCH * houseCount;
				
				int candyPerPerson = totalCandyCount / (vampireCount + zombieCount + witchCount);
						
				System.out.println(candyPerPerson);
			}
			
			fileReader.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
