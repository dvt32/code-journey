package managed_beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.ejb.EJB;

import dao.BookDAO;
import entities.Book;

@ManagedBean(name="book")
@RequestScoped
public class Books {
	@EJB 
	BookDAO bookDAO;
	
	private List<Book> prosvetaBooks;
	private List<String> bookTitles;
	
	private String title;
	private String publisher;
	private int numberOfPages;
	private String coverType;
	
	// Constructors
	public Books() {}
	public Books(String title, String publisher, int numberOfPages, String coverType) {
		this.title = title;
		this.publisher = publisher;
		this.numberOfPages = numberOfPages;
		this.coverType = coverType;
	}
	
	// Getter methods
	public String getTitle() {
		return title;
	}
	public String getPublisher() {
		return publisher;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public String getCoverType() {
		return coverType;
	}
	
	// Setter methods
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public void setCoverType(String coverType) {
		this.coverType = coverType;
	}
	
	// Additional helper methods
	public String validateAndAdd() {
		if (!title.isEmpty() && 
			!publisher.isEmpty() && 
			!coverType.isEmpty()) 
		{
			bookDAO.addBook(title, publisher, numberOfPages, coverType);
					
			return "book_add";
		}
		else {
			return "book_error";
		}
	}
	
	public List<Book> getProsvetaBooks() {
		prosvetaBooks = bookDAO.getProsvetaBooks();
		
		return prosvetaBooks;
	}
	
	public List<String> getAllBookTitles() {
		bookTitles = bookDAO.getAllBookTitles();
		
		return bookTitles;
	}
}
