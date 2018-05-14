package net.dvt32.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id 
	@GeneratedValue
	private long id;
	
	private String name;
	private String role;
	
	public User() {}
	
	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, role=%s]", id, name, role);
	}
	
	
}
