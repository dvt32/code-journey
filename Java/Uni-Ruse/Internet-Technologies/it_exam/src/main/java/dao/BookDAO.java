package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Book;

@Stateless
@LocalBean
public class BookDAO
{
	@PersistenceContext(name="persistenceUnit")
	private EntityManager em;
	
	public Book getBookById(int id)
	{
		Book b = em.find(Book.class, id);
		
		return b;
	}
	
	public void addBook(String title, String publisher, int numberOfPages, String coverType)
	{
		Book b = new Book(title, publisher, numberOfPages, coverType);
		em.persist(b);
	}
	
	public List<Book> getProsvetaBooks()
	{
		Query query  = em.createNativeQuery("SELECT * FROM Book b WHERE b.publisher='Prosveta'", Book.class);
		List<Book> books = query.getResultList();
		
		return books;
	}
	
	public List<String> getAllBookTitles()
	{
		Query query  = em.createNativeQuery("SELECT title FROM Book b");
		List<String> bookTitles = query.getResultList();
		
		return bookTitles;
	}
}
