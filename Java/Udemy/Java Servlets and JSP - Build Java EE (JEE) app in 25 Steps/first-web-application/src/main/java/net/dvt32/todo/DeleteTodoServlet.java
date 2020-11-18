package net.dvt32.todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/delete-todo.do")
public class DeleteTodoServlet 
	extends HttpServlet
{
	private TodoService todoService = new TodoService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException 
	{	
		String todoName = request.getParameter("todo");
		String todoCategory = request.getParameter("category");
		todoService.deleteTodo( new Todo(todoName, todoCategory) );
		response.sendRedirect("/list-todos.do");
	}
	
}