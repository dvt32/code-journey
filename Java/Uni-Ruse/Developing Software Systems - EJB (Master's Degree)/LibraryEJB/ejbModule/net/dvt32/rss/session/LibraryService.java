package net.dvt32.rss.session;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import net.dvt32.rss.entity.Action;
import net.dvt32.rss.entity.Book;
import net.dvt32.rss.entity.Student;

/**
 * The remote Library Service interface
 * 
 * @author Milen (first version)
 * @author dvt32 (updates to interface)
 */
@Remote
public interface LibraryService {
	
	/**
	 * Used for creating a new student
	 * 
	 * @param student The Student instance to create
	 */
	public void createStudent(Student student);
	
	/**
	 * Removes a student by his primary key
	 * 
	 * @param fNum The PK of the Student to remove
	 * @return true if the student was removed, false otherwise
	 */
	public boolean removeStudent(String fNum);
	
	/**
	 * Creates and saves a new Action
	 * 
	 * @param action The action to create
	 */
	public void createAction(Action action);

	/**
	 * Creates and saves a Book entity
	 * 
	 * @param book The book to create
	 */
	public void createBook(Book book);
	
	/**
	 * Connects this action to its referenced objects
	 */
	public void connectActionToReferences(Action action, Student student, Book book);
	
	/**
	 * Retrieves the actions by their type
	 */
	public List getAllActionsByTypeNamed(String type);
	
	/**
	 * Retrieves the List of results by the ejbql and specified params
	 * 
	 * @param ejbql The query string
	 * @param params The query parameters
	 * @return The result as list
	 */
	public List getDynamicQueryResult(String ejbql, Map<String, Object> params);
	
}
