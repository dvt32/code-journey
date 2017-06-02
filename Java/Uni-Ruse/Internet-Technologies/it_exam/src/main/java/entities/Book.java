package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue
	private int id;
	
	private String title;
	private String publisher;
	private int numberOfPages;
	private String coverType;
	
	// Constructors
	public Book() {}
	public Book(String title, String publisher, int numberOfPages, String coverType) {
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
}

