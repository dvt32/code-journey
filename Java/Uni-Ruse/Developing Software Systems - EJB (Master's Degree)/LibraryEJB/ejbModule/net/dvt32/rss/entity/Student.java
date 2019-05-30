package net.dvt32.rss.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ejb_student")
public class Student 
	implements Serializable
{
	@Id
	@Column(name="FNUM")
	private String fNumber;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="BIRTH_DATE")
	private Date birthDate;
	
	@OneToMany(mappedBy="student")
	private List<Action> actions;

	/*
	 * Constructors
	 */
	public Student() {
		
	}

	public Student(String fNumber, String name, Date birthDate){
		this.fNumber = fNumber;
		this.name = name;
		this.birthDate = birthDate;
	}

	/*
	 * Getters & setters
	 */
	public String getFNumber() {
		return fNumber;
	}
	
	public void setFNumber(String number) {
		fNumber = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	
}