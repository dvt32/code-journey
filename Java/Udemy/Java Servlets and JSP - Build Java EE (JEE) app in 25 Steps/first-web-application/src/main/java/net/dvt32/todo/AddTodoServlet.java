package net.dvt32.todo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/add-todo.do")
public class AddTodoServlet 
	extends HttpServlet
{
	private TodoService todoService = new TodoService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException 
	{		 
		request.getRequestDispatcher("/WEB-INF/views/add-todo.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException 
	{	
		String newTodo = request.getParameter("todo");
		String category = request.getParameter("category");
		
		todoService.addTodo( new Todo(newTodo, category) );
		
		response.sendRedirect("/list-todos.do");
	}
	
}