/*
 * You are given a text. Write a program which outputs its lines according to the following rules:

	If line length is ≤ 55 characters, print it without any changes.
	If the line length is > 55 characters, change it as follows:
		Trim the line to 40 characters.
		If there are spaces ‘ ’ in the resulting string, trim it once again to the last space 
			(the space should be trimmed too).
		Add a string ‘... <Read More>’ to the end of the resulting string and print it.
	
	INPUT SAMPLE:
	
	The first argument is a file. The file contains a text.
	
	OUTPUT SAMPLE:

	Print to stdout the text lines with their length limited according to the rules described above.
	
	CONSTRAINTS:
	
	The maximum length of a line in the input file is 300 characters.
    There cannot be more than one consequent space character in the input data.
    
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{	
		
		File inputFile = new File(args[0]);
        try 
        {
        	Scanner fileRead = new Scanner(inputFile);
        	while (fileRead.hasNextLine()) {
        		String currentLine = fileRead.nextLine();
        		// Trim current line
        		currentLine = currentLine.trim();
        		// Check if input is valid
        		if (currentLine.length() > 300) 
        		{ 
        			fileRead.close(); 
        			return; 
        		}
        		for (int i = 1; i < currentLine.length(); ++i) {
        			if (currentLine.charAt(i) == ' ' && currentLine.charAt(i-1) == ' ') 
        			{
        				fileRead.close();
        				return;
        			}
        		}
        		// Modify line accordingly
        		if (currentLine.length() <= 55)
        		{
        			System.out.println(currentLine);
        		}
        		else
        		{
        			currentLine = currentLine.substring(0, 40);
        			if (currentLine.contains(" "))
        			{
        				currentLine = currentLine.substring(0, currentLine.lastIndexOf(' '));
        			}
        			currentLine += "... <Read More>";
        			System.out.println(currentLine);
        		}
        	}
        	fileRead.close();
        }
        catch (FileNotFoundException e) 
        {
        	e.printStackTrace();
        }
	}
}
