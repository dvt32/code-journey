package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TableGenerator
 */
public class TableGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TableGenerator() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static final int MAX_ROWS = 20;
    
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
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter output = response.getWriter();
		
		StringBuilder pageHTML = new StringBuilder(
			"<!DOCTYPE html>" +
			"<html>"+
			"<body>" +
				"<table border='1'>");
		
		int numberOfRows = new Random().nextInt(MAX_ROWS);
		
		for (int i = 0; i < numberOfRows; ++i) {
			pageHTML.append(
					"<tr>"+
						"<td bgcolor='" + getRandomColor() + "'>test</td>" +
						"<td bgcolor='" + getRandomColor() + "'>test</td>" +
					"</tr>");
		}
		
		pageHTML.append(
				"</table>" +
			"</body>" +
			"</html>");
		
		output.print(pageHTML);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
