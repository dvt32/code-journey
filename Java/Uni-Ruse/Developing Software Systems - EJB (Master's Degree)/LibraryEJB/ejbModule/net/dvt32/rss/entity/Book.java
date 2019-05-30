package net.dvt32.rss.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ejb_book")
public class Book 
	implements Serializable 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="AUTHOR")
	private String author;
	
	@Column(name="PRINTING_DATE")
	private Date printDate;
	
	@Column(name="DELIVERY_DATE")
	private Date deliveryDate;
	
	@Column(name="PAGES")
	private Integer pages;
	
	@OneToMany(mappedBy="book")
	private List<Action> actions;
	
	/*
	 * Constructors
	 */
	public Book() {
		
	}

	public Book(
		String author, 
		Date deliveryDate, 
		Integer pages,
		Date printDate, 
		String title) 
	{
		this.author = author;
		this.deliveryDate = deliveryDate;
		this.pages = pages;
		this.printDate = printDate;
		this.title = title;
	}

	/*
	 * Getters & setters
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPrintDate() {
		return printDate;
	}

	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}
	
	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	
}