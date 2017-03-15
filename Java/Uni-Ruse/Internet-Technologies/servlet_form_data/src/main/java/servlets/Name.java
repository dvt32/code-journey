// Prints each letter of a submitted message with a different font size and a different color

package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Name extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public String getRandomColor() {
    	final String HEX_DIGITS = "0123456789ABCFED";
    	final int HEX_COLOR_LENGTH = 6;
    	StringBuilder color = new StringBuilder("#");
    	
    	for (int i = 0; i < HEX_COLOR_LENGTH; ++i) {
    		int randomPosition = (int) (Math.random() * 15);
    		color.append( HEX_DIGITS.charAt(randomPosition) );
    	}
    	
    	return color.toString();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name"); // read name from submitted form
		
		response.setContentType("text/html");
		
		PrintWriter output = response.getWriter();
		
		StringBuilder pageHTML = new StringBuilder(
			"<!DOCTYPE html>"+
			"<html>" +
			"<body>"
		);
		
		if ( name != null && name.length() > 0 ) { // check if 'name' has a valid value
			for (int i = 0; i < name.length(); ++i) {
				int letterFontSizeInPt = (int) (Math.random() * 40) + 15; // generate font size in range 15-55
				String letterColorInHEX = getRandomColor();
				char currentLetter = name.charAt(i);
				pageHTML.append(
					"<span style='color:" + letterColorInHEX + "; font-size:" + letterFontSizeInPt + "pt;'>"
					+ currentLetter + 
					"</span>"
				);
			}
		}
		else {
			pageHTML.append("Something went wrong! :(");
		}
		
		pageHTML.append(
			"</body></html>"
		);
		
		output.print(pageHTML);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
