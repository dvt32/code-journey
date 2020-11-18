package net.dvt32.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dvt32.todo.Todo;
import net.dvt32.todo.TodoService;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet 
	extends HttpServlet
{
	private LoginService userValidationService = new LoginService();
	private TodoService todoService = new TodoService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException 
	{		 
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException 
	 {	
		 String name = request.getParameter("name");
		 String password = request.getParameter("password");
		 
		 if (userValidationService.isValidUser(name, password)) {
			 request.getSession().setAttribute("name", name);
			 response.sendRedirect("/list-todos.do");
		 }
		 else {
			 request.setAttribute("errorMessage", "Invalid Credentials");
			 request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		 }
	 }
}