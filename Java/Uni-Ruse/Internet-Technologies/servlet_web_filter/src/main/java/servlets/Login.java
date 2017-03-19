package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if ( username.equals("admin") && password.equals("123") ) {
			HttpSession currentSession = request.getSession();
			currentSession.setAttribute("user", "admin");
			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter output = response.getWriter();
			output.print("Login succesful!");
		}
		else {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter output = response.getWriter();
			output.print("Incorrect username/password!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
