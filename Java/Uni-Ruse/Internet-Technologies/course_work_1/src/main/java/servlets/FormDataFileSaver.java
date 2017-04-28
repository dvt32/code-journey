package servlets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormDataFileSaver extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		final String OUTPUT_FILE_PATH =  context.getRealPath("/") + "output.txt";
		
		// Read data from submitted form
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		String egnNumber = request.getParameter("egnNumber");
		
		// Save data to a file
		try {
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH, true)));
		    out.println(firstName + " " + lastName + ", " + age + " years old, EGN: " + egnNumber);
		    out.close();
		    
		    PrintWriter output = response.getWriter();
		    output.println("Info successfully saved to " + OUTPUT_FILE_PATH);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
