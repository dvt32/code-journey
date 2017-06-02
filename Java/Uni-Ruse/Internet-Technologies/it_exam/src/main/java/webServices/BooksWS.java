package webServices;

import java.util.List;

import javax.ejb.EJB;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.BookDAO;

@Path("books")
public class BooksWS
{
	@EJB 
	BookDAO bookDAO;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllBookTitles()
	{
		List<String> bookTitles = bookDAO.getAllBookTitles();
	
		return bookTitles.toString();
	}
	
}
