/*
 * 1.3 
 *  В един текстов файл са зададени данни за правоъгълници, 
 *  имащи страни съответно успоредни на координатните оси.
 * 	
 * В един ред са данните 
 *  - X и Y за горната лява точка, последвани от 
 *  - X и Y за долната дясна точка
 *  
 *  Като разделител служи интервал.
 *  
 *  Да се състави Application на Java за 
 *  - прочитане на този файл и за
 *  - графично представяне на правоъгълниците
 *  
 */

import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class CourseWork extends Frame {
	
	public static final String PATH_TO_FILE = "D:\\input.txt";
	
	// Default constructor - sets Frame settings like size, background color and ability to close it
	public CourseWork() {
		super("COP Course Work #1 - dvt32, 146518 - 1.3 Rectangles");
		addWindowListener(new WindowClosingAdapter(true));
		setBackground(Color.decode("#89cff0"));
		setSize(1024, 768);
		setVisible(true);
	}
	
	public List<int[]> getCoordinatesFromFile(String pathToFile) {
		List<int[]> coordinates = new ArrayList<int[]>();
		BufferedReader bufferedReader;
		FileReader fileReader;
		String lineInFile = "";
		
		// Try to open input file
		try {
			fileReader = new FileReader(pathToFile);
			bufferedReader = new BufferedReader(fileReader);
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return coordinates;
		}
		
		// Read file line by line
		try {
			while ((lineInFile = bufferedReader.readLine()) != null) {
				String[] numbersOnLine = lineInFile.split("[ ,:!?]+");
				int upperLeftX = Integer.parseInt(numbersOnLine[0]);
				int upperLeftY = Integer.parseInt(numbersOnLine[1]);
				int lowerRightX = Integer.parseInt(numbersOnLine[2]);
				int lowerRightY = Integer.parseInt(numbersOnLine[3]);
				int widthOfRectangle = lowerRightX - upperLeftX;
				int heightOfRectangle = lowerRightY - upperLeftY;
				// Add coordinates to 2D ArrayList
				coordinates.add(new int[] { upperLeftX, upperLeftY, widthOfRectangle, heightOfRectangle });
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
		// Close streams
		try {
			fileReader.close();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return coordinates;
	}
	
	// Draws the rectangles on the screen
	public void paint(Graphics g) { 
		List<int[]> coordinates = getCoordinatesFromFile(PATH_TO_FILE);
		for (int[] rowOfCoordinates : coordinates) {
			int upperLeftX = rowOfCoordinates[0];
			int upperLeftY = rowOfCoordinates[1];
			int widthOfRectangle = rowOfCoordinates[2];
			int heightOfRectangle = rowOfCoordinates[3];
			g.drawRect(upperLeftX, upperLeftY, widthOfRectangle, heightOfRectangle);
		}
	}

	// Main method
	public static void main(String[] args) {
		// Load main window and display rectangles
		CourseWork mainWindow = new CourseWork();
	}
}
