package net.dvt32.logout;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dvt32.todo.Todo;
import net.dvt32.todo.TodoService;

@WebServlet(urlPatterns = "/logout.do")
public class LogoutServlet 
	extends HttpServlet
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException 
	{	
		request.getSession().invalidate();
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	 
}