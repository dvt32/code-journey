/*
 
 22. Да се напише програма, която показва изображение в нива на сивото,
 записано във формат PGM - текст (идентификатор P2) и позволява по зададена
 чрез диалог дебелина в брой пиксели да се получи рамка на изображението,
 чрез замяна на съответния брой гранични пиксели с черни или бели според избор
 от меню. Резултатът да се показва до оригиналното изображение или в отделен прозорец
 и да може да бъде съхранен като изображение в същия формат.
 
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.*;

/*
 * Expected PGM file format:
 * 
 * - Line 1: P2 (string)
 * - Line 2: <comment> (string in the form of "# comment")
 * - Line 3: <width> <height> (2 integers separated by space)
 * - Line 4: <maxGrayValue> (integer)
 * - The next <height> number of lines should contain <width> number of integers each.
 */

public class PgmImage 
	extends Component 
{
	static class Border {
		private String color;
		private int width;
		
		public Border(String color, int width) {
			this.color = color;
			this.width = width;
		}
		
		public String getColor() {
			return color;
		}
		public int getWidth() {
			return width;
		}
	}
	
	private BufferedImage img;
	private Border border;
	
	private String fileType;
	private String comment;
	private int columnCount;
	private int rowCount;
	private int maxGrayValue;	
	private int[][] pixels;
	
	// Constructor
	public PgmImage(String pathToImage, Border border) {
		this.pixels = null;
		this.border = border;
		readImageFromFile(pathToImage);
		
		if (pixels != null) {
			if (border != null) {
				addBorderInPixelArray();
			}
			drawImageFromArray();
		}	
	}
	
	// Overrides the paint() method of the Component class
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
	
	// Overrides the method in the Component class to determine the window size
	public Dimension getPreferredSize() {
		if (img == null) {
			return new Dimension(100, 100);
		} else {			
			// Make sure the window is not too small to be seen
			return new Dimension(
				Math.max(100, img.getWidth(null)), // at least 100 pixels in width
				Math.max(100, img.getHeight(null)) // at least 100 pixels in height
			);
		}
	}
	
	// Extract data from a PGM file
	public void readImageFromFile(String pathToImage){
		try {                        		    
		    Scanner fileReader = new Scanner(new FileReader(pathToImage));
		    
		    // Process TOP 4 HEADER LINES
		    this.fileType = fileReader.nextLine();
		    if ( !fileType.equalsIgnoreCase("p2") ) {
		    	System.out.println("ERROR: Not a valid PGM image!");
		    	fileReader.close();
		    	return;
		    }
		    
	   	   	this.comment = fileReader.nextLine();
	   	   	this.columnCount = fileReader.nextInt();
	   	   	this.rowCount = fileReader.nextInt();
	   	   	this.maxGrayValue = fileReader.nextInt();	
	   		       
	   	   	System.out.println("Reading image from " + pathToImage + " of size " + rowCount + " by " + columnCount);
	   	   	
	   	   	// Process PIXEL VALUES
	   	   	this.pixels = new int[rowCount][columnCount];	
	   	   	for (int rowIndex = 0; rowIndex < rowCount; ++rowIndex) {
	   	   		for (int colIndex = 0; colIndex < columnCount; ++colIndex) {
	   	   			pixels[rowIndex][colIndex] = (int) (fileReader.nextInt() * 255.0 / maxGrayValue);
	   	   		}
	   	   	}
	   	   		
	   	   	fileReader.close();
	    } 
		catch (FileNotFoundException fe) {
	    	System.out.println("File could not be found!");
	    } 
		catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	// Draw image from array with pixel values
	private void drawImageFromArray(){
		img = new BufferedImage( pixels[0].length, pixels.length, BufferedImage.TYPE_INT_ARGB );
		for (int rowIndex = 0; rowIndex < pixels.length; ++rowIndex) {
			for (int colIndex = 0; colIndex < pixels[rowIndex].length; ++colIndex) {
				int pixelValue = pixels[rowIndex][colIndex];
				img.setRGB( colIndex, rowIndex, ((255<<24) | (pixelValue << 16) | (pixelValue << 8) | pixelValue) );		
			}	
		}		
	}
		
	// Add border in pixel array (optional) 
	public void addBorderInPixelArray() {
		int borderColor = (this.border.getColor().equals("Black")) ? 0 : 255;
		int borderWidth = this.border.getWidth();
		
		// Top border
		for (int i = 0; i < borderWidth; ++i) {
			for (int j = 0; j < pixels[i].length; ++j) {
				pixels[i][j] = borderColor;
			}
		}
		
		// Left border
		for (int i = 0; i < pixels.length; ++i) {
			for (int j = 0; j < borderWidth; ++j) {
				pixels[i][j] = borderColor;
			}
		}
		
		// Right border
		for (int i = 0; i < pixels.length; ++i) {
			for (int j = pixels[i].length-borderWidth; j < pixels[i].length; ++j) {
				pixels[i][j] = borderColor;
			}
		}
		
		// Bottom border
		for (int i = pixels.length-borderWidth; i < pixels.length; ++i) {
			for (int j = 0; j < pixels[i].length; ++j) {
				pixels[i][j] = borderColor;
			}
		}
	}
	
	// Save image to file
	public void saveImageToFile(String outputPath) 
		throws FileNotFoundException 
	{
		PrintWriter writer = new PrintWriter(outputPath);
		
		writer.println(fileType);
		writer.println(comment);
		writer.println( String.valueOf(columnCount) + " " + String.valueOf(rowCount) );
		writer.println( (border != null) ? 255 : String.valueOf(maxGrayValue) );
		for (int i = 0; i < pixels.length; ++i) {
			for (int j = 0; j < pixels[i].length; ++j) {
				writer.print(String.valueOf(pixels[i][j]) + " ");
			}
			writer.println();
		}
			
		writer.close();
	}
	
	// Get border from prompt
	public static Border getBorderFromPrompt() {
		int borderResult = JOptionPane.showConfirmDialog(
			null,
            "Do you wish to add a border to the image?",
            "Add border (optional)",
            JOptionPane.YES_NO_OPTION
        );

		if (borderResult == JOptionPane.YES_OPTION) {
			Object[] values = {"Black", "White"};
			Object selectedBorderColor = JOptionPane.showInputDialog(
				null, 
				"Choose border color", 
				"Selection", 
				JOptionPane.DEFAULT_OPTION, 
				null, 
				values, 
				"Black"
			);
			String borderColor = (selectedBorderColor != null) ? selectedBorderColor.toString() : "Black";
			
			Object selectedBorderWidth = JOptionPane.showInputDialog("Border width (px): ");
			int borderWidth = (selectedBorderWidth != null) ? Integer.valueOf((String) selectedBorderWidth) : 0;
			
			return new Border(borderColor, borderWidth);
		}
		
		return null;
	}

	// Main method
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame("PGM Image Reader");
		
		// Open PGM file from system
		final JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter( new FileNameExtensionFilter(".PGM", "pgm", "PGM image") );
		fileChooser.showOpenDialog(mainFrame);
		String pathToImage = fileChooser.getSelectedFile().getAbsolutePath();
		
		// Prompt for border & create image
		Border border = getBorderFromPrompt();
		PgmImage img = new PgmImage(pathToImage, border);
		
		// Offer to save the image on exit
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int saveResult = fileChooser.showSaveDialog(mainFrame);
				if (saveResult == JFileChooser.CANCEL_OPTION) {
					System.out.println("No file was saved.");
				}
				else {
					String outputPath = fileChooser.getSelectedFile().getAbsolutePath() + ".pgm";
					try {
						img.saveImageToFile(outputPath);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					System.out.println("Saved image to " + outputPath);
				}
				System.exit(0);
			}
		});
		
		mainFrame.add(img);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
}