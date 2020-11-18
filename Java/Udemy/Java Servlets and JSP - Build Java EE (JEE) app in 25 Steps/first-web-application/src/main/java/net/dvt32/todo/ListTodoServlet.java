package net.dvt32.todo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/list-todos.do")
public class ListTodoServlet 
	extends HttpServlet
{
	private TodoService todoService = new TodoService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException 
	{	
		List<Todo> todos = todoService.getTodos();
		request.setAttribute("todos", todos);
		request.getRequestDispatcher("/WEB-INF/views/list-todos.jsp").forward(request, response);
	}
	
}