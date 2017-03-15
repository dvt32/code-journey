package servlets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String captchaText = generateCaptchaText(4);
		BufferedImage captchaImage = generateCaptchaImage(captchaText);
		
		response.setContentType("image/bmp");
		
		OutputStream outputStream = response.getOutputStream(); // binary output stream, which is used to send the image
		ImageIO.write(captchaImage, "bmp", outputStream);
	}
	
	protected String generateCaptchaText(int captchaLength) {
		StringBuilder captchaText = new StringBuilder();
		
		for (int i = 0; i < captchaLength; ++i) {
			int randomUppercaseLetterASCII = (int) ( Math.random() * 25 ) + 65; // code is in range 65..90 (65 = 'A', 90 = 'Z')
			char randomUppercaseLetter = (char) randomUppercaseLetterASCII;
			captchaText.append(randomUppercaseLetter);
		}
		
		return captchaText.toString();
	}
	
    protected Color getRandomColor() {
    	int red = (int) (Math.random() * 255);
    	int green = (int) (Math.random() * 255);
    	int blue = (int) (Math.random() *  255);
    	
    	Color randomColor = new Color(red, green, blue);
    	
    	return randomColor;
    }
    
	protected BufferedImage generateCaptchaImage(String captchaText) {
		int imageWidth = 100;
		int imageHeight = 50;
		
		BufferedImage captchaImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
		Graphics g = captchaImage.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(1, 1, imageWidth-2, imageHeight-2);
		
		// Draw each letter differently
		for (int i = 0; i < captchaText.length(); ++i) {
			Color letterColor = getRandomColor();
			g.setColor(letterColor);
			
			int fontSizeInPt = (int) (Math.random() * 15) + 15; // range is 15..30
			Font letterFont = new Font("Arial", Font.BOLD, fontSizeInPt);
			g.setFont(letterFont);
			
			int letterDrawPositionX = 10 + 20*i;
			int letterDrawPositionY = 30;
			g.drawString( String.valueOf(captchaText.charAt(i)), letterDrawPositionX, letterDrawPositionY );
		}
		
		return captchaImage;
	}
}
