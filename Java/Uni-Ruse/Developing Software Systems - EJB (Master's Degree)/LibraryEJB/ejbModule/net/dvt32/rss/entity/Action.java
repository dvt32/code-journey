package net.dvt32.rss.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="ejb_action")
// @SequenceGenerator(name="ActionSequence", initialValue=50, allocationSize=1, sequenceName="ACTION_SEQUENCE")
// @TableGenerator(name="ActionTableGenerator", table="SEQUENCES", initialValue=0, pkColumnName="PK_NAME", pkColumnValue="Action", valueColumnName="PK_VALUE", allocationSize=1)
@NamedQueries(
	@NamedQuery(name="actionByType", query="From Action a WHERE a.type = ?1")
)
public class Action 
	implements Serializable
{
	@Id
	@Column(name = "ID")
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ActionSequence")
	// @GeneratedValue(strategy = GenerationType.TABLE, generator="ActionTableGenerator")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="TYPE")
	private String type;
	
	@Column(name="ACTION_DATE")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	/*
	 * Constructors
	 */
	public Action(Date date, String type) {
		this.date = date;
		this.type = type;
	}

	public Action() {
		
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}