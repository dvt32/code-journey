package net.dvt32.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestController {
	
	@Autowired
	TodoService todoService;
	
	@RequestMapping(value="/todos")
	public List<Todo> retrieveAllTodos() {
		return todoService.retrieveTodos("dvt32");
	}
	
	@RequestMapping(value="/todos/{id}")
	public Todo retrieveTodo(@PathVariable int id) {
		return todoService.retrieveTodo(id);
	}
}
